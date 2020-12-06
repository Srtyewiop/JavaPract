package ru.mirea.t25_26;

public interface Inter<K,V> extends Iterable<V> {
    void add(K key, V value);
    V getKey(K key);
    V deleteKey(K key);
}