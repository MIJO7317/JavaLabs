package JavaLabs.Containers;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T>, Cloneable {
    //Конструкторы:

    public ArrayList() {
        this(0);
    }

    public ArrayList(int size) {
        this.size = size;
        this.buffer = DEFAULT_BUFFER_SIZE;
        this.additional = this.buffer;
        this.data = (T[]) new Object[this.capacity()];
    }

    //Методы:

    @Override
    public void add(T element) {
        //Проверка вместимости текущего массива
        if (this.additional != 0) {
            //Вставка element
            this.data[this.size] = element;
            //Изменение вместимости
            additional--;
        } else {
            //Удвоение буффера
            this.buffer *= 2;
            //Изменение вместимости
            this.additional = this.buffer;
            //Выделение памяти под новый массив
            T[] new_data = (T[]) new Object[this.capacity() + 1];
            //Заполнение нового массива значениями из старого
            System.arraycopy(this.data, 0, new_data, 0, this.size);
            //Заполнение последней ячейки нового массива
            new_data[this.size] = element;
            //Присвоение нового массива старому
            this.data = new_data;
        }
        this.size++;
    }

    @Override
    public void add(int index, T element, int count) {
        //Проверка индекса на выходы из границ [0, this.size-1] справа
        if (index > this.size)
            index = this.size;
        //Проверка индекса на выходы из границ [0, this.size-1] слева
        if (index < 0)
            index = 0;
        //Проверка вместимости текущего массива
        if (this.additional >= count) {
            //Смещаем данные с позиции index вправо в количестве count
            System.arraycopy(this.data, index, this.data, index + count, this.size - index);
            //Заполняем освободившиеся ячейки в количестве count значениями element
            for (int i = index; i < index + count; i++)
                this.data[i] = element;
            //Изменение вместимости
            this.additional -= count;
        } else {
            //Удвоение буффера
            this.buffer *= 2;
            //Выделение памяти под новый массив
            T[] new_data = (T[]) new Object[this.size + count + this.buffer];
            //Заполнение нового массива значениями из старого
            System.arraycopy(this.data, 0, new_data, 0, index);
            //Заполнение нового массива передаваемыми элементами
            for (int i = index; i < index + count; i++)
                new_data[i] = element;
            //Заполнение нового массива значениями из старого
            System.arraycopy(this.data, index, new_data, index + count, this.size - index);
            //Присвоение нового массива старому
            this.data = new_data;
            //Изменение вместимости
            this.additional = this.buffer;
        }
        //Изменение размера массива
        this.size += count;
    }

    @Override
    public void add(int index, T element) {
        this.add(index, element, 1);
    }

    @Override
    public T get(int index) {
        if (index >= this.size)
            index = this.size - 1;
        if (index < 0)
            index = 0;
        return this.data[index];
    }

    @Override
    public T remove(int index) {
        if (index >= this.size)
            index = this.size - 1;
        if (index < 0)
            index = 0;
        T current_element = get(index);
        System.arraycopy(this.data, index + 1, this.data, index, this.size - 1 - index);
        this.data[this.size - 1] = null;
        this.additional++;
        this.size--;
        return current_element;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            for (int i = 0; i < this.size(); i++) {
                if (this.data[i] == null) {
                    this.remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (element.equals(this.data[i])) {
                    this.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T set(int index, T element) {
        if (index >= this.size)
            index = this.size - 1;
        if (index < 0)
            index = 0;
        T previous_element = this.get(index);
        this.data[index] = element;
        return previous_element;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++)
                if (this.data[i] == null)
                    return true;
        } else {
            for (int i = 0; i < this.size; i++)
                if (element.equals(this.data[i]))
                    return true;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++)
                if (this.data[i] == null)
                    return i;
        } else {
            for (int i = 0; i < this.size; i++)
                if (element.equals(this.data[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ArrayList<T> clone() {
        ArrayList<T> clone = new ArrayList<>();
        for (int i = 0; i < this.size; i++)
            clone.add(this.get(i));
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("[");
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size - 1) {
                returnString.append(this.data[i].toString());
            } else {
                returnString.append(this.data[i].toString()).append(", ");
            }
        }
        returnString.append("]");
        return returnString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayList)) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return size == arrayList.size
                && additional == arrayList.additional
                && buffer == arrayList.buffer
                && Arrays.equals(data, arrayList.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, additional, buffer);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    public int capacity() {
        return this.size + this.additional;
    }

    public static void changeDefaultBufferSize(int new_buffer_size) {
        ArrayList.DEFAULT_BUFFER_SIZE = new_buffer_size;
    }

    //Приватные переменные
    private static int DEFAULT_BUFFER_SIZE = 16;
    private T[] data;
    private int size;
    private int additional;
    private int buffer;
}
