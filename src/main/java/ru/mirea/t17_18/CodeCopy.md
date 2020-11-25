##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/additional/a_1/CashTask.java
```java
package ru.mirea.additional.a_1;
import java.util.Scanner;

public class CashTask {



    public static void main(String[] args) {
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int a =0;

        for(int i = 0; i <= n; i++)
            for(int j =0; j <=n/3;j++)
                for(int k = 0; k <= n/5; k++){
                    if (i+j*3+k*5 == n)
                        a++;
                }


        System.out.println(a);

    }
}

```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/additional/a_3Threads/Threads.java
```java
package ru.mirea.additional.a_3Threads;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    //    static AtomicInteger totalSum = new AtomicInteger();
    static int[] ArrayOfThreadSums = new int[4];
    static int IntSum = 0;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <  4; i++){
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
        for(int i = 0; i< ArrayOfThreadSums.length; i++)
            IntSum += ArrayOfThreadSums[i];
        System.out.println("total sum: " + IntSum);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000, i);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork(int start, int count, int k) {
        //Too hard work, bro
        //There's no synchronized in it!
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            //checking work of threads
            if(i % 250000 == 0) {
                System.out.print(k+": ");
                System.out.println(ArrayOfThreadSums[k]);
            };
            ArrayOfThreadSums[k]++;
        }
        return a;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t1/Task1.java
```java
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

```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t10/CalcClass.java
```java
package ru.mirea.t10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcClass extends JFrame implements ActionListener {

    private JFrame frame;
    private JTextField textFieldFirstNum, textFieldSecondNum, textFieldResult;
    JButton addButton, substractButton, divideButton, multiplyButton;

    private static double a = 0, b = 0, result = 0;
    private static int operator = 0;

    public CalcClass() {
        frame = new JFrame("Calculator");
        frame.setSize(223, 323);

        textFieldFirstNum = new JTextField();
        textFieldSecondNum = new JTextField();
        textFieldResult = new JTextField();

        addButton = new JButton("+");
        substractButton = new JButton("-");
        divideButton = new JButton("/");
        multiplyButton = new JButton("*");

        textFieldFirstNum.setBounds(30, 40, 280, 30);
        textFieldSecondNum.setBounds(30, 170, 280, 30);
        textFieldResult.setBounds(30, 270, 280, 60);

        addButton.setBounds(40, 100, 50, 40);
        substractButton.setBounds(110, 100, 50, 40);
        divideButton.setBounds(180, 100, 50, 40);
        multiplyButton.setBounds(250, 100, 50, 40);

        frame.add(textFieldFirstNum);
        frame.add(textFieldSecondNum);
        frame.add(textFieldResult);
        frame.add(divideButton);
        frame.add(multiplyButton);
        frame.add(substractButton);
        frame.add(addButton);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        addButton.addActionListener(this);
        divideButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        substractButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a + b;
            textFieldResult.setText("" + result);
        }

        if (e.getSource() == substractButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a - b;
            textFieldResult.setText("" + result);
        }

        if (e.getSource() == multiplyButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a * b;
            textFieldResult.setText("" + result);
        }

        if (e.getSource() == divideButton) {
            a = Double.parseDouble(textFieldFirstNum.getText());
            b = Double.parseDouble(textFieldSecondNum.getText());
            result = a / b;
            textFieldResult.setText("" + result);
        }
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t10/Main.java
```java
package ru.mirea.t10;

public class Main {
    public static void main(String[] args) {
        new CalcClass();
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t11/Threads.java
```java
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

```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t12/Colors.java
```java
package ru.mirea.t12;

public enum Colors {

    RED("\u001B[31m"),
    YELLOW( "\u001B[33m"),
    BLUE( " \u001B[34m"),
    PURPLE( "\u001B[35m");



    private String returnColor;


    public String getReturnColor() {
        return returnColor;
    }

    public void setReturnColor(String returnColor) {
        switch (returnColor){
            case "RED":
                this.returnColor = "\u001B[31m";
                break;
            case "YELLOW":
                this.returnColor = "\u001B[33m";
                break;
            case "BLUE":
                this.returnColor = "\u001B[34m";
                break;
            case "PURPLE":
                this.returnColor = "\u001B[35m";
                break;
                

        }
    }

    Colors(String returnColor) {
        this.returnColor = returnColor;
    }


}

```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t12/Main.java
```java
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
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t13/Exception1.java
```java
package ru.mirea.t13;

public class Exception1 extends IllegalArgumentException{
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t13/Exception2.java
```java
package ru.mirea.t13;

public class Exception2 extends RuntimeException{
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t13/Main.java
```java
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


```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t13/MyClass.java
```java
package ru.mirea.t13;

public class MyClass {
    private int s;

    public void divideNumbers(int a, int b) throws Exception1 {
        if (b < 0) {
            throw new Exception1();
        }
        this.s = a / b;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s=" + s +
                '}';
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t14/Characters.java
```java
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
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t15_16/Main.java
```java
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
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t17_18/Main.java
```java
package ru.mirea.t17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static PrintWriter printWriter;

    static {
        try {
            printWriter = new PrintWriter("C:\\Users\\Zyjc\\IdeaProjects\\JavaPract\\src\\ru\\mirea\\t17_18\\CodeCopy.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void copyCodeToFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            String[] code = file.list();
            for (String s : code) {
                copyCodeToFile(path + "/" + s);
            }
        }
        if (file.isFile()) {
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    printWriter.write("##### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        printWriter.write(line + "\n");
                        line = reader.readLine();
                    }
                    printWriter.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {
        Path filePath = Paths.get("").toAbsolutePath();
        copyCodeToFile(filePath.toString() + "/src");
        printWriter.close();
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t2/Task2.java
```java
package ru.mirea.t2;

class Shape{
    String type;
    int perimeter;
    int surface;
    int dimension;
    @Override
    public String toString() {
        System.out.println("Type: "+ type + " P: " + perimeter + " S: "+ " Dim: "+ dimension);
        System.out.println();
        return "";
    }
}

class Book{
    String name;
    int pages;
    @Override
    public String toString() {
        System.out.println("Name: "+ name + " pages: " + pages );
        System.out.println();
        return "";
    }
}

class Ball{
    String color;
    int size;
    @Override
    public String toString() {
        System.out.println("Color: "+ color + " size: " + size );
        System.out.println();
        return "";
    }
}

class Dog{
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int InHumanYears(){
        return age*7;
    }

    public Dog() {
    }

    public String toString() {
        System.out.println("Name: "+ name + " age: " + age );
        System.out.println();
        return "";
    }
}

class DogHouse{
    Dog[] House = new Dog[100];
    int LastPlace = 0;
    Dog AddDog(String n, int a){
        Dog Current = new Dog();
        House[LastPlace] = Current;
        House[LastPlace].setName(n);
        House[LastPlace].setAge(a);
        System.out.print("New dog added: ");
        House[LastPlace].toString();
        System.out.println();
        LastPlace++;
        return Current;
    }
}

public class Task2 {

    public static void main(String[] args) {
        Shape cycle = new Shape();
        cycle.dimension = 3;
        cycle.surface = 10;
        cycle.perimeter = 15;
        cycle.type = "Cycle";
        cycle.toString();

        DogHouse dh = new DogHouse();
        dh.AddDog("AAAA", 10);
        dh.AddDog("JUJA", 102);
        dh.AddDog("Jija", 5);

    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p1/Circle.java
```java
package ru.mirea.t3.p1;


class Circle{
    float length;
    float diameter;
    float surface;
    float pi = 3.1415f;
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
        this.diameter = length/pi;
        this.surface = pi*(0.5f * diameter)* (0.5f * diameter);
        System.out.printf("Now length of this circle is %f",length);
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
        this.length = pi * diameter;
        this.surface = pi*(0.5f * diameter)* (0.5f * diameter);
        System.out.printf("Now diameter of this circle is %f",diameter);
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
        this.diameter = (float) (2*Math.sqrt(surface/pi));
        this.length = pi * diameter;
        System.out.printf("Now surface of this circle is %f",surface);
    }
}


```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p1/CircleTest.java
```java
package ru.mirea.t3.p1;


public class CircleTest {
    public static void main(String[] args) {
        Circle Circ = new Circle();
        Circ.setDiameter(15.0f);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p2/Body.java
```java
package ru.mirea.t3.p2;

class Body {
    String type = "Body";
    float health = 100.f;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p2/Hand.java
```java
package ru.mirea.t3.p2;

class Hand {
    String type;
    boolean Left;

    public Hand(boolean left) {
        Left = left;
        if (Left) {
            type = "Left Hand";
        } else {
            type = "Right Hand";
        }
    }

    float health = 100.f;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p2/Head.java
```java
package ru.mirea.t3.p2;

class Head {

    String type = "Head";
    float health = 100.f;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p2/Human.java
```java
package ru.mirea.t3.p2;



class Human {
    public Human(String name) {
        this.name = name;
    }

    String name;
    Head mainHead = new Head();
    Hand leftHand = new Hand(true);
    Hand rightHand = new Hand(false);
    Body mainBody = new Body();
    Leg rightLeg = new Leg(false);
    Leg leftLeg = new Leg(true);
    boolean bFine = true;

    void CheckHealth() {
        System.out.printf("State of %s's %s is (%f)", this.name, mainHead.getType(), mainHead.getHealth());
        if (mainHead.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, mainBody.getType(), mainBody.getHealth());
        if (mainBody.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, leftHand.getType(), leftHand.getHealth());
        if (leftHand.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, rightHand.getType(), rightHand.getHealth());
        if (rightHand.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, leftLeg.getType(), leftLeg.getHealth());
        if (leftLeg.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, rightLeg.getType(), rightLeg.getHealth());
        if (rightLeg.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        if (bFine) {
            System.out.printf("%s's total state is fine!", this.name);
        } else {
            System.out.printf("%s's total state is not fine!", this.name);
        }
        System.out.println();

    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p2/HumanTest.java
```java
package ru.mirea.t3.p2;

public class HumanTest {
    public static void main(String[] args) {
        Human John = new Human("John");
        John.leftHand.setHealth(50.f);
        John.CheckHealth();
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p2/Leg.java
```java
package ru.mirea.t3.p2;

class Leg {
    String type;
    boolean Left;

    public Leg(boolean left) {
        Left = left;
        if (Left) {
            type = "Left Leg";
        } else {
            type = "Right Leg";
        }
    }

    float health = 100.f;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p3/Book.java
```java
package ru.mirea.t3.p3;

class Book {
    String name;
    int pages;
    int year;
    String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String name, int pages, int year, String author) {
        this.name = name;
        this.pages = pages;
        this.year = year;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void ShowStats() {
        System.out.println();
        System.out.print("Name of the book: ");
        System.out.println(name);
        System.out.print("Author of the book: ");
        System.out.println(author);
        System.out.print("Year of the book's creation: ");
        System.out.println(year);
        System.out.print("Number of pages in the book: ");
        System.out.println(pages);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t3/p3/BookTest.java
```java
package ru.mirea.t3.p3;

public class BookTest {
    public static void main(String[] args) {
        Book HP = new Book("Harry Potter", 300,2001,"Johan Rowling");
        HP.ShowStats();

    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t4/Circle.java
```java
package ru.mirea.t4;

public class Circle extends Shape {

    protected double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t4/Rectangle.java
```java
package ru.mirea.t4;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t4/Shape.java
```java
package ru.mirea.t4;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t4/ShapeTest.java
```java
package ru.mirea.t4;

    public class ShapeTest {
        public static void main(String[] args) {
            Shape rectangle = new Rectangle("red", true,15, 20);
            System.out.println(rectangle);

            Shape circle = new Circle(12, "red",false);
            System.out.println(circle);

            Square square = new Square(13);
            System.out.println(square);
        }
    }

```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t4/Square.java
```java
package ru.mirea.t4;

public class Square extends Rectangle {
    protected double side;

    public Square() {}

    public Square(double side) {
        this.side = side;
    }

    public Square(double width, double length, double side) {
        super(width, length);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) { this.side = side; }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t5/Movable.java
```java
package ru.mirea.t5;

public interface Movable {
    public void moveUp();

    public void moveLeft();

    public void moveRight();

    public void moveDown();
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t5/MovableCircle.java
```java
package ru.mirea.t5;

import ru.mirea.t4.Circle;

public class MovableCircle extends Circle implements Movable {
    MovablePoint center = new MovablePoint(0,0);



    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", Center x: " + center.getX() +
                " y: " + center.getY() +
                '}';
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveDown() {
    center.moveDown();
    }

    public MovableCircle(double radius, String color, boolean filled, double x, double y) {
        super(radius, color, filled);
        this.center.setX(x);
        this.center.setY(y);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t5/MovablePoint.java
```java
package ru.mirea.t5;

public class MovablePoint implements Movable {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }

    @Override
    public void moveDown() {
        y--;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t5/MovableRectangle.java
```java
package ru.mirea.t5;

import ru.mirea.t4.Rectangle;

public class MovableRectangle extends Rectangle implements Movable {
    MovablePoint UpLeftCorner = new MovablePoint(0, getWidth());
    MovablePoint DownRightCorner = new MovablePoint(getLength(), 0);


    public MovableRectangle(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
        UpLeftCorner.setX(0);
        UpLeftCorner.setY(getWidth());
        DownRightCorner.setX(getLength());
        DownRightCorner.setY(0);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", Up Left Corner x: " + UpLeftCorner.getX() +
                " y: " + UpLeftCorner.getY() +
                ", Down Right Corner x: " + DownRightCorner.getX() +
                " y: " + DownRightCorner.getY() +
                '}';
    }

    @Override
    public void moveUp() {
        UpLeftCorner.moveUp();
        DownRightCorner.moveUp();
    }

    @Override
    public void moveLeft() {
    UpLeftCorner.moveLeft();
    DownRightCorner.moveLeft();
    }

    @Override
    public void moveRight() {
    UpLeftCorner.moveRight();
    DownRightCorner.moveRight();
    }

    @Override
    public void moveDown() {
    UpLeftCorner.moveDown();
    DownRightCorner.moveDown();
    }

    @Override
    public void setWidth(double width) {
        double a = width - getWidth();
        a = DownRightCorner.getY() - a;
        DownRightCorner.setY(a);
        super.setWidth(width);

    }

    @Override
    public void setLength(double length) {
        double a = length - getLength();
        a = DownRightCorner.getX() + a;
        DownRightCorner.setX(a);
        super.setLength(length);

    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t5/MovableTest.java
```java
package ru.mirea.t5;

import ru.mirea.t4.Shape;

public class MovableTest {
    public static void main(String[] args) {
        MovableCircle MC = new MovableCircle(10.f, "red", false, 0.f, 0.f);
        MovableRectangle MR = new MovableRectangle("red", true, 3.f, 5.f);
        System.out.println(MC);
        System.out.println(MR);
        MC.moveRight();
        MC.moveDown();
        MR.moveRight();
        MR.moveUp();
        System.out.println(MC);
        System.out.println(MR);
        MR.setLength(MR.getLength()*2);
        System.out.println(MR);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t6/Main.java
```java
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
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/Company.java
```java
package ru.mirea.t7_8;

import java.util.*;

public class Company {


    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public double getIncome() {
        double income = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            income += employeeList.get(i).getPosition().getSalaryForCompany();
        }
        return income;
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> allEmployees) {
        employeeList.addAll(allEmployees);
    }

    public void fire(double percent) {
        int numFire = (int) (employeeList.size() * percent / 100);
        for (int i = 0; i < numFire; i++) {
            employeeList.remove((int) (Math.random() * (employeeList.size() - 1)));
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());
            }
        });
        List<Employee> TopSalaryStaff = new ArrayList<>();
        if (count <= employeeList.size()) {
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    TopSalaryStaff.add(employeeList.get(i));
                }
            }
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                TopSalaryStaff.add(employeeList.get(i));
            }
        }
        return TopSalaryStaff;
    }


    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });
        List<Employee> LowestSalaryStaff = new ArrayList<>();
        if (count <= employeeList.size()) {
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    LowestSalaryStaff.add(employeeList.get(i));
                }
            }
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                LowestSalaryStaff.add(employeeList.get(i));
            }
        }
        return LowestSalaryStaff;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/Employee.java
```java
package ru.mirea.t7_8;

public class Employee extends Company {
    private String firstName, secondName;
    private double baseSalary, salary;
    private EmployeePosition position;

    public Employee(String firstName, String secondName, double baseSalary, EmployeePosition position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalary() {
        return this.position.calcSalary(baseSalary);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/EmployeePosition.java
```java
package ru.mirea.t7_8;

public interface EmployeePosition {

    String getJobTitle();
    double calcSalary(double baseSalary);
    double getSalaryForCompany();

}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/Main.java
```java
package ru.mirea.t7_8;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        List<Employee> arrayList;

        for (int i = 0; i < 180; i++) {
            String firstName = "Оператор";
            String secondName = String.valueOf(i);
            double baseSalary = Math.random() * 10000 + 30000;
            company.hire(new Employee(firstName, secondName, baseSalary, new Operator(company)));
        }

        for (int i = 0; i < 80; i++) {
            String firstName = "Менеджер";
            String secondName = String.valueOf(i);
            double baseSalary = Math.random() * 10000 + 40000;
            company.hire(new Employee(firstName, secondName, baseSalary, new Manager(company)));
        }

        for (int i = 0; i < 10; i++) {
            String firstName = "Топ-менеджер";
            String secondName = String.valueOf(i);
            double baseSalary = Math.random() * 10000 + 50000;
            company.hire(new Employee(firstName, secondName, baseSalary, new TopManager(company)));
        }

        System.out.println("Список из 10 самых высоких зарплат:");
        arrayList = company.getTopSalaryStaff(10);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%.0f рублей", arrayList.get(i).getSalary());
            System.out.println();
        }
        System.out.println("Список из 30 самых низких зарплат:");
        arrayList = company.getLowestSalaryStaff(30);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%.0f рублей", arrayList.get(i).getSalary());
            System.out.println();
        }

        company.fire(50);

        System.out.println("Список из 10 самых высоких зарплат:");
        arrayList = company.getTopSalaryStaff(10);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%.0f рублей", arrayList.get(i).getSalary());
            System.out.println();
        }
        System.out.println("Список из 30 самых низких зарплат:");
        arrayList = company.getLowestSalaryStaff(30);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%.0f рублей", arrayList.get(i).getSalary());
            System.out.println();
        }
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/Manager.java
```java
package ru.mirea.t7_8;

import java.util.Random;

public class Manager implements EmployeePosition {

    Random rand = new Random();

    private Company company;
    private double cashInCompany = rand.nextInt(25001) + 115000;

    public Manager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + cashInCompany * 0.05;
    }

    @Override
    public double getSalaryForCompany() {
        return cashInCompany;
    }

}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/Operator.java
```java
package ru.mirea.t7_8;

public class Operator implements EmployeePosition{

    private Company company;
    private double cashInCompany = 0;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }

    @Override
    public double getSalaryForCompany() {
        return cashInCompany;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t7_8/TopManager.java
```java
package ru.mirea.t7_8;

public class TopManager implements EmployeePosition {

    private Company company;
    private double cashInCompany = 0;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.getIncome() > 10000000) {
            return 1.5 * baseSalary + baseSalary;
        } else {
            return baseSalary;
        }
    }

    @Override
    public double getSalaryForCompany() {
        return cashInCompany;
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/Company.java
```java
package ru.mirea.t9;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> allEmployees) {
        employeeList.addAll(allEmployees);
    }

    public void fire(double percent) {
        int numFire = (int) (employeeList.size() * percent / 100);
        for (int i = 0; i < numFire; i++) {
            employeeList.remove((int) (Math.random() * (employeeList.size() - 1)));
        }
    }

    public void doSomethingWithEmployee(
            EmployeeSelector selector,
            EmployeeHandler handler
    ) {
        int count = 0;
        for(Employee employee : employeeList) {
            if (selector.isNeedEmployee(employee)) {
                handler.handleEmployees(employee, count);
                count++;
            }
        }
        System.out.println(count);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/Dates.java
```java
package ru.mirea.t9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {
    LocalDate ld;
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Dates(int day, int month, int year) {
        ld = LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return f.format(ld);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/Employee.java
```java
package ru.mirea.t9;

public class Employee {
    private String firstName, secondName, place;
    private int number;
    private Dates dates;

    public Employee(String firstName, String secondName, String place, int number, Dates dates) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.place = place;
        this.number = number;
        this.dates = dates;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", place='" + place + '\'' +
                ", number='" + number + '\'' +
                ", dates=" + dates +
                '}';
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/EmployeeHandler.java
```java
package ru.mirea.t9;

public interface EmployeeHandler {
    void handleEmployees(Employee employee, int index);
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/EmployeeSelector.java
```java
package ru.mirea.t9;

public interface EmployeeSelector {
    boolean isNeedEmployee(Employee employee);
}

```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/Main.java
```java
package ru.mirea.t9;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company cumpany = new Company();
        Random r = new Random(100000);

        for (int i = 0; i < 100; i++) {
            cumpany.hire(new Employee("Ilya", "Sir Eda", "Obshaga", r.nextInt(10000000), new Dates(06, 06, 2006)));
        }

        cumpany.doSomethingWithEmployee(
                new UsageInterface(8402391),
                (employee, i) -> System.out.println("employee " + i + ":" + employee));

        int m = 20_000;
        cumpany.doSomethingWithEmployee(new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getNumber() < m;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployees(Employee employee, int index) {
                System.out.println("=====" + index + "======");
                System.out.println(employee);
            }
        });

        ArrayList<Employee> selection = new ArrayList<>();
        cumpany.doSomethingWithEmployee(
                employee -> employee.getNumber() > 1_000_000,
                (employee, i) -> selection.add(employee));
        System.out.println(selection + "selection");

        EmployeeSelector selector = employee -> employee.getNumber() > 200;
        cumpany.doSomethingWithEmployee(
                selector,
                Main::doSome);

        cumpany.fire(90);
        System.out.println("90% of Ilyas has been destroyed by world cataclysm");
        System.out.println("Survived Ilyas:");
        for (int i = 0; i < cumpany.getEmployeeList().size(); i++) {
            System.out.println(cumpany.getEmployeeList().get(i));
        }
    }

    static void doSome(Employee employee, int index) {
        System.out.println("++++++" + index + "++++");
        System.out.println(employee);
    }
}
```
##### C:\Users\Zyjc\IdeaProjects\JavaPract/src/ru/mirea/t9/UsageInterface.java
```java
package ru.mirea.t9;

public class UsageInterface implements EmployeeSelector {

    private int number;

    public UsageInterface(int number) {
        this.number = number;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getNumber() >= number;
    }
}
```
