package JavaLabs.Containers;

import java.util.Objects;

public class LinkedList<T> implements List<T>, Cloneable {
    private class Node {
        public T data;
        public Node next;
        public Node prev;
    }

    public LinkedList() {
        this.size = 0;
        this.head = this.tail = null;
    }

    @Override
    public void add(T element) {
        Node new_node = new Node();
        new_node.data = element;
        new_node.prev = this.tail;
        if (this.tail != null)
            this.tail.next = new_node;
        else
            this.head = new_node;
        this.tail = new_node;
        this.size++;
    }

    @Override
    public void add(int index, T element, int count) {
        if (index > this.size)
            index = this.size;
        if (index < 0)
            index = 0;
        Node current_node;
        if (index < this.size / 2) {
            current_node = this.head;
            for (int i = 0; i < index; i++)
                current_node = current_node.next;
        } else {
            if (index == this.size) {
                this.add(element);
                return;
            }
            current_node = this.tail;
            for (int i = this.size - 1; i > index; i--)
                current_node = current_node.prev;
        }
        for (int i = 0; i < count; i++) {
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
    public void add(int index, T element) {
        this.add(index, element, 1);
    }

    @Override
    public T get(int index) {
        if (index >= this.size)
            index = this.size - 1;
        if (index < 0)
            index = 0;
        Node current_node;
        if (index < this.size / 2) {
            current_node = this.head;
            for (int i = 0; i < index; i++)
                current_node = current_node.next;
        } else {
            current_node = this.tail;
            for (int i = this.size - 1; i > index; i--)
                current_node = current_node.prev;
        }
        return current_node.data;
    }

    @Override
    public T remove(int index) {
        if (index >= this.size)
            index = this.size - 1;
        if (index < 0)
            index = 0;
        Node current_node;
        if (index < this.size / 2) {
            current_node = this.head;
            for (int i = 0; i < index; i++)
                current_node = current_node.next;
        } else {
            current_node = this.tail;
            for (int i = this.size - 1; i > index; i--)
                current_node = current_node.prev;
        }
        if (current_node.prev != null)
            current_node.prev.next = current_node.next;
        if (current_node.next != null)
            current_node.next.prev = current_node.prev;
        if (current_node.prev == null)
            this.head = current_node.next;
        if (current_node.next == null)
            this.tail = current_node.prev;
        this.size--;
        return current_node.data;
    }

    @Override
    public boolean remove(T element) {
        Node currentNode = this.head;
        if (element == null) {
            for (int i = 0; i < this.size(); i++) {
                if (currentNode.data == null) {
                    this.remove(i);
                    return true;
                }
                currentNode = currentNode.next;
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (element.equals(currentNode.data)) {
                    this.remove(i);
                    return true;
                }
                currentNode = currentNode.next;
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
        Node current_node;
        if (index < this.size / 2) {
            current_node = this.head;
            for (int i = 0; i < index; i++)
                current_node = current_node.next;
        } else {
            current_node = this.tail;
            for (int i = this.size - 1; i > index; i--)
                current_node = current_node.prev;
        }
        T prev_data = current_node.data;
        current_node.data = element;
        return prev_data;
    }

    @Override
    public boolean contains(T element) {
        Node left_node = this.head;
        Node right_node = this.tail;
        if (element == null) {
            if (this.size == 1)
                return this.head.data == null;
            for (int i = 0; i < (this.size + 1) / 2; i++) {
                if (left_node.data == null || right_node.data == null)
                    return true;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        } else {
            if (this.size == 1)
                return this.head.data.equals(element);
            for (int i = 0; i < (this.size + 1) / 2; i++) {
                if (left_node.data != null)
                    if (left_node.data.equals(element))
                        return true;
                if (right_node.data != null)
                    if (right_node.data.equals(element))
                        return true;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        Node left_node = this.head;
        Node right_node = this.tail;
        if (element == null) {
            if (this.size == 1)
                if (this.head.data == null)
                    return 0;
            for (int i = 0; i < (this.size + 1) / 2; i++) {
                if (left_node.data == null)
                    return i;
                if (right_node.data == null)
                    return this.size - 1 - i;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        } else {
            if (this.size == 1)
                if (this.head.data.equals(element))
                    return 0;
            for (int i = 0; i < (this.size + 1) / 2; i++) {
                if (left_node.data != null)
                    if (left_node.data.equals(element))
                        return i;
                if (right_node.data != null)
                    if (right_node.data.equals(element))
                        return this.size - 1 - i;
                left_node = left_node.next;
                right_node = right_node.prev;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedList<T> clone() {
        LinkedList<T> clone = new LinkedList<>();
        Node current_node = this.head;
        for (int i = 0; i < this.size; i++) {
            clone.add(current_node.data);
            current_node = current_node.next;
        }
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("[");
        Node currentNode = this.head;
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size - 1) {
                returnString.append(currentNode.data.toString());
            } else {
                returnString.append(currentNode.data.toString()).append(", ");
            }
            currentNode = currentNode.next;
        }
        returnString.append("]");
        return returnString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedList)) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return size == that.size
                && Objects.equals(head, that.head)
                && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    public static <T extends Comparable<T>> LinkedList<T> merge(LinkedList<T> firstLinkedList, LinkedList<T> secondLinkedList) {
        LinkedList<T> mergeLinkedList = new LinkedList<>();
        int i = 0, j = 0;
        while (i < firstLinkedList.size() && j < secondLinkedList.size()) {
            if (firstLinkedList.get(i).compareTo(secondLinkedList.get(j)) < 0) {
                mergeLinkedList.add(firstLinkedList.get(i));
                i++;
            } else {
                mergeLinkedList.add(secondLinkedList.get(j));
                j++;
            }
        }
        if (i == firstLinkedList.size()) {
            for (int k = j; k < secondLinkedList.size(); k++) {
                mergeLinkedList.add(secondLinkedList.get(k));
            }
        } else {
            for (int k = i; k < firstLinkedList.size(); k++) {
                mergeLinkedList.add(firstLinkedList.get(k));
            }
        }
        return mergeLinkedList;
    }

    private Node head; //Первый элемент списка
    private Node tail; //Элемент следующий за последним элементом списка
    private int size;
}
