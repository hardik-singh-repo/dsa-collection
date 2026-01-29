package sorting;

import java.util.Arrays;

/**
 * This algorithm maintains sorted partition and chooses smallest element from
 * the unsorted part and inserts into the sorted partition
 */
public class SelectionSort {
    private static void Sort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // swap the min element into the sorted partition.
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 23, 1, 3, 45, 13, 78 };
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
