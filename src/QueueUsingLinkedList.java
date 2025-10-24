public class QueueUsingLinkedList {
    private Node first = null;
    private Node last = null;

    public void enqueue(int item) {
        Node oldLast = last;
        last = new Node(item);
        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        int item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        int item;
        Node next;

        Node(int item) {
            this.item = item;
            this.next = null;
        }
    }
}