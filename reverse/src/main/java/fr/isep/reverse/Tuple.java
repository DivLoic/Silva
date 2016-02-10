package fr.isep.reverse;

import java.util.Map;

/**
 * Created by LoicMDIVAD on 24/12/2015.
 */

/**
 * java ... what an awful language who does not have  native tuple <br/>
 * Python is th BEST <<3
 * @param <K>
 * @param <V>
 */
final class Tuple<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public V setValue(V value) {
        return null;
    }

}
