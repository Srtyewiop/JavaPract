package ru.mirea.t13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyClass mc = new MyClass();

        try {
            mc.divideNumbers(10, -1);
        } catch (Exception1 ex1) {
            System.out.println("incorrect input");
        } catch (NumberFormatException ex) {
            System.out.println("wrong number format");
        } finally {
            System.out.println(mc);
        }


        String a = new Scanner(System.in).nextLine();
        if (a == "error") {
            throw new Exception2();
        }

    }
    }


