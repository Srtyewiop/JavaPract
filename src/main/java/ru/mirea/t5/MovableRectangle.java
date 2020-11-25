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
