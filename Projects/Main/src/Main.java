
public class Main {

    public static void main(String[] args) {
        ex1();
        ex2(args);
        ex3();
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
            float number = 1 / i;
            System.out.printf("%.3f \n", number);
        }
    }
}

