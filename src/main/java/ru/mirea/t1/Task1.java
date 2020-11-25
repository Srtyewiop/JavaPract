package ru.mirea.t1;

import java.util.Arrays;
import java.util.Random;

public class Task1 {


    public static void main(String[] args) {
        int[] a = {12, 13, 14, 15};
        int s = 0;
        for (int i = 0; i < 4; i++) {
            s += a[i];

        }
        System.out.println();
        System.out.println("summ with for cycle " + s);
        s = 0;
        int o = 0;
        while (o < 4) {

            s += a[o];
            o++;
        }
        System.out.println("summ with while cycle " + s);
        s = 0;
        o = 3;
        do {
            s += a[o];
            o--;
        } while (o >= 0);
        System.out.println("summ with do while cycle " + s);
        System.out.print("Command arguments: ");
        for (int i = 0; i <= args.length - 1; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
        System.out.print("Harmonic numbers: ");
        System.out.print("1 ");
        for (int i = 2; i < 11; i++) {

            System.out.printf("1/%s ", i);

        }
        int[] b = new int[10];
        System.out.println();
        System.out.println("UNSORTED ARRAY:");
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            b[i] = Math.round((float) (Math.random() * 100.f));
            b[i] += r.nextInt();
            System.out.println("b[" + i + "]= " + b[i]);
        }
        Arrays.sort(b, 0, 9);
        System.out.println();
        System.out.println();
        System.out.println("SORTED ARRAYuuuu:");
        for (int i = 0; i < 10; i++) {
            System.out.println("b[" + i + "]= " + b[i]);
        }
        int c = 1;
        for (int i = 1; i <= 10; i++) {
            c *= i;
        }
        System.out.println("Factorial of 10 = " + c);

    }
}

