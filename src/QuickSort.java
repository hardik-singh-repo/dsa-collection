
import java.util.Arrays;

//classic quick sort, Lomuto's algo.
public class QuickSort {

    public static void sort(int[] arr, int start, int end){
          if(start >= end){
            return;
          }

          int pi = end;
          int i = start - 1;

          for(int j = start; j < pi; j++){
             if(arr[j] < arr[pi]){
                i++;
                var temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
             }
          }

          i++; // incrementing to place where pivot needs to sit. 
          var temp = arr[pi];
          arr[pi] = arr[i];
          arr[i] = temp;

          sort(arr, start, i - 1);
          sort(arr, i + 1, end);
    }

    public static void main(String[] args){
        //int[] arr = {12, 23, 34, 3, 45, 67, 76, 4};
        int[] arr = { 10, 2, 8, 12, 6, 13 };
        sort(arr, 0, arr.length -1 );
        System.out.println(Arrays.toString(arr));
    }
}
