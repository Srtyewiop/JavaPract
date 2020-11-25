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
