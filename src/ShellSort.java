
import java.util.Arrays;

public class ShellSort {
    
    public static void sort(int[] arr) {
        int n = arr.length;
        
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // Elements [0..gap-1], [gap..2*gap-1], [2*gap..3*gap-1]...
            // are sorted independently
            for (int i = gap; i < n; i++) {
                // add arr[i] to the elements that have been gap sorted
                // save arr[i] in temp and make a hole at position i
                int temp = arr[i];
                int j;

                // shift earlier gap-sorted elements up until the correct
                // location for arr[i] is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 3, 54, 33, 22};
        System.out.println("Original array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
}
