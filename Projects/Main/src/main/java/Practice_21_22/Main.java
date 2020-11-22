package Practice_21_22;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Где вы хотите работать с объектами?\n" +
                "1 - На сервере\n" +
                "2 - Локально в файле");
        int choice = scanner.nextInt();
        if (choice == 1) {
            EditServer server = new EditServer();
            server.Console();
        }
        else if (choice == 2) {
            EditFile file = new EditFile();
            file.Console();
        }
    }
}
