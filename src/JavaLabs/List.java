package JavaLabs;

public interface List<T>
{
    void Add(T element);
    void Add(int index, T element, int count);
    void Add(int index, T element);
    T Get(int index);
    T Remove(int index);
    T Set(int index, T element);
    boolean Contains(T element);
    int IndexOf(T element);
    boolean IsEmpty();
    int Size();
}
