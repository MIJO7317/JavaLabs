package JavaLabs;

public class LinkedList<T> implements List<T>
{
    private class Node
    {
        public T data;
        public Node next;
        public Node prev;
    }

    public LinkedList()
    {
        this.size = 0;
        this.head = this.tail = null;
    }

    @Override
    public void Add(T element)
    {
        Node new_node = new Node();
        new_node.data = element;
        new_node.prev = this.tail;
        if(this.tail != null)
            this.tail.next = new_node;
        else
            this.head = new_node;
        this.tail = new_node;
        this.size++;
    }

    @Override
    public void Add(int index, T element, int count)
    {
        if(index > this.size)
            index = this.size;
        if(index < 0)
            index = 0;
        Node current_node;
        if(index < this.size/2)
        {
            current_node = this.head;
            for (int i = 0;i<index;i++)
                current_node = current_node.next;
        }
        else
        {
            if(index == this.size)
            {
                this.Add(element);
                return;
            }
            current_node = this.tail;
            for (int i = this.size-1; i>index; i--)
                current_node = current_node.prev;
        }
        for (int i = 0; i < count; i++)
        {
            Node new_node = new Node();
            new_node.data = element;
            new_node.next = current_node;
            if (current_node.prev != null) {
                new_node.prev = current_node.prev;
                current_node.prev.next = new_node;
            }
            current_node.prev = new_node;
            this.size++;
        }
    }

    @Override
    public void Add(int index, T element)
    {
        this.Add(index, element, 1);
    }

    @Override
    public T Get(int index)
    {
        if(index >= this.size)
            index = this.size-1;
        if(index < 0)
            index = 0;
        Node current_node;
        if(index < this.size/2)
        {
            current_node = this.head;
            for (int i = 0;i<index;i++)
                current_node = current_node.next;
        }
        else
        {
            current_node = this.tail;
            for (int i = this.size-1; i>index; i--)
                current_node = current_node.prev;
        }
        return current_node.data;
    }

    @Override
    public T Remove(int index)
    {
        if(index >= this.size)
            index = this.size-1;
        if(index < 0)
            index = 0;
        Node current_node;
        if(index < this.size/2)
        {
            current_node = this.head;
            for (int i = 0;i<index;i++)
                current_node = current_node.next;
        }
        else
        {
            current_node = this.tail;
            for (int i = this.size-1; i>index; i--)
                current_node = current_node.prev;
        }
        if(current_node.prev != null)
            current_node.prev.next = current_node.next;
        if(current_node.next != null)
            current_node.next.prev = current_node.prev;
        if(current_node.prev == null)
            this.head = current_node.next;
        if(current_node.next == null)
            this.tail = current_node.prev;
        this.size--;
        return current_node.data;
    }

    @Override
    public T Set(int index, T element)
    {
        if(index >= this.size)
            index = this.size-1;
        if(index < 0)
            index = 0;
        Node current_node;
        if(index < this.size/2)
        {
            current_node = this.head;
            for (int i = 0;i<index;i++)
                current_node = current_node.next;
        }
        else
        {
            current_node = this.tail;
            for (int i = this.size-1; i>index; i--)
                current_node = current_node.prev;
        }
        T prev_data = current_node.data;
        current_node.data = element;
        return prev_data;
    }

    @Override
    public boolean Contains(T element)
    {
        Node left_node = this.head;
        Node right_node = this.tail;
        if(element == null)
        {
            if (this.size == 1)
                return this.head.data == null;
            for (int i = 0; i < (this.size + 1) / 2; i++)
            {
                if (left_node.data == null || right_node.data == null)
                    return true;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        }
        else
        {
            if (this.size == 1)
                return this.head.data.equals(element);
            for (int i = 0; i < (this.size + 1) / 2; i++)
            {
                if(left_node.data != null)
                    if (left_node.data.equals(element))
                        return true;
                if(right_node.data != null)
                    if (right_node.data.equals(element))
                        return true;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        }
        return false;
    }

    @Override
    public int IndexOf(T element)
    {
        Node left_node = this.head;
        Node right_node = this.tail;
        if(element == null)
        {
            if (this.size == 1)
                if (this.head.data == null)
                    return 0;
            for (int i = 0; i < (this.size + 1) / 2; i++)
            {
                if (left_node.data == null)
                    return i;
                if (right_node.data == null)
                    return this.size - 1 - i;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        }
        else
        {
            if (this.size == 1)
                if( this.head.data.equals(element) )
                    return 0;
            for (int i = 0; i < (this.size + 1) / 2; i++)
            {
                if(left_node.data != null)
                    if (left_node.data.equals(element))
                        return i;
                if(right_node.data != null)
                    if (right_node.data.equals(element))
                        return this.size - 1 - i;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        }
        return -1;
    }

    @Override
    public boolean IsEmpty()
    {
        return this.Size() == 0;
    }

    @Override
    public int Size()
    {
        return size;
    }

    private Node head; //Первый элемент списка
    private Node tail; //Элемент следующий за последним элементом списка
    private int size;
}
