package ru.mirea.t3.p2;



class Human {
    public Human(String name) {
        this.name = name;
    }

    String name;
    Head mainHead = new Head();
    Hand leftHand = new Hand(true);
    Hand rightHand = new Hand(false);
    Body mainBody = new Body();
    Leg rightLeg = new Leg(false);
    Leg leftLeg = new Leg(true);
    boolean bFine = true;

    void CheckHealth() {
        System.out.printf("State of %s's %s is (%f)", this.name, mainHead.getType(), mainHead.getHealth());
        if (mainHead.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, mainBody.getType(), mainBody.getHealth());
        if (mainBody.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, leftHand.getType(), leftHand.getHealth());
        if (leftHand.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, rightHand.getType(), rightHand.getHealth());
        if (rightHand.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, leftLeg.getType(), leftLeg.getHealth());
        if (leftLeg.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        System.out.printf("State of %s's %s is (%f)", this.name, rightLeg.getType(), rightLeg.getHealth());
        if (rightLeg.getHealth() < 100.f) {
            bFine = false;
        }
        ;
        System.out.println();
        if (bFine) {
            System.out.printf("%s's total state is fine!", this.name);
        } else {
            System.out.printf("%s's total state is not fine!", this.name);
        }
        System.out.println();

    }
}
