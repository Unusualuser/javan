package Practice_12;

public class Enum {
    public static void main(String[] args) {
        printLineWithColor("Hi, guys, it`s me", Colors.BLUE);
    }
    public static void printLineWithColor(String line, Colors color) {
        System.out.println(color.getColor() + line + "\u001B[0m");
    }
}
