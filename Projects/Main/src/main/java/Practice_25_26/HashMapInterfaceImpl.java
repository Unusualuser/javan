package Practice_25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMapInterfaceImpl<K, V> implements HashMapInterface<K, V> {
    private MyHashObject<K, V> hashObject = new MyHashObject<>();
    private final ArrayList<ArrayList<MyHashObject<K, V>>> myHashMap;

    public HashMapInterfaceImpl() {
        myHashMap = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            myHashMap.add(new ArrayList<MyHashObject<K, V>>());
        }
    }

    private boolean searchNode(K key) {
        int index = Math.abs(key.hashCode() % myHashMap.size());
        for (int i = 0; i < myHashMap.get(index).size(); i++) {
            if (key.hashCode() == myHashMap.get(index).get(i).getKey().hashCode()) {
                hashObject.setValue(myHashMap.get(index).get(i).getValue());
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(K key, V value) {
        int index = Math.abs(key.hashCode() % myHashMap.size());
        if (myHashMap.get(index).size() != 0) {
            for (int i = 0; i < myHashMap.get(index).size(); i++) {
                MyHashObject<K, V> object = myHashMap.get(index).get(i);
                if (key.equals(object.getKey())) {
                    object = new MyHashObject<>(key, value);
                    myHashMap.get(index).set(i, object);
                } else {
                    myHashMap.get(index).add(new MyHashObject<>(key, value));
                }
                break;
            }
        } else {
            myHashMap.get(index).add(new MyHashObject<>(key, value));
        }
    }

    @Override
    public V get(K key) {
        return searchNode(key) ? hashObject.getValue() : null;
    }

    @Override
    public V remove(K key) {
        int index = key.hashCode() % myHashMap.size();
        if (searchNode(key)) {
            myHashMap.get(index).remove(hashObject);
            return hashObject.getValue();
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return (new Iterator<V>() {
            int currIndOfVal = 0, currIndOfArr = 0;

            @Override
            public boolean hasNext() {
                while((currIndOfArr < 16) && (currIndOfVal == myHashMap.get(currIndOfArr).size())) {
                    currIndOfVal=0;
                    currIndOfArr++;
                }
                return currIndOfArr < 16;
            }

            @Override
            public V next() {
                return myHashMap.get(currIndOfArr).get(currIndOfVal++).getValue();
            }
        });
    }
}
