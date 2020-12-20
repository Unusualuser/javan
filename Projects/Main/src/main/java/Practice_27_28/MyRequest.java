package Practice_27_28;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class MyRequest {
    static int id = 1;
    static Gson gson = new Gson();
    static HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create("http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks/" + id))
                        .build();
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                DoAction doAction = new DoAction();
                if(gson.fromJson(response.body(), MyTask.class).getId() == id) {
                    System.out.println(gson.fromJson(response.body(), MyTask.class));
                    for (Method m : DoAction.class.getDeclaredMethods()) {
                        if (m.isAnnotationPresent(DoActionAnnotation.class) && m.getAnnotation(DoActionAnnotation.class).purpose().equals(gson.fromJson(response.body(), MyTask.class).getType())) {
                            try {
                                m.invoke(doAction, (gson.fromJson(response.body(), MyTask.class)).getData());
                            } catch (InvocationTargetException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    id = id + 1;
                }
            }
            catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            TimeUnit.SECONDS.sleep((long)(Math.random() * 2) - 1);
        }
    }

}
