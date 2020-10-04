package ru.mirea.t6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[][] matrix;
        int a;


        a = scan.nextInt();


        matrix = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }


        for (int i = 0; i < a; i++) {
            System.out.println("i - "+i);
            for (int j = 0; j < a; j++) {
                System.out.println("j - "+j);
                if (i > 0 && j > 0) {
                    matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                    System.out.println("+ matrix[i][j]" +matrix[i][j]);
                } else {
                    if (i > 0) {
                        matrix[i][j] += matrix[i - 1][j];
                        System.out.println("+ matrix[i][j]" +matrix[i][j]);
                    } else if (j > 0) {
                        matrix[i][j] += matrix[i][j - 1];
                        System.out.println("+ matrix[i][j]" +matrix[i][j]);
                    }
                }
            }
        }
        System.out.println(matrix[a - 1][a - 1]);
    }
}