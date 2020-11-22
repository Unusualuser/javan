package Practice_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditFile implements ItemsStore{
    Scanner scanner = new Scanner(System.in);
    private File jsonFile = new File("Z:\\Файлы\\JAVA\\javan\\Projects\\Main\\src\\main\\java\\Practice_21_22\\data.json");
    Gson gson = new Gson();

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
        String text, fullText = "";
        ArrayList<Item> items = new ArrayList<>();
        Type collectionType = new TypeToken<Collection<Item>>() {
        }.getType();
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            text = reader.readLine();
            while (text != null) {
                fullText += text + "\n";
                text = reader.readLine();
            }
            items = gson.fromJson(fullText, collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item get(int id) throws IOException, InterruptedException {
        Item item = null;
        for (Item item1 : getAll()) {
            if (item1.getId() == id) {
                item = item1;
                break;
            }
        }
        return item;
    }

    @Override
    public Item addItem(Item item) {
        try
        {
            FileWriter writer = new FileWriter(jsonFile, true);
            if(item.getId() != 1) {
                writer.write(",");
            }
            writer.write("\n"+gson.toJson(item).replace(",", ",\n    ").replace("{", "{\n    ").replace("}", "\n}"));
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item editItem(int id, Item item) {
        deleteItem(id);
        addItem(item);
        return item;
    }

    @Override
    public boolean deleteItem(int id) {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
            String text = null, allItems, fullText = "";
            while((text = reader.readLine()) != null)
            {
                fullText += text + "\n";
            }
            reader.close();
            allItems = fullText;
            Pattern pattern = Pattern.compile(".+\n.+" + id +",\n.+\n.+\n.+");
            Matcher matcher = pattern.matcher(allItems);
            if(matcher.find())
            {
                allItems = matcher.replaceAll("");
            }
            FileWriter writer = new FileWriter(jsonFile);
            writer.write(allItems);
            writer.close();
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
