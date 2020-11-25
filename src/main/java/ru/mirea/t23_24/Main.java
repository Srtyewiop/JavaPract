package ru.mirea.t23_24;

public class Main {
    public static void main(String[] args) {
        MathObject mathObject = new MathObject();
        while (true) {
            mathObject.readTasks();
            mathObject.performUndoneMath();

            try {
                Thread.sleep((long) ((Math.random()*1000)+1000));
            } catch (InterruptedException err) {
                err.printStackTrace();
            }

        }
    }
}
