package Practice_15_16;

import java.util.Scanner;

public class Graph {
    private Scanner scanner = new Scanner(System.in);

    public void s1(int number) {
        if (number == 1) {
            System.out.println("add_library");
            s5(scanner.nextInt());
        }
        else if (number == 0) {
            System.out.println("create_project");
            s2(scanner.nextInt());
        }
        else return;
    }

    public void s2(int number) {
        if (number == 1) {
            System.out.println("drop_db");
            s4(scanner.nextInt());
        }
        else if (number == 0) {
            System.out.println("test");
            s3(scanner.nextInt());
        }
        else return;
    }

    public void s3(int number) {
        if (number == 1) {
            System.out.println("add_library");
            s5(scanner.nextInt());
        }
        else if (number == 0) {
            System.out.println("drop_db");
            s4(scanner.nextInt());
        }
        else return;
    }

    public void s4(int number) {
        if (number == 1) {
            System.out.println("deploy");
            s5(scanner.nextInt());
        }
        else if (number == 0) {
            System.out.println("restart");
            s3(scanner.nextInt());
        }
        else return;
    }

    public void s5(int number) {
        if (number == 1) {
            System.out.println("restart");
            s3(scanner.nextInt());
        }
        else if (number == 0) {
            System.out.println("deploy");
            s1(scanner.nextInt());
        }
        else return;
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.s1(graph.scanner.nextInt());
    }
}
