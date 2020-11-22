package Practice_12;

public class Enum {
    public static void main(String[] args) {
        printLineWithColor("Hi", Colors.BLUE);
        printLineWithColor("guys,", Colors.GREEN);
        printLineWithColor("it`s", Colors.RED);
        printLineWithColor("me", Colors.PINK);
    }
    public static void printLineWithColor(String line, Colors color) {
        System.out.println(color.getColor() + line + "\u001B[0m");
    }
}
