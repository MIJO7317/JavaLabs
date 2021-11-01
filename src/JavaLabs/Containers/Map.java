package JavaLabs.Containers;

import org.jetbrains.annotations.NotNull;

public class Map<K, V> {
    public enum ListType {LINKED_LIST, ARRAY_LIST}

    public static class Entry<K, V> {
        public Entry() {
            this.key = null;
            this.value = null;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K key;
        public V value;
    }

    //Конструкторы:

    public Map(@NotNull ListType type) {
        switch (type) {
            case LINKED_LIST -> this.data = new LinkedList<>();
            case ARRAY_LIST -> this.data = new ArrayList<>();
        }
        this.defaultValue = null;
    }

    public Map() {
        this(ListType.LINKED_LIST);
    }

    //Методы:

    private int indexOfKey(K key) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).key == null) {
                if (key == null) return i;
            } else {
                if (this.data.get(i).key.equals(key)) return i;
            }
        }
        return -1;
    }

    public void put(K key, V value) {
        if (this.containsKey(key))
            data.set(this.indexOfKey(key), new Entry<>(key, value));
        else
            data.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = this.indexOfKey(key);
        return (index == -1) ? this.defaultValue : this.data.get(index).value;
    }

    public V getOrDefault(K key, V default_value) {
        this.defaultValue = default_value;
        return this.get(key);
    }

    public void setDefaultValue(V default_value) {
        this.defaultValue = default_value;
    }

    public V remove(K key) {
        int index = indexOfKey(key);
        return (index == -1) ? this.defaultValue : this.data.remove(index).value;
    }

    public boolean containsKey(K key) {
        return this.indexOfKey(key) != -1;
    }

    public List<K> getKeys(ListType type) {
        List<K> keys;
        switch (type) {
            case LINKED_LIST -> keys = new LinkedList<>();
            case ARRAY_LIST -> keys = new ArrayList<>();
            default -> keys = new ArrayList<>();
        }
        for (int i = 0; i < this.data.size(); i++)
            keys.add(this.data.get(i).key);
        return keys;
    }

    public List<K> getKeys() {
        return this.getKeys(ListType.ARRAY_LIST);
    }

    public List<V> getValues(ListType type) {
        List<V> values;
        switch (type) {
            case LINKED_LIST -> values = new LinkedList<>();
            case ARRAY_LIST -> values = new ArrayList<>();
            default -> values = new ArrayList<>();
        }
        for (int i = 0; i < this.data.size(); i++)
            values.add(this.data.get(i).value);
        return values;
    }

    public List<V> getValues() {
        return this.getValues(ListType.ARRAY_LIST);
    }

    public List<Entry<K, V>> getEntries() {
        return this.data.clone();
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    //Приватные переменные:
    private List<Entry<K, V>> data;
    private V defaultValue;
}
