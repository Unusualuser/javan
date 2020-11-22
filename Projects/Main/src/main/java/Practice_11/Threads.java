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
