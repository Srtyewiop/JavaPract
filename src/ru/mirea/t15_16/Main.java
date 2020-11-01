package ru.mirea.t15_16;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<String> events = new ArrayList<>();
    static ArrayList<String> states = new ArrayList<>();
    static ArrayList<String> outputList = new ArrayList<>();
    static String currentState = "s1";

    static void getInput(int input) {
            switch (currentState) {
                case "s1":
                if(input == 1){
                    outputList.add(events.get(2));
                    currentState = states.get(5);
                } else {
                    outputList.add(events.get(1));
                    currentState = states.get(2);
                }
                    break;
                case "s2":
                    if(input == 1){
                        outputList.add(events.get(6));
                        currentState = states.get(4);
                    } else {
                        outputList.add(events.get(4));
                        currentState = states.get(3);
                    }
                    break;
                case "s3":
                    if(input == 1){
                        outputList.add(events.get(2));
                        currentState = states.get(5);
                    } else {
                        outputList.add(events.get(6));
                        currentState = states.get(4);
                    }
                    break;
                case "s4":
                    if(input == 1){
                        outputList.add(events.get(5));
                        currentState = states.get(5);
                    } else {
                        outputList.add(events.get(3));
                        currentState = states.get(3);
                    }
                    break;
                case "s5":
                    if(input == 1){
                        outputList.add(events.get(3));
                        currentState = states.get(3);
                    } else {
                        outputList.add(events.get(5));
                        currentState = states.get(1);
                    }
                    break;
            }

    }

    public static void main(String[] args) {
        events.add("none");
        events.add("create_project");
        events.add("add_library");
        events.add("restart");
        events.add("test");
        events.add("deploy");
        events.add("drop_db");
        states.add("none");
        states.add("s1");
        states.add("s2");
        states.add("s3");
        states.add("s4");
        states.add("s5");
        Scanner scan = new Scanner(System.in);
        int input = 0;
        input = scan.nextInt();
        while (input != -1){
            getInput(input);
            input = scan.nextInt();

        }
        for (int i = 0; i < outputList.toArray().length; i++){
            System.out.println(outputList.get(i));
        }





    }


}
