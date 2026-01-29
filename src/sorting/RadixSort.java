package sorting;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] arr){
        int max = getMax(arr);
        for(int exp = 1; max / exp > 0; exp *= 10){
            //call counting subroutine.
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] arr, int exp){
        int len = arr.length;
        int[] count = new int[10];
        int[] outputArr = new int[len];

        // count the number of occurance of each digit.
        for(int i = 0; i < len; i++){
            count[(arr[i] / exp) % 10]++;
        }

        // Find the location of elements.
        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        // Assign elements to their place based on count array.
        for(int i = arr.length -1; i >= 0; i--){
            //assign the element to its sorted place based on digit being sorted.
            outputArr[count[(arr[i] / exp) % 10] - 1] = arr[i];
            
            //decrement element position.
            count[(arr[i] / exp) % 10]--;
        }

        //Assign the output array back to original array.
        for(int i = 0; i < len; i++){
            arr[i] = outputArr[i];
        }
    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 122, 343, 987, 675, 339 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
