import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    private Node put(Node n, Key key, Value v) {
        if (n == null) {
            return new Node(key, v, 1);
        }
        int cmp = key.compareTo(n.key);
        if (cmp > 0) {
            n.right = put(n.right, key, v);
        } else if (cmp < 0) {
            n.left = put(n.left, key, v);
        } else {
            n.value = v;
        }
        n.count = 1 + size(n.right) + size(n.left);
        return n;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if (n.left == null) {
            return n.right;
        }
        n.left = deleteMin(n.left);
        n.count = 1 + size(n.left) + size(n.right);
        return n;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node n, Key key) {
        if (n == null)
            return null;

        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.left = delete(n.left, key);
        } else if (cmp > 0) {
            n.right = delete(n.right, key);
        } else { // found the key that need's to be deleted.
            if (n.left == null) // no children the left side so go to right.
                return n.right;

            if (n.right == null) // no children on the right side go to left.
                return n.left;

            // remaining case is when there are 2 children for the node being deleted.
            Node t = n; // assign the node to be delete to a temp node.
            n = min(t.right); // Hibbard's deletion method. We choose successor.
            n.right = deleteMin(t.right); // we moved the min to the place of node being deleted.
            n.left = t.left; // no reference to the node being delete. It will get garbage collected.
        }
        n.count = 1 + size(n.left) + size(n.right); // re-calculate the size.
        return n;
    }

    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null)
            return 0;
        else
            return n.count;
    }

    public Value get(Key k) {
        return get(root, k).value; 
    }

    private Node get(Node n, Key key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.key);
        if (cmp < 0) { // key is on the left of the current node.
            return get(n.left, key);
        } else if (cmp > 0) { // key on the right of the current node.
            return get(n.right, key);
        } else { // found the key. return the current node.
            return n;
        }
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node n) {
        if (n.left == null)
            return n;
        return min(n.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public Key floor(Key key) {
        Node n = floor(root, key);
        if (n == null) {
            return null;
        }
        return n.key;
    }

    private Node floor(Node n, Key key) {
        if (n == null) {
            return null;
        }

        int cmp = key.compareTo(n.key);
        if (cmp == 0) {
            return n;
        }

        // if key is smaller than the current node.
        if (cmp < 0) {
            return floor(n.left, key);
        }

        // if key is bigger than key go to the right branch. If t is returned as null
        // then take the parent node and return it as the floor key.
        Node t = floor(n.right, key);
        if (t != null) {
            return t;
        } else {
            return n;
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node n, Queue<Key> q) {
        if(n == null) return;
        inorder(n.left, q);
        q.add(n.key);
        inorder(n.right, q);
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left = null;
        private Node right = null;
        private int count = 0;

        public Node(Key k, Value v, int c) {
            this.key = k;
            this.value = v;
            this.count = c;
        }
    }

    // Test client
    public static void main(String[] args) {
        int[] a = { 4, 5, 1, 2, 12, 16, 8, 15, 18, 6 };
        BST<Integer, String> b = new BST<>();
        // build the BST
        for (int i = 0; i < a.length; i++) {
            b.put(a[i], "test-" + a[i]);
        }

        // iterating BST.
        for(Integer k : b.keys()) {
            System.out.println(b.get(k));
        }

        System.out.println(b.size());

        System.out.println(b.get(8));

        System.out.println(b.max());

        b.delete(15);

         // iterating BST.
        for(Integer k : b.keys()) {
            System.out.println(b.get(k));
        }
    }
}
