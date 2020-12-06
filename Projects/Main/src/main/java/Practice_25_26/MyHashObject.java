package Practice_25_26;

public class MyHashObject<K,V> {
    private K key;
    private V value;

    public MyHashObject(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyHashObject() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyHashObject{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
