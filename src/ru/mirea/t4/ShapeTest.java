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

