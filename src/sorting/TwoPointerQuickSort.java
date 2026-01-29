package sorting;

import java.util.Arrays;


// This is Hoare's Partition scheme.
public class TwoPointerQuickSort {
    public static void sort(int[] arr, int start, int end) {
       if(start < end) {
        int pi = partition(arr, start, end);
        sort(arr, start, pi);
        sort(arr, pi + 1, end);
       }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int i = start - 1;
        int j = end + 1;

        while(true) {
            do {
                i++;
            } while(arr[i] < pivot);

            do {
                j--;
            } while(arr[j] > pivot);

            if(i >= j){
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args){
        int[] arr = { 10, 2, 8, 12, 6, 13 };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}