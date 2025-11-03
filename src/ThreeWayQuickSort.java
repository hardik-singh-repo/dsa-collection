import java.util.Arrays;
/**
 * Works on array with duplicate entries. Performs better that traditional quick sort.
 */
public class ThreeWayQuickSort {
    public void sort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo, gt = hi, i = lo;
        int v = arr[lo];
        while (i <= gt) {
            if (arr[i] < v)
                swap(arr, i++, lt++);
            else if (arr[i] > v)
                swap(arr, i, gt--);
            else
                i++;
        }

        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 7, 2, 3, 3, 4, 4, 5, 6, 6, 9, 1 };
        new ThreeWayQuickSort().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 10, 2, 8, 12, 6, 13 };
        new ThreeWayQuickSort().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}