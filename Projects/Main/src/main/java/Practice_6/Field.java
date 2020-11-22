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
