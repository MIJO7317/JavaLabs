package JavaLabs.Containers;

public interface List<T> {
    void add(T element);

    void add(int index, T element, int count);

    void add(int index, T element);

    T get(int index);

    T remove(int index);

    boolean remove(T element);

    T set(int index, T element);

    boolean contains(T element);

    int indexOf(T element);

    boolean isEmpty();

    int size();

    List<T> clone();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();
}
