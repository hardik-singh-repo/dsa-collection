
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class BucketSort {
    
    public static void sort(float[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];


        // Initialize buckets properly
        for(int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Find min and max for proper scaling
        float max = arr[0], min = arr[0];
        for (float num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        float range = max - min;

        // Distribute elements into buckets
        for(int i = 0; i < n; i++) { 
            int bucketIdx = (int)((arr[i] - min) * (n - 1) / range);
            bucketIdx = Math.min(bucketIdx, n - 1);
            buckets[bucketIdx].add(arr[i]);
        }

        // Sort individual buckets
        for(ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Gather sorted elements
        int i = 0;
        for(ArrayList<Float> bucket : buckets) {
            for(Float val : bucket) {
                arr[i++] = val;
            }
        }
    }
        

    public static void main(String[] args){
        float[] arr = { 2.3f, 4.3f, 4f, 5.9f, 8.99f, 3.4f };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
