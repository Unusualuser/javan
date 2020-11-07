#More
##Change.java
```java
package More;

public class Change {
    public int search(int x, int y) {
        if (x == 0)
            return 1;
        if (x < 0)
            return 0;
        if (y == 5)
            return search(x - 5, 5) + search(x - 3, 3) + search(x - 1, 1);
        if (y == 3)
            return search(x - 3, 3) + search(x - 1, 1);
        if (y == 1)
            return search(x - 1, 1);
        return 0;
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.search(8524, 5));
    }
}
```
##Threads.java
```java
package More;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    //    static AtomicInteger totalSum = new AtomicInteger();
    static int totalSum;
    static int[] arrTotalSum = new int [4];
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <  4; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + (int)(arrTotalSum[0]+arrTotalSum[1]+arrTotalSum[2]+arrTotalSum[3]));
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000, i);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork(int start, int count, int index) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            arrTotalSum[index]++;
        }
        return a;
    }
}
```
#Practice_1
##Main.java
```java
package Practice_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ex1();
        ex2(args);
        ex3();
        ex4();
        ex5();
    }

    public static void ex1() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        System.out.println("Ex1 \nСумма, посчитанная циклом for = " + result);
        int i = 0;
        result = 0;
        while (i < array.length) {
            result += array[i];
            i++;
        }
        System.out.println("Сумма, посчитанная циклом while = " + result);
        result = 0;
        i = 0;
        do {
            result += array[i];
            i++;
        } while (i < array.length);
        System.out.println("Сумма, посчитанная циклом do while = " + result);
    }

    public static void ex2(String[] args) {
        System.out.println("Ex2");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Arguments[" + i + "] : " + args[i]);
        }
    }

    public static void ex3() {
        System.out.println("Ex3");
        for (float i = 1; i < 11; i++) {
            System.out.printf("%.2f \n", 1 / i);
        }
    }

    public static void ex4() {
        System.out.println("Ex4");
        int[] array = new int [10];
        for (int i = 0; i < 5; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
        }
        for (int i = 5; i < 10; i++) {
            Random r = new Random();
            array[i] = r.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.print("\nSorted: ");
        Arrays.sort(array);
        for(int i = 0; i < 10; i ++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void ex5() {
        int result = 1;
        for (int i = 1; i < 8; i++) {
            result += result * i;
        }
        System.out.println("\nEx5 \n" + result);
    }
}

```
#Practice_10
##Calc.java
```java
package Practice_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Calc extends JFrame {

    public Calc(){
        setTitle("Pretty calc =)");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        //GridLayout layout = new GridLayout(2, 4);
        //panel1.setLayout(layout);

        JLabel label1 = new JLabel("The first number");
        label1.setBounds(15, 23, 120, 20);
        panel1.add(label1);

        JTextField first = new JTextField(10);
        first.setBounds(120, 20, 150, 30);
        panel1.add(first);

        JLabel label2 = new JLabel("The second number");
        label2.setBounds(290,23,120,20);
        panel1.add(label2);

        JTextField second = new JTextField(10);
        second.setBounds(410, 20, 150, 30);
        panel1.add(second);


        JTextField res = new JTextField();
        res.setBounds(225, 150, 150, 30);
        panel1.add(res);


        JButton buttonAdd = new JButton("+");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) + Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonAdd.setBounds(125, 70, 50, 50);
        panel1.add(buttonAdd);

        JButton buttonSub = new JButton("-");
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) - Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonSub.setBounds(225, 70, 50, 50);
        panel1.add(buttonSub);

        JButton buttonMul = new JButton("*");
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) * Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonMul.setBounds(325, 70, 50, 50);
        panel1.add(buttonMul);

        JButton buttonDiv = new JButton("/");
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    Double s = Double.parseDouble(first.getText()) / Double.parseDouble(second.getText());
                    res.setText(String.format("%.4f", s));
                }
                catch(Exception e) {
                    res.setText("ERROR");
                }
            }
        });
        buttonDiv.setBounds(425, 70, 50, 50);
        panel1.add(buttonDiv);


        add(panel1);
        panel1.setLayout(null);
        setVisible(true);

//        JButton buttonAdd = new JButton("+");
//        buttonAdd.setBounds(40, 90, 85, 20);
//        buttonAdd.addActionListener(action -> {
//            clickCount++;
//            label.setText(field.getText());
//        });
//        JPanel panel = new JPanel();
//        GridLayout layout = new GridLayout(3, 2);
//        panel.setLayout(layout);
//        panel.add(label);
//        panel.add(buttonAdd);
//        JPanel secondPanel = new JPanel();
//        secondPanel.add(field);
//        secondPanel.add(new JButton("+"));
//        panel.add(secondPanel);
//        panel.add(new JButton("!!"));
//        panel.add(new JButton("!!"));
//        add(panel);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
```
##Main.java
```java
package Practice_10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calc app = new Calc();
            app.setVisible(true);
        });
    }
}
```
#Practice_11
##Threads.java
```java
package Practice_11;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    static int totalSum;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            work(i, 0);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time_1: " + (endTime - startTime));
        System.out.println("total sum_1: " + totalSum);


        startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI, 0));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time_2: " + (endTime - startTime));
        System.out.println("total sum_2: " + totalSum);
        totalSum = 0;

        threads.clear();
        startTime = System.currentTimeMillis();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI, 1));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time_3: " + (endTime - startTime));
        System.out.println("total sum_3: " + totalSum);
    }

    private static void work(int i, int state) {
        long startTime = System.currentTimeMillis();
        long result;
        if (state == 0) {
            result = doHardWork_1(i * 1000, 100_000_000);
        }
        else {
            result = doHardWork_2(i * 1000, 100_000_000);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork_1(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += Math.sqrt(Math.sqrt(start + i) * Math.sqrt(start + i) * Math.sqrt(start + i));
            totalSum++;
        }
        return a;
    }

    private synchronized static long doHardWork_2(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += Math.sqrt(Math.sqrt(start + i) * Math.sqrt(start + i) * Math.sqrt(start + i));
            totalSum++;
        }
        return a;
    }
}
```
#Practice_12
##Colors.java
```java
package Practice_12;

public enum Colors {
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    PINK("\u001B[95m"),
    BLACK("\u001B[30m"),
    YELLOW("\u001B[33m"),
    RED("\u001B[31m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

```
##Enum.java
```java
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
```
#Practice_13
##Human.java
```java
package Practice_13;

public class Human {
    private int height;
    private int weight;
    private String name;

    public void setHeight(int height) throws Exception {
        if (height < 30 || height > 300) {
            throw new Exception();
        }
        this.height = height;
    }

    public void setWeight(int weight) throws HumanStatsException {
        if (weight < 2 || weight > 300) {
            throw new HumanStatsException();
        }
        this.weight = weight;
    }

    public void setName(String name) throws  MyNewException{
        if (name.length() > 10)  {
            throw new MyNewException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
```
##HumanStatsException.java
```java
package Practice_13;

public class HumanStatsException extends IllegalArgumentException{
}
```
##Main.java
```java
package Practice_13;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        try {
            human.setHeight(195);
            human.setWeight(301);
        }

        catch (HumanStatsException hse) {
            System.out.println("Weight is incorrect");
        }

        catch (Exception ex) {
            System.out.println("Height is incorrect");
        }

        finally {
            System.out.println(human);
        }
        human.setName("Andrewnewnew");
    }
}
```
##MyNewException.java
```java
package Practice_13;

public class MyNewException extends RuntimeException{
}
```
#Practice_14
##WithoutRegex.java
```java
package Practice_14;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class WithoutRegex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] keys = new String[count];
        String[] values = new String[count];
        for (int i = 0; i < count; i++) {
            keys[i] = scanner.next();
            values[i] = scanner.next();
        }
        String line = scanner.next();
        System.out.println(StringUtils.replaceEach(line, keys, values));
    }
}
```
##WithRegex.java
```java
package Practice_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Pattern pat = Pattern.compile("(?<rule>\\w+) (?<on>\\w+)");
        ArrayList <Matcher> matchers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            matchers.add(pat.matcher(scanner.nextLine()));
        }
        String line = scanner.next();
        StringBuffer buffer = new StringBuffer();
        HashMap<String, String> dict = new HashMap<String, String>();
        for (Matcher matcher:matchers) {
            if(matcher.find()) {
                buffer.append(matcher.group("rule"));
                if (matcher != matchers.get(count - 1)) {
                    buffer.append("|");
                }
                dict.put(matcher.group("rule"), matcher.group("on"));
            }
        }
        Pattern pattern = Pattern.compile(buffer.toString());
        Matcher matcher = pattern.matcher(line);
        line =  matcher.replaceAll(var -> dict.get(var.group()));
        System.out.println(line);
    }
}
```
#Practice_15_16
##Graph.java
```java
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
```
#Practice_17_18
##Main.java
```java
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
```
#Practice_2
##Ball.java
```java
package Practice_2;

public class Ball {
    float volume = 13.4f;
}
```
##Book.java
```java
package Practice_2;

public class Book {
    int page = 100;
}
```
##Dog.java
```java
package Practice_2;

public class Dog {
    String nickname = "Buddy";
    int age = 7;

    @Override
    public String toString() {
        return "Dog{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public String getNickname() {
        return nickname;
    }

    public int humanAge() {
        return age*7;
    }
}
```
##DogKennel.java
```java
package Practice_2;

import java.util.ArrayList;

class DogKennel {
    ArrayList <Dog> array = new ArrayList<>();

    public void addArray(Dog obj) {
        array.add(obj);
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel();
        Dog doggy = new Dog("Nick", 5);
        kennel.addArray(doggy);
    }
}
```
##Shape.java
```java
package Practice_2;

public class Shape {
    String color;
    boolean filled;

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + getColor() + '\'' +
                ", filled='" + getFilled() + '\'' +
                '}';
    }

    public Shape() {

    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean getFilled() {
        return filled;
    }

    public static void main(String[] args) {

    }
}
```
##ShapeTest.java
```java
package Practice_2;

class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.setColor("blue");
        shape.setFilled(true);
        System.out.println(shape.toString());
    }
}
```
#Practice_3
##Book.java
```java
package Practice_3;

public class Book {
    String author;
    String name;
    int theYearOfPublishing;
    int pages;

    public Book(String author, String name, int theYearOfPublishing, int pages) {
        this.author = author;
        this.name = name;
        this.theYearOfPublishing = theYearOfPublishing;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTheYearOfPublishing() {
        return theYearOfPublishing;
    }

    public void setTheYearOfPublishing(int theYearOfPublishing) {
        this.theYearOfPublishing = theYearOfPublishing;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + getAuthor() + '\'' +
                ", name='" + getName() + '\'' +
                ", theYearOfPublishing=" + getTheYearOfPublishing() +
                ", pages=" + getPages() +
                '}';
    }
}
```
##BookTest.java
```java
package Practice_3;

class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Andrew", "book", 2020, 101);
        System.out.println(book.toString());
    }
}
```
##Circle.java
```java
package Practice_3;

public class Circle {
    double radius = 1;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                '}';
    }
}
```
##CircleTest.java
```java
package Practice_3;

class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(12);
        System.out.println(circle.toString());
    }
}
```
##Hand.java
```java
package Practice_3;

public class Hand {
    int fingers;

    public Hand(int fingers) {
        this.fingers = fingers;
    }

    public int getFingers() {
        return fingers;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Hand{" +
                "fingers=" + fingers +
                '}';
    }
}
```
##Head.java
```java
package Practice_3;

public class Head {
    boolean haired;

    public Head(boolean haired) {
        this.haired = haired;
    }

    public boolean getHaired() {
        return haired;
    }

    public void setHaired(boolean haired) {
        this.haired = haired;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Head{" +
                "haired=" + haired +
                '}';
    }
}
```
##Human.java
```java
package Practice_3;

public class Human {
    String name;
    int height;
    Hand leftH;
    Hand rightH;
    Head head;
    Leg leftL;
    Leg rightL;
    protected double weight;

    public Human(String name, int height, Hand leftH, Hand rightH, Head head, Leg leftL, Leg rightL, double weight) {
        this.name = name;
        this.height = height;
        this.leftH = leftH;
        this.rightH = rightH;
        this.head = head;
        this.leftL = leftL;
        this.rightL = rightL;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Hand getLeftH() {
        return leftH;
    }

    public void setLeftH(Hand leftH) {
        this.leftH = leftH;
    }

    public Hand getRightH() {
        return rightH;
    }

    public void setRightH(Hand rightH) {
        this.rightH = rightH;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeftL() {
        return leftL;
    }

    public void setLeftL(Leg leftL) {
        this.leftL = leftL;
    }

    public Leg getRightL() {
        return rightL;
    }

    public void setRightL(Leg rightL) {
        this.rightL = rightL;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", left_h=" + leftH +
                ", right_h=" + rightH +
                ", head=" + head +
                ", left_l=" + leftL +
                ", right_l=" + rightL +
                ", weight=" + weight +
                '}';
    }
}
```
##HumanTest.java
```java
package Practice_3;

class HumanTest {
    public static void main(String[] args) {
        Hand leftH = new Hand(5);
        Hand rightH = new Hand(4);
        Head head = new Head(true);
        Leg leftL = new Leg(100);
        Leg rightL = new Leg(101);
        Human andrew = new Human("Andrew", 195, leftH, rightH, head, leftL, rightL, 75);
        System.out.println(andrew.toString());
    }
}
```
##Leg.java
```java
package Practice_3;

public class Leg {
    double length;

    public Leg(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Leg{" +
                "length=" + length +
                '}';
    }
}
```
#Practice_4
##Circle.java
```java
package Practice_4;

class Circle extends Shape {
    double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.filled = filled;
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
##Rectangle.java
```java
package Practice_4;

class Rectangle extends Shape {
    double width;
    double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        this.filled = filled;
        this.color = color;
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
##Shape.java
```java
package Practice_4;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
##ShapeTest.java
```java
package Practice_4;

public class ShapeTest {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());

        Circle c1 = (Circle) s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());

        Rectangle r1 = (Rectangle) s3;
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(r2.getLength());

        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

    }
}
```
##Square.java
```java
package Practice_4;

class Square extends Rectangle {
    double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        this.filled = filled;
        this.color = color;
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setWidth(double side) {
        this.width = side;
    }

    public void setLength(double side) {
        this.length = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + getSide() +
                ", width=" + getWidth()+
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
#Practice_5
##Circle.java
```java
package Practice_5;

class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.setFilled(filled);
        this.setColor(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
##Movable.java
```java
package Practice_5;

public interface Movable {
    public void moveUp();

    public void moveDown();

    public void moveLeft();

    public void moveRight();
}
```
##MovableCircle.java
```java
package Practice_5;

public class MovableCircle extends Circle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveDown() {
        this.center.moveDown();
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }

    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }

    @Override
    public void moveRight() {
        this.center.moveRight();
    }
}
```
##MovableCircleTest.java
```java
package Practice_5;

class MovableCircleTest {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        MovableCircle circle = new MovableCircle(10, point);
        System.out.println(circle.toString());
        circle.moveUp();
        circle.moveLeft();
        System.out.println(circle.toString());
    }
}
```
##MovablePoint.java
```java
package Practice_5;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        this.y += this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y -= this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x += this.xSpeed;
    }
}
```
##MovableRectangle.java
```java
package Practice_5;

public class MovableRectangle extends Rectangle implements Movable  {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;
    private Rectangle rectangle;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed,ySpeed);
        this.bottomRight = new MovablePoint(x2, y2,xSpeed, ySpeed);
        this.rectangle = new Rectangle(Math.abs(x1-x2), Math.abs(y1-y2));
        super.setWidth(Math.abs(y2 -y1));
        super.setLength(Math.abs(x2 - x1));
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", width=" + getWidth() +
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }

    private boolean speedTest() {
        return ((topLeft.getxSpeed() == bottomRight.getxSpeed()) && (topLeft.getySpeed() == bottomRight.getySpeed()));
    }

    @Override
    public void setWidth(double width) {
        this.topLeft.setX((int) (this.topLeft.getX() - (width - this.getWidth())/2));
        this.bottomRight.setX((int) (this.bottomRight.getX() + (width - this.getWidth())/2));
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        this.topLeft.setY((int) (this.topLeft.getY() + (length - this.getLength())/2));
        this.bottomRight.setY((int) (this.bottomRight.getY() - (length - this.getLength())/2));
        super.setLength(length);
    }

    @Override
    public void moveUp() {
        if (speedTest()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
        else System.out.println("Скорости не равны");
    }

    @Override
    public void moveDown() {
        if (speedTest()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
        else System.out.println("Скорости не равны");
    }

    @Override
    public void moveLeft() {
        if (speedTest()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
        else System.out.println("Скорости не равны");
    }

    @Override
    public void moveRight() {
        if (speedTest()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
        else System.out.println("Скорости не равны");
    }
}
```
##MovableRectangleTest.java
```java
package Practice_5;

class MovableRectangleTest {
    public static void main(String[] args) {
        MovableRectangle movrect = new MovableRectangle(1,1,2,2,1,1);
        movrect.moveUp();
        movrect.moveDown();
        movrect.moveRight();
        System.out.println(movrect);
        movrect.moveUp();
        movrect.setWidth(3);
        movrect.setLength(2);
        System.out.println(movrect);
    }
}
```
##Rectangle.java
```java
package Practice_5;

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        this.setFilled(filled);
        this.setColor(color);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
##Shape.java
```java
package Practice_5;

public abstract class Shape {
    private String color;
    private boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}
```
#Practice_6
##Field.java
```java
package Practice_6;

import java.util.Arrays;
import java.util.stream.Stream;

public class Field {
    private int size;
    private int[][] array;
    private int[][] sumArray;

    Field(int size) {
        this.size = size;
        array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = -15 + ((int) (Math.random() * 30));
            }
        }
    }

    public void fieldOutput() {
        Stream.of(this.array).map(Arrays::toString).forEach(System.out::println);
    }

    public void countSum() {
        sumArray = new int[size][size];
        sumArray[0][0] = array[0][0];

        for (int j = 1; j < size; j++) {
            sumArray[0][j] = sumArray[0][j - 1] + array[0][j];
        }

        for (int i = 1; i < size; i++) {
            sumArray[i][0] = sumArray[i - 1][0] + array[i][0];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                sumArray[i][j] = Math.max(sumArray[i - 1][j], sumArray[i][j - 1]) + array[i][j];
            }
        }
    }

    public void fieldSumOutput() {
        Stream.of(this.sumArray).map(Arrays::toString).forEach(System.out::println);
    }

    public void outResult() {
        System.out.println(sumArray[size-1][size-1]);
    }
}
```
##FieldTest.java
```java
package Practice_6;

import java.util.stream.*;
import java.util.Arrays;

class FieldTest {

    public static void main(String[] args) {
        Field field = new Field(3);
        field.fieldOutput();
        field.countSum();
        field.fieldSumOutput();
        field.outResult();
    }
}
```
#Practice_7_8
##Company.java
```java
package Practice_7_8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private double companyIncome;
    private List <Employee> TopManagers = new ArrayList<Employee>();
    private List <Employee> Managers = new ArrayList<Employee>();
    private List <Employee> Operators = new ArrayList<Employee>();
    private List <Employee> AllEmployees = new ArrayList<Employee>();

    public void hire(Employee employee) {
        if (employee.getPosition().getJobTitle().equals("Operator")) {
            Operators.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
        }
        else if (employee.getPosition().getJobTitle().equals("Manager")) {
            Managers.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
            companyIncome += ((employee.getFullSalary() - employee.getSalary()) * 20);
        }
        else if (employee.getPosition().getJobTitle().equals("TopManager")) {
            TopManagers.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
        }
    }

    public void hireAll(Employee employee, Employee ... employees) {
        hire(employee);
        for(Employee value : employees)
            hire(value);
    }

    public void fire(Employee employee) {
        if (employee.getPosition().getJobTitle().equals("Operator")) {
            Operators.remove(employee);
            AllEmployees.remove(employee);
        }
        else if (employee.getPosition().getJobTitle().equals("Manager")) {
            Managers.remove(employee);
            AllEmployees.remove(employee);
            companyIncome -= ((employee.getFullSalary() - employee.getSalary()) * 20);
        }
        else if (employee.getPosition().getJobTitle().equals("TopManager")) {
            TopManagers.remove(employee);
            AllEmployees.remove(employee);
        }
    }

    public void firePercents(int percents) {
        int del = 100 / percents;

        Operators.sort(Comparator.comparing(Employee::getFullSalary));
        int fireNum = Operators.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(Operators.get(0));
        }

        Managers.sort(Comparator.comparing(Employee::getFullSalary));
        fireNum = Managers.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(Managers.get(0));
        }

        TopManagers.sort(Comparator.comparing(Employee::getFullSalary));
        fireNum = TopManagers.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(TopManagers.get(0));
        }

        System.out.println(percents + "% сотрудников уволено ;(");
    }

    public double getIncome() {
        return companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= AllEmployees.size()) {
                AllEmployees.sort(Comparator.comparing(Employee::getFullSalary).reversed());
                return AllEmployees.subList(0, count);
        }
        else return null;
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count <= AllEmployees.size()) {
            AllEmployees.sort(Comparator.comparing(Employee::getFullSalary));
            return AllEmployees.subList(0, count);
        }
        else return null;
    }
}
```
##CompanyTest.java
```java
package Practice_7_8;

class CompanyTest {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i=0; i < 180; i++) {
            company.hire(new Employee("Tor", "Opera", ((int) (30000 + Math.random() * 10000)), new Operator()));
            if (i<80) {
                company.hire(new Employee("Ger", "Mana", ((int) (50000 + Math.random() * 20000)), new Manager()));
            }
        }

        for (int i=0; i < 10; i++) {
            company.hire(new Employee("Manager", "Top", ((int) (50000 + Math.random() * 20000)), new TopManager(company)));
        }

        System.out.println(company.getIncome());

        System.out.println("The highest salaries: ");
        for (Employee employee : company.getTopSalaryStaff(13)) {
            System.out.println((int) employee.getFullSalary());
        }

        System.out.println("\n The lowest salaries: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary());
        }

        System.out.println();
        company.firePercents(50);

        System.out.println("\nThe highest salaries: ");
        for (Employee employee : company.getTopSalaryStaff(13)) {
            System.out.println((int) employee.getFullSalary());
        }

        System.out.println("\nThe lowest salaries: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary());
        }


        System.out.println(company.getIncome());
    }
}
```
##Employee.java
```java
package Practice_7_8;

public class Employee {
    private String name;
    private String surname;
    private double salary;
    private double fullSalary;
    private EmployeePosition position;

    public Employee(String name, String surname, double salary, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }
}
```
##EmployeePosition.java
```java
package Practice_7_8;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
##Manager.java
```java
package Practice_7_8;

public class Manager implements EmployeePosition {

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + 0.05 * (115000 + Math.random() * 25000);
    }
}
```
##Operator.java
```java
package Practice_7_8;

public class Operator implements EmployeePosition{
    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
```
##TopManager.java
```java
package Practice_7_8;

public class TopManager implements EmployeePosition{
    private Company company;

    TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.getIncome() > 10000000)
            return baseSalary + (baseSalary * 1.5);
        else return baseSalary;
    }

}
```
#Practice_9
##Company.java
```java
package Practice_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private double companyIncome;
    private List <Employee> TopManagers = new ArrayList<Employee>();
    private List <Employee> Managers = new ArrayList<Employee>();
    private List <Employee> Operators = new ArrayList<Employee>();
    private List <Employee> AllEmployees = new ArrayList<Employee>();

    public void hire(Employee employee) {
        if (employee.getPosition().getJobTitle().equals("Operator")) {
            Operators.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
        }
        else if (employee.getPosition().getJobTitle().equals("Manager")) {
            Managers.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
            companyIncome += ((employee.getFullSalary() - employee.getSalary()) * 20);
        }
        else if (employee.getPosition().getJobTitle().equals("TopManager")) {
            TopManagers.add(employee);
            AllEmployees.add(employee);
            employee.setFullSalary(employee.getPosition().calcSalary(employee.getSalary()));
        }
    }

    public void hireAll(Employee employee, Employee... employees) {
        hire(employee);
        for(Employee value : employees)
            hire(value);
    }

    public void fire(Employee employee) {
        if (employee.getPosition().getJobTitle().equals("Operator")) {
            Operators.remove(employee);
            AllEmployees.remove(employee);
        }
        else if (employee.getPosition().getJobTitle().equals("Manager")) {
            Managers.remove(employee);
            AllEmployees.remove(employee);
            companyIncome -= ((employee.getFullSalary() - employee.getSalary()) * 20);
        }
        else if (employee.getPosition().getJobTitle().equals("TopManager")) {
            TopManagers.remove(employee);
            AllEmployees.remove(employee);
        }
    }

    public void firePercents(int percents) {
        int del = 100 / percents;

        Operators.sort(Comparator.comparing(Employee::getFullSalary));
        int fireNum = Operators.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(Operators.get(0));
        }

        Managers.sort(Comparator.comparing(Employee::getFullSalary));
        fireNum = Managers.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(Managers.get(0));
        }

        TopManagers.sort(Comparator.comparing(Employee::getFullSalary));
        fireNum = TopManagers.size() / del;
        for (int i = 0; i < fireNum; i++) {
            this.fire(TopManagers.get(0));
        }

        System.out.println(percents + "% сотрудников уволено ;(");
    }

    public double getIncome() {
        return companyIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= AllEmployees.size()) {
                AllEmployees.sort(Comparator.comparing(Employee::getFullSalary).reversed());
                return AllEmployees.subList(0, count);
        }
        else return null;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count <= AllEmployees.size()) {
            AllEmployees.sort(Comparator.comparing(Employee::getFullSalary));
            return AllEmployees.subList(0, count);
        }
        else return null;
    }

    public void HandleEmployees(Selector selector, Handler handler) {
        for(Employee employee: AllEmployees) {
            if(selector.isNeedEmployee(employee)) {
                handler.handleEmployee(employee);
            }
        }
    }

}
```
##CompanyTest.java
```java
package Practice_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class CompanyTest {

    public static void main(String[] args) {

        Company company = new Company();
        Random r = new Random(2000);

        for (int i=0; i < 60; i++) {
            company.hire(new Employee(
                    "Tor",
                    "Opera",
                    (LocalDate.of(r.nextInt(70) + 1950, r.nextInt(11) + 1, r.nextInt(28) + 1)),
                    "Moscow",
                    "88005553535",
                    ((int) (30000 + Math.random() * 10000)),
                    new Operator()));
        }

        company.HandleEmployees(new Selector() {
                                    @Override
                                    public boolean isNeedEmployee(Employee employee) {
                                        return employee.getDateOfBorn().getDayOfYear() > 180;
                                    }
                                }, new Handler() {
                                    @Override
                                    public void handleEmployee(Employee employee) {
                                        System.out.println(employee.getDateOfBorn());
                                    }
                                }
        );


        ArrayList <Employee> selected = new ArrayList<>();
        company.HandleEmployees(
                employee -> ((2020 - employee.getDateOfBorn().getYear()) < 18),
                selected::add);

        System.out.println();

        for(Employee employee: selected) {
            System.out.println((2020 - employee.getDateOfBorn().getYear()));
        }

        System.out.println();

        MonthSelector monthSelector = new MonthSelector(4);
        company.HandleEmployees(new MonthSelector(3), (employee -> System.out.println(employee.getDateOfBorn())));
    }
}
```
##Employee.java
```java
package Practice_9;

import java.time.LocalDate;

public class Employee {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBorn;
    private String placeLive;
    private String phoneNumber;
    private double salary;
    private double fullSalary;
    private EmployeePosition position;

    public Employee(String name, String surname, LocalDate dateOfBorn, String placeLive, String phoneNumber, double salary, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.dateOfBorn = dateOfBorn;
        this.placeLive = placeLive;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.position = position;
    }

    public void setPlaceLive(String placeLive) {
        this.placeLive = placeLive;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }

    public String getPlaceLive() {
        return placeLive;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }
}
```
##EmployeePosition.java
```java
package Practice_9;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
##Handler.java
```java
package Practice_9;

public interface Handler {
    public void handleEmployee(Employee employee);
}
```
##Manager.java
```java
package Practice_9;

public class Manager implements EmployeePosition {

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + 0.05 * (115000 + Math.random() * 25000);
    }
}
```
##MonthSelector.java
```java
package Practice_9;

public class MonthSelector implements Selector{

    private int month;

    public MonthSelector(int month) {
        this.month = month;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getDateOfBorn().getMonthValue() < month;
    }
}
```
##Operator.java
```java
package Practice_9;

public class Operator implements EmployeePosition {
    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
```
##Selector.java
```java
package Practice_9;

public interface Selector {
    boolean isNeedEmployee(Employee employee);
}
```
##TopManager.java
```java
package Practice_9;

public class TopManager implements EmployeePosition {
    private Company company;

    TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.getIncome() > 10000000)
            return baseSalary + (baseSalary * 1.5);
        else return baseSalary;
    }

}
```
