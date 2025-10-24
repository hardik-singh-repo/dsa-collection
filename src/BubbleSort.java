
import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr){
        boolean swapped;
        for(int i = 0; i < arr.length - 1; i++){
            swapped = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    var temp = arr[j];
                    arr[j]= arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break; // if no swapping occurred then array is already sorted. So exit early.
        }
    }

    public static void main(String[] args){
        int[] arr = {12, 23, 43,  2 ,22, 98, 26};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
