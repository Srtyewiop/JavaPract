package ru.mirea.t23_24;

public class Main {
    public static void main(String[] args) {
        MathObject worker = new MathObject();
        while (true) {
            worker.getTasks();
            worker.doTasks();

            try {
                Thread.sleep((long) ((Math.random()*1000)+1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker.getSavedJsonInfo();
        }
    }
}
