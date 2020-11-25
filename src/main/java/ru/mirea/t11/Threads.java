package ru.mirea.t11;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    static int totalSum;
    static int totalFalseSum;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
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
        System.out.println("total false sum: " + totalFalseSum);
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long falseRes = DoStupidWork(i * 5, (int) Math.pow(12, 5));
        long result = doHardWork(i * 5, (int) Math.pow(12, 5));
        long endTime = System.currentTimeMillis();

        System.out.println(i + ": " + result + " | " + (endTime - startTime));
        System.out.println(i + "(false): " + falseRes + " | " + (endTime - startTime));
    }
    private static long DoStupidWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start - i) * 0.3;
            totalFalseSum++;
        }
        return a;
    }

    private synchronized static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start - i) * 0.3;
            totalSum++;
        }
        return a;
    }

}

