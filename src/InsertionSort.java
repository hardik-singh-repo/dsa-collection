
import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for(int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 23, 43, 12, 4, 44, 9, 78, 76 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
