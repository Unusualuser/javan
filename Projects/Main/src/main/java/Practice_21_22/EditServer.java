package Practice_21_22;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class EditServer implements ItemsStore {
    static HttpClient httpClient = HttpClient.newHttpClient();
    static Gson gson = new Gson();
    static Scanner scanner = new Scanner(System.in);

    public void Console() throws IOException, InterruptedException {
        while (true) {
            System.out.println("Что нужно сделать?\n" +
                    "1 - Получить все объекты\n" +
                    "2 - Получить один объект\n" +
                    "3 - Редактировать объект\n" +
                    "4 - Добавить объект\n" +
                    "5 - Удалить объект");
            int choice = scanner.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println(getAll().toString());
                    break;
                case 2:
                    System.out.println("Введите id объекта");
                    id = scanner.nextInt();
                    System.out.println(get(id).toString());
                    break;
                case 3:
                    System.out.println("Введите id объекта для редактирования");
                    id = scanner.nextInt();
                    System.out.println("Что вы хотите изменить?(Для изменения нескольких параметров запишите их слитно)\n" +
                            "1 - id\n" +
                            "2 - data\n" +
                            "3 - isGood\n" +
                            "4 - description\n");
                    String changes = new Scanner(System.in).nextLine();
                    int editedId = id;
                    String editedData = get(id).getData();
                    boolean editedIsGood = get(id).isGood();
                    String editedDescription = get(id).getDescription();
                    if(changes.contains("1")){
                        System.out.println("Введите новый id");
                        editedId = scanner.nextInt();
                    }
                    if(changes.contains("2")) {
                        System.out.println("Введите новое значение data");
                        editedData = new Scanner(System.in).nextLine();
                    }
                    if(changes.contains("3")){
                        System.out.println("Введите новое значение isGood (true or false)");
                        editedIsGood = scanner.nextBoolean();
                    }
                    if(changes.contains("4")){
                        System.out.println("Введите новое значение description");
                        editedDescription = new Scanner(System.in).nextLine();
                    }
                    Item editedItem = new Item(editedId, editedData, editedIsGood, editedDescription);
                    System.out.println("Изменённый объект: " + editItem(id, editedItem).toString());
                    break;
                case 4:
                    System.out.println("Введите id нового объекта");
                    int newId = scanner.nextInt();
                    System.out.println("Введите data нового объекта");
                    String newData = new Scanner(System.in).nextLine();
                    System.out.println("Введите isGood нового объекта");
                    boolean newIsGood = scanner.nextBoolean();
                    System.out.println("Введите description нового объекта");
                    String newDescription = new Scanner(System.in).nextLine();
                    Item newItem = new Item(newId, newData, newIsGood, newDescription);
                    System.out.println("Объект " + addItem(newItem).toString() +  " добавлен");
                    break;
                case 5:
                    System.out.println("Введите id удаляемого объекта");
                    id = scanner.nextInt();
                    if(deleteItem(id)) {
                        System.out.println("Объект с id " + id + " удалён");
                    }
                    break;
            }
        }
    }

    @Override
    public List<Item> getAll() throws IOException, InterruptedException {
        List<Item> items = null;
        try {
            Type collectionType = new TypeToken<Collection<Item>>() {
            }.getType();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://80.87.199.76:3000/objects"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            items = gson.fromJson(response.body(), collectionType);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item get(int id) {
        Item item = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://80.87.199.76:3000/objects/" + id))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            item = gson.fromJson(response.body(), Item.class);
            System.out.println(gson.fromJson(response.body(), Item.class));
        }
        catch (InterruptedException | IOException e) {
        e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item editItem(int id, Item item) {
        try {
            String body = gson.toJson(item);
            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .uri(URI.create("http://80.87.199.76:3000/objects/" + id))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return item;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Item addItem(Item item) {
        try {
            String body = gson.toJson(item);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .uri(URI.create("http://80.87.199.76:3000/objects"))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return item;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteItem(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .DELETE()
                    .uri(URI.create("http://80.87.199.76:3000/objects/" + id))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return true;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
