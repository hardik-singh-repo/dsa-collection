package sorting;
import java.util.Arrays;

public class HeapSort<Key extends Comparable<Key>>{
    private Key[] heap;
    private int N;
    public HeapSort(Key[] keys) {
        this.heap = keys;
        this.N = keys.length - 1;
    }

    public void sort(){
        // step 1: create the heap.
        for(int i = N; i >= 0; i--) {
            swim(i);
        }

        // step 2; sort the heap.
        while(N > 0) {
            swap(0, N--);
            sink(0);
        }
    }

    private void swim(int k) {
        while(k > 0) {
            int p = (k - 1) / 2;
            if (less(p, k)) {
                swap(p, k);
            }
            k = p;
        }
    }

    private void sink(int k) {
        while((2 * k + 1) <= N) {
            int j = 2 * k + 1;
            if (j < N && less(j, j + 1)){
                j++;
            }
            if(!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        Key temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args){
        String[] keys =  new String[]{ "A", "C", "R", "Y", "T", "W", "C"};
        HeapSort<String> heap = new HeapSort<>(keys);
        heap.sort();
        System.out.println(Arrays.toString(keys));      

        Integer[] arr = {30, 20, 50, 60,70, 10, 40, 90};
        HeapSort<Integer> heap1 = new HeapSort<>(arr);
        heap1.sort();
        System.out.println(Arrays.toString(arr));
    }
}