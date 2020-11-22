package Practice_17_18;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String basePath = "src/";
        String newFile = basePath + "Practice_17_18" + "/report.md";
        File file = new File(basePath);
        String[] list = file.list();
        ArrayList<String[]> lists = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            file = new File(basePath + list[i]);
            lists.add(file.list());
        }

//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i] + Arrays.toString(lists.get(i)));
//        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < lists.get(i).length; j++) {
                file = new File(basePath + list[i] + "/" + lists.get(i)[j]);
                String mainFilePath = file.getAbsolutePath();
                BufferedReader reader = new BufferedReader(new FileReader(mainFilePath));
                FileWriter writer = new FileWriter(newFile, true);
                try {
                    String line = reader.readLine();
                    if (j == 0) {
                        writer.write("#" + list[i]);
                        writer.write('\n');
                    }
                    writer.write("##" + lists.get(i)[j]);
                    writer.write('\n');
                    writer.write("```java");
                    writer.write('\n');
                    while (line != null) {
                        writer.write(line);
                        writer.write('\n');
                        line = reader.readLine();
                    }
                    writer.write("```");
                    writer.write('\n');
                } catch (FileNotFoundException e) {
                    System.out.println("Incorrect file path");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
            }
        }
    }
}
