package Practice_15_16;

import java.util.Scanner;

public class Graph {
    private String action0;
    private String action1;
    private Graph next0;
    private Graph next1;
    public static Scanner scanner = new Scanner(System.in);

    public Graph(String action0, String action1) {
        this.action0 = action0;
        this.action1 = action1;
    }

    public void setNext(Graph next0, Graph next1) {
        this.next0 = next0;
        this.next1 = next1;
    }

    public void s(int number) {
        if (number == 0) {
            System.out.println(action0);
            next0.s(scanner.nextInt());
        }
        else if (number == 1) {
            System.out.println(action1);
            next1.s(scanner.nextInt());
        }
        else return;
    }

    public static void main(String[] args) {
        Graph s1 = new Graph("create_project", "add_library");
        Graph s2 = new Graph("test", "drop_db");
        Graph s3 = new Graph("drop_db", "add_library");
        Graph s4 = new Graph("restart", "deploy");
        Graph s5 = new Graph("deploy", "restart");
        s1.setNext(s2,s5);
        s2.setNext(s3,s4);
        s3.setNext(s4,s5);
        s4.setNext(s3,s5);
        s5.setNext(s1,s3);

        s1.s(scanner.nextInt());
    }

}
