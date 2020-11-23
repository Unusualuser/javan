package Practice_23_24;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;


public class Request {
    static int id = 1;
    static Gson  gson = new Gson();
    static HttpClient httpClient = HttpClient.newHttpClient();
    static String path = "src/main/java/Practice_23_24/db.json";
    public static void main(String[] args) throws InterruptedException {
        id = 1;
        while (true) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create("http://80.87.199.76:3000/tasks/" + id))
                        .build();
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if(gson.fromJson(response.body(), Task.class).getId() == id) {
                    System.out.println(gson.fromJson(response.body(), Task.class));
                    System.out.println(gson.fromJson(response.body(), Task.class).getExpression());
                    reporter(worker(gson.fromJson(response.body(), Task.class).getExpression()));
                    id = id + 1;
                }
            }
            catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            TimeUnit.SECONDS.sleep((long)(Math.random() * 2) - 1);
        }
    }
    public static double worker(String expression) {
        expression = expression.replace(" ", "");
        double answer = 0;
        Pattern pattern = Pattern.compile("(?<first>[-]*\\d+)(?<sign>[*+/-])(?<second>[-]*\\d+)");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            if (matcher.group("sign").contains("+")) {
                answer = parseInt(matcher.group("first")) + parseInt(matcher.group("second"));
            }
            else if (matcher.group("sign").contains("-")) {
                answer = parseInt(matcher.group("first")) - parseInt(matcher.group("second"));
            }
            else if (matcher.group("sign").contains("/")) {
                answer = (double) parseInt(matcher.group("first")) / (double) parseInt(matcher.group("second"));
            }
            else if (matcher.group("sign").contains("*")) {
                answer = parseInt(matcher.group("first")) * parseInt(matcher.group("second"));
            }
        }
        answer = Math.ceil(answer * 100) / 100;
        return answer;
    }

    public static void reporter(double answer) throws IOException, InterruptedException {
        Report report = new Report(id, answer);
        ArrayList <Integer> taskIds = new ArrayList<>();
        String text, fullText = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            text = reader.readLine();
            while (text != null) {
                fullText += text + "\n";
                text = reader.readLine();
            }
            int count = 1;
            while(true) {
                if(fullText.contains("\"taskId\":" + count)) {
                    taskIds.add(count);
                    count++;
                }
                else {
                    break;
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(taskIds.toString());
        System.out.println(answer);
        System.out.println(report.toString());
        if(!taskIds.contains(id)) {
        try {
            String body = gson.toJson(report);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .uri(URI.create("http://80.87.199.76:3000/reports"))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
            try {
                FileWriter writer = new FileWriter(path, true);
                if (report.getTaskId() != 1) {
                    writer.write(",");
                }
                writer.write("\n" + gson.toJson(report).replace(",", ",\n    ").replace("{", "{\n    ").replace("}", "\n}"));
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
