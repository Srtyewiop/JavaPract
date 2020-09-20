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


