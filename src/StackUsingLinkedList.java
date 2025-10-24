public class StackUsingLinkedList {
    private Node head = null;
    private int count = 0;

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public int pop() {
        if (head == null) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        Node retNode = head;
        head = head.next;
        count--;
        return retNode.item;
    }

    public int length() {
        return this.count;
    }

    class Node {
        int item;
        Node next;

        Node(int item) {
            this.item = item;
            this.next = null;
        }
    }
}