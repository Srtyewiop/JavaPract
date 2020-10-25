package ru.mirea.t14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Characters {

    // Выглядит как 💩, но она работает 🤙🏻🤙🏻🤙🏻
    public static String GenSpaces(int a){
        String re = "";
        for(int i = 0; i <= a; i++){
            re = re + " ";
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        int Indexes[];
        int N, j;
        String rule, word, word1, word2 , buffer;

        System.out.println("Введите количество правил: ");
        N = scanner.nextInt();
        Indexes = new int[N];
        scanner.nextLine();

        System.out.println("Введите правила (через пробел): ");
        for (int i = 0; i < N; i++) {
            rule = scanner.nextLine();
            list.add(rule);
        }

        //Определение размеров правил(по включению других правил)
        int check = 0;
        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if(i != k){
                    if(list.get(i).split(" ")[0].contains(list.get(k).split(" ")[0])){
                        check ++;
                    }
                }
            }
            Indexes[i] = check;
            check = 0;
        }

        //Сортировка правил по их размеру(т.е. по включению других правил)
        String mem = "";
        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                if (Indexes[i] > Indexes[k]){
                    mem = list.get(k);
                    list.set(k,list.get(i));
                    list.set(i, mem);
                }
            }
        }


        System.out.println("Введите строку: ");
        word = scanner.nextLine();
        word1 = word;
        word2 = word;
        int a = 0;


        j = N - 1;
        for (int i = 0; i < N; i++) {
        word1 = word1.replaceAll(list.get(j).split(" ")[0], list.get(j).split(" ")[1]);
            j--;
        }
        System.out.println(word1 + " итог без регулярок");


     //Регулярки
        j = N - 1;
        for (int i = 0; i < N; i++) {
            Pattern p = Pattern.compile("(\\w+) (\\w+)");
            Matcher m = p.matcher(list.get(j));
            if (m.matches()) {
                word2 = word2.replaceAll(m.group(1), m.group(2));
                j--;
            }
        }
        System.out.println(word2 + " итог с регулярками");
    }
}