public class LinkedLists {

    public static class Node {
        Node next = null;
        int data = 0;
    }

    public static Node createLinkedListFromArray(int[] arr) {

        Node pointer = new Node();
        pointer.data = arr[0];

        Node head = pointer;

        for(int i = 1; i < arr.length; i++) {
            Node n = new Node();
            n.data = arr[i];
            
            pointer.next = n;
            pointer = n;
        }
        return head;
    }

    public static Node sort(Node head) {

        if(head == null || head.next == null) 
            return head;

        Node middle = getMid(head);

        Node left = head;
        Node right = middle.next;
        middle.next = null;

        left = sort(left);
        right = sort(right);
        
        return merge(left, right);
    }

    public static Node merge(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        Node result;
        if(n1.data <= n2.data) {
            result = n1;
            result.next = merge(n1.next, n2);
        } else {
            result = n2;
            result.next = merge(n1, n2.next);
        }
        return result;
    }

    public static Node getMid(Node head) {
        if (head == null) 
            return head;
        
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow  = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printNodes(Node head) {
        String arr = "";
        while(head != null){
            arr +=  head.data;
            if(head.next != null){
                arr += ",";
            }
            head = head.next;
        }
        System.out.println(arr);
    }
     
    public static Node InsertElement(Node head, int val) {
        Node newNode = new Node();
        newNode.data = val;

        if(head == null || val < head.data) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        while(current.next != null && current.next.data < val) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 33, 23, 5, 64, 78 };
        Node head = createLinkedListFromArray(arr);
        head = sort(head);
        printNodes(head);

        head = InsertElement(head, 44);
        printNodes(head);
    }
}
