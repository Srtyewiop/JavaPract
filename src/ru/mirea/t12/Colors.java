package ru.mirea.t12;

public enum Colors {

    RED("\u001B[31m"),
    YELLOW( "\u001B[33m"),
    BLUE( " \u001B[34m"),
    PURPLE( "\u001B[35m");



    private String returnColor;


    public String getReturnColor() {
        return returnColor;
    }

    public void setReturnColor(String returnColor) {
        switch (returnColor){
            case "RED":
                this.returnColor = "\u001B[31m";
                break;
            case "YELLOW":
                this.returnColor = "\u001B[33m";
                break;
            case "BLUE":
                this.returnColor = "\u001B[34m";
                break;
            case "PURPLE":
                this.returnColor = "\u001B[35m";
                break;
                

        }
    }

    Colors(String returnColor) {
        this.returnColor = returnColor;
    }


}

