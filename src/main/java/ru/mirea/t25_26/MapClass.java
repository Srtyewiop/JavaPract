package ru.mirea.t25_26;
import java.util.ArrayList;
import java.util.Iterator;

public class MapClass<K, V> implements Inter<K, V> {
    private final ArrayList<ArrayList<BaseItem<K, V>>> MapArrList;
    private final int MapSize = 4;

    public MapClass() {
        MapArrList = new ArrayList<>();
        for (int i = 0; i < MapSize; i++) {
            MapArrList.add(new ArrayList<>());
        }
    }

    @Override
    public void add(K key, V value) {
        boolean bCheck = false;
        int a = key.hashCode() % MapArrList.size();
        System.out.println("Check");
        System.out.println(a);
        System.out.println("Checked");
        if (MapArrList.get(a).size() == 0) {
            MapArrList.get(a).add(new BaseItem<>(key, value));
        } else {
            for (int i = 0; i < MapArrList.get(a).size(); i++) {
                if (MapArrList.get(a).get(i).getKey().equals(key)) {
                    MapArrList.get(a).set(i, new BaseItem<>(key, value));
                    bCheck = true;
                    break;
                }
            }
            if (!bCheck) {
                MapArrList.get(a).add(new BaseItem<>(key, value));
                System.out.println("Check");
                System.out.println(MapArrList.get(a).add(new BaseItem<>(key, value)));
                System.out.println("Checked");
            }
        }
    }

    @Override
    public V getKey(K key) {
        int a = key.hashCode() % MapArrList.size();
        for (int i = 0; i < MapArrList.get(a).size(); i++) {
            if (MapArrList.get(a).get(i).getKey().equals(key)) {
                return MapArrList.get(a).get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public V deleteKey(K key) {
        int a = key.hashCode() % MapArrList.size();
        for (int i = 0; i < MapArrList.get(a).size(); i++) {
            if (MapArrList.get(a).get(i).getKey().equals(key)) {
                BaseItem<K, V> item = new BaseItem<>();
                item.setValue(MapArrList.get(a).get(i).getValue());
                MapArrList.get(a).remove(MapArrList.get(a).get(i));
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return (new Iterator<V>() {
            int currentItem = 0, currentNumber = 0;

            @Override
            public boolean hasNext() {
                if (currentNumber == MapSize - 1)
                    return false;

                while (MapArrList.get(currentNumber + 1).size() == 0) {
                    currentNumber++;
                    currentItem = 0;
                    if (currentNumber == MapSize - 1)
                        return false;
                }

                if (currentItem == MapArrList.get(currentNumber).size()) {
                    currentNumber++;
                    currentItem = 0;
                }
                return (currentNumber < MapSize) &&
                        (currentItem < MapArrList.get(currentNumber).size());
            }

            @Override
            public V next() {
                return MapArrList.get(currentNumber).get(currentItem++).getValue();
            }
        });
    }
}

