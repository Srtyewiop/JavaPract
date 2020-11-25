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
