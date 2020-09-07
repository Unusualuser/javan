import java.util.*;

public class Main {

    public static void main(String[] args) {
        //ex1();
        //ex2(args);
        //ex3();
        //ex4();
        ex5();
    }

    public static void ex1() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        System.out.println("Сумма, посчитанная циклом for = " + result);
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
        for (int i = 0; i < args.length; i++) {
            System.out.println("Arguments[" + i + "] : " + args[i]);
        }
    }

    public static void ex3() {
        for (float i = 1; i < 11; i++) {
            System.out.printf("%.2f \n", 1 / i);
        }
    }

    public static void ex4() {
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
        System.out.println(result);
    }
}

