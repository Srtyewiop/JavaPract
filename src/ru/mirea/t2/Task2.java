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