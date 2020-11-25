package ru.mirea.t3.p2;

class Leg {
    String type;
    boolean Left;

    public Leg(boolean left) {
        Left = left;
        if (Left) {
            type = "Left Leg";
        } else {
            type = "Right Leg";
        }
    }

    float health = 100.f;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }
}
