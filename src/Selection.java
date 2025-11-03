/**
 * Using quick sorting like partitioning to get the kth element. 
 * This is in-place algo, time complexity worst case O(n).
 */
public class Selection {
    public int topK(int[] arr, int k) {
        int hi = arr.length -1, lo = 0;
        k = k - 1; // since array are 0 based.
        while (hi > lo) {
            int p = partition(arr, lo, hi);
            if (p > k) hi = p - 1;
            else if (p < k) lo = p + 1;
            else break;
        }
        return arr[k];
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while(arr[++i] < arr[lo]) {
                if (i == hi) break;
            }

            while(arr[--j] > arr[lo]) {
                if (j == lo) break;
            }
            if(i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private void swap(int[] arr, int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    } 
    
    public static void main(String[] args) {
        int arr[] = {2, 32, 1, 22, 56, 24, 89};
        int k = 3;
        int i = new Selection().topK(arr, k);
        System.out.println(i);

        k = 1;
        i = new Selection().topK(arr, k);
        System.out.println(i);

        k = 5;
        i = new Selection().topK(arr, k);
        System.out.println(i);
    }

}