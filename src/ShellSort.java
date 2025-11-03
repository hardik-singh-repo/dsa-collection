
import java.util.Arrays;

/**
 * This algorithm was discovered by Donald Shell in 1959. It uses a h-sorting technique, where h is an
 * optimal gap between the elements being compared.
 */
public class ShellSort {

    public static void sort(int[] arr) {
        int N = arr.length;
        int h = 1;

        // find optimal h for this arr length.
        while (h < N / 3)
            h = 3 * h + 1;

        while(h >=1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 83, 17, 42, 6, 58, 91, 24, 73, 0, 37, 65, 12, 49, 88, 30, 5, 76, 21, 54, 69 };
        System.out.println("Original array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
