import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    Node head;
    int size;

    public void push(T item) {
        Node newFirst = new Node(item);
        newFirst.next = head;
        head = newFirst;
        size++;
    }

    public T pop() {
        T item = head.item;
        head  = head.next;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }


    private class Node {
        T item;
        Node next;
        
        Node(T item) {
            this.item = item;
            this.next = null;
        }
    }
}