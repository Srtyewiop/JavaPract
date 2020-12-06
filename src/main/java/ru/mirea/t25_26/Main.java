package ru.mirea.t25_26;

public class Main {
    public static void main(String[] args) {
        MapClass<Integer, String> MapObject = new MapClass<>();
        for (int i = 1; i<6; i++){
            MapObject.add(i, i+"Key");
        }
        for (int i = 1; i<6; i++){
            System.out.println(i+" =" + MapObject.getKey(i));
        }

        MapObject.deleteKey(1);
        MapObject.add(5, "changeKey");
        System.out.println("5 =" + MapObject.getKey(5));

        for (String V : MapObject) {
            System.out.println(V);
        }

    }
}
