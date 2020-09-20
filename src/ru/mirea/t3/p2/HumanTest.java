package ru.mirea.t3.p2;

public class HumanTest {
    public static void main(String[] args) {
        Human John = new Human("John");
        John.leftHand.setHealth(50.f);
        John.CheckHealth();
    }
}
