package hashmaps;

public class SeparateChainingHashMap<Key, Value> {
    private int M = 97;
    private Node[] ht = new Node[M]; // Array of raw Node type.

    public void put(Key k, Value v) {
        int i = hashCode(k);
        // look for the key in the chain. if already exists then update it.
        for (Node n = ht[i]; n != null; n = n.next) {
            if (k.equals(n.key)) {
                n.val = v;
                return;
            }
        }
        ht[i] = new Node(k, v, ht[i]); // put the new node in the front of the chain.
    }

    @SuppressWarnings("unchecked")
    public Value get(Key k) {
        int i = hashCode(k);
        for (Node n = ht[i]; n != null; n = n.next) {
            if (k.equals(n.key)) {
                return (Value) n.val;
            }
        }
        return null;
    }

    private int hashCode(Key k) {
        // masking any negative value to positive value by flipping the first byte.
        // mod to fit the value in the hashIndex table. 
        // this method is better tha Math.abs, as that API is error prone and once in a while returns a negative value. We want guarantees that no negative value is returned.
        return (k.hashCode() & 0x7fffffff) % M; 
    }

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object k, Object v, Node n) {
            key = k;
            val = v;
            next = n;
        }
    }

    public static void main(String[] args) {
        int[] a = { 28, 80, 58, 14, 97, 1, 25, 61, 2, 88, 68, 36, 87, 15, 83 };
        SeparateChainingHashMap<Integer, Integer> map = new SeparateChainingHashMap<>();
        //construct the map.
        for(int i = 0; i < a.length; i++) {
            map.put(a[i], a[i]);
        }
        System.out.println(map.get(80)); //print one random value.
    }
}