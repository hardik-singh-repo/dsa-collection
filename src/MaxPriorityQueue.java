
public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    @SuppressWarnings("unchecked")
    public MaxPriorityQueue(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    public void insert(Key k) {
        pq[++N] = k;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        swap(1, N--);
        sink(1);
        pq[N + 1] = null; 
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                swap(k / 2, k);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) // find the smallest in both child.
                j++;
            if (!less(k, j)) // if k is already bigger then return.
                return;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // test client.
    public static void main(String[] args) {
        int[] arr = { 10, 2, 8, 12, 6, 13 };
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(10);
        // create the max-heap.
        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }

        // print the elements largest to smallest.
        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }

        String[] str = { "Cat", "Mat", "Bat", "Rat", "Zat", "Pat" };
        MaxPriorityQueue<String> spq = new MaxPriorityQueue<>(10);
        // create the max-heap.
        for (int i = 0; i < str.length; i++) {
            spq.insert(str[i]);
        }

        // print the elements largest to smallest.
        while (!spq.isEmpty()) {
            System.out.println(spq.delMax());
        }
    }
}