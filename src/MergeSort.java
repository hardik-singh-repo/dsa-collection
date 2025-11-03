
import java.util.Arrays;

public class MergeSort {

    private static void sort(int[] arr, int[] aux,  int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        // copy all elements to be sorted in aux array.
        for (int k = lo; k <= hi ; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) { // when left side of the array is exhausted.
                arr[k] = aux[j++];
            } else if (j > hi) { // when right partition is exhausted.
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 12, 6, 28, 2, 4, 18, 92 };
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
