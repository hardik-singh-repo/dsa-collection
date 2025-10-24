
import java.util.Arrays;

public class CustomMergeSort {

    private static void mergesort(int[] arr){
        if(arr.length < 2){
            return;
        }

        int mid = arr.length/2;

        int l1 = mid;
        int l2 = arr.length - mid;

        int[] leftArr = new int[l1];
        int[] rightArr = new int[l2];

        for(int i = 0; i < mid; i++ ){
            leftArr[i] = arr[i];
        }

        for(int j = mid; j < arr.length; j++){
            rightArr[j - mid] = arr[j];
        }

        mergesort(leftArr);
        mergesort(rightArr);
        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr){
        int i = 0, j = 0, k =0;

        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < leftArr.length){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArr.length){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10,12,6,28,2,4,18,92};
        mergesort(arr); 
        System.out.println(Arrays.toString(arr));
    }
}
