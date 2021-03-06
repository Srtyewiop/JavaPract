package ru.mirea.t3.p2;

class Hand {
    String type;
    boolean Left;

    public Hand(boolean left) {
        Left = left;
        if (Left) {
            type = "Left Hand";
        } else {
            type = "Right Hand";
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
