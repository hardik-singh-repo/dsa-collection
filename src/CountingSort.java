
import java.util.Arrays;

/**
 * This is non-comparison based algorithm. This is a stable algorithm, repeated elements do not loose their sorting. 
 * time complexity => O(n + k). Generally preferred for an array where elements are not spaced too far and are repeating.
 */
public class CountingSort {
    public static void sort(int[] arr){
        int max = findMax(arr);
        
        int[] count = new int[max + 1];

        //Count the occurance of each element.
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        // Determine the position of elements by adding the count of previous elements.
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        int[] output = new int[arr.length];

        //Now based on the positions in the count arr. Place the elements of arr into the output array.
        for(int i = arr.length -1; i >= 0 ; i--){
            output[count[arr[i]] - 1] = arr[i]; //assign the elements to its correct position.
            count[arr[i]]--; // reduce the count of the element, there can be duplicate elements in the array.
        }

        //fix the arr based on the output array.
        for(int i = 0; i < arr.length; i++){
            arr[i] = output[i];
        }
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = { 2, 3, 3, 1, 3, 5, 6, 9 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

