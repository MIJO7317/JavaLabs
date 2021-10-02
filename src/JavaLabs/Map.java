package JavaLabs;

public class Map<K,V>
{
    public enum LIST_TYPE {LINKED_LIST, ARRAY_LIST}

    public static class Entry<K, V>
    {
        public Entry()
        {
            this.key = null;
            this.value = null;
        }
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
        public K key;
        public V value;
    }

    //Конструкторы:

    public Map(LIST_TYPE type)
    {
        switch (type)
        {
            case LINKED_LIST -> this.data = new LinkedList<>();
            case ARRAY_LIST -> this.data = new ArrayList<>();
        }
        this.default_value = null;
    }

    public Map()
    {
       this(LIST_TYPE.LINKED_LIST);
    }

    //Методы:

    private int IndexOfKey(K key)
    {
        for (int i = 0; i<this.data.Size(); i++)
            if(this.data.Get(i).key == key)
                return i;
        return -1;
    }

    public void Put(K key, V value)
    {
        if(this.ContainsKey(key))
            data.Set(this.IndexOfKey(key), new Entry<>(key, value));
        else
            data.Add(new Entry<>(key, value));
    }

    public V Get(K key)
    {
        int index = this.IndexOfKey(key);
        return (index == -1) ? this.default_value : this.data.Get(index).value;
    }

    public V GetOrDefault(K key, V default_value)
    {
        this.default_value = default_value;
        return this.Get(key);
    }

    public void SetDefaultValue(V default_value)
    {
        this.default_value = default_value;
    }

    public V Remove(K key)
    {
        int index = IndexOfKey(key);
        return (index == -1) ? this.default_value : this.data.Remove(index).value;
    }

    public boolean ContainsKey(K key)
    {
        return this.IndexOfKey(key) != -1;
    }

    public List<K> GetKeys(LIST_TYPE type)
    {
        List<K> keys;
        switch (type)
        {
            case LINKED_LIST -> keys = new LinkedList<>();
            case ARRAY_LIST -> keys = new ArrayList<>();
            default -> keys = new ArrayList<>();
        }
        for (int i = 0; i<this.data.Size(); i++)
            keys.Add(this.data.Get(i).key);
        return keys;
    }

    public List<K> GetKeys()
    {
        return this.GetKeys(LIST_TYPE.ARRAY_LIST);
    }

    public List<V> GetValues(LIST_TYPE type)
    {
        List<V> values;
        switch (type)
        {
            case LINKED_LIST -> values = new LinkedList<>();
            case ARRAY_LIST -> values = new ArrayList<>();
            default -> values = new ArrayList<>();
        }
        for (int i = 0; i<this.data.Size(); i++)
            values.Add(this.data.Get(i).value);
        return values;
    }

    public List<V> GetValues()
    {
        return this.GetValues(LIST_TYPE.ARRAY_LIST);
    }

    public List<Entry<K,V>> GetEntries()
    {
        return this.data.clone();
    }

    public int Size()
    {
        return this.data.Size();
    }

    public boolean IsEmpty()
    {
        return this.data.IsEmpty();
    }

    //Приватные переменные:
    private List<Entry<K, V>> data;
    private V default_value;
}
