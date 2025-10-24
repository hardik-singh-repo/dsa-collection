
import java.util.Arrays;

public class SelectionSort {
    private static void Sort(int[] arr){   
       for(int i = 0; i < arr.length; i++){
        int minIndex = i;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }
        var temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
       }
    }

    public static void main(String[] args){
        int[] arr = {12, 23, 1, 3, 45, 13 , 78};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
