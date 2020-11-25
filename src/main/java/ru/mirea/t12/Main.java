package ru.mirea.t12;


import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Main{
    public static void PrintText(String text, Colors textColor){
        System.out.println(textColor.getReturnColor() + text);
    }
    public static void main(String[] args) {
        System.out.println("___AVAILABLE COLOR NAMES___");
        System.out.println("RED");
        System.out.println("YELLOW");
        System.out.println("BLUE");
        System.out.println("PURPLE");
        System.out.println("Type in text to print: ");
        Scanner scan = new Scanner(System.in);
        String textToPrint = scan.nextLine();
        Colors printColor = Colors.YELLOW;
        System.out.println("Type in name of color for text:");
        printColor.setReturnColor(scan.nextLine());
        PrintText(textToPrint, printColor);
    }

}