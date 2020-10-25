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
