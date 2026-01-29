package sorting;
import java.util.Arrays;
import java.util.Random;

/**
 * This algo can sort an array in guaranteed worst case N log N time. It is in-place. 
 * However it is not a stable algo. This algo does not handle duplicates.
 */
public class QuickSort {

  public void sort(int[] arr) {
    // shuffling ensures that the worst case scenarios like already sorted array
    // does not degrade performance to quadratic time.
    shuffle(arr);
    sort(arr, 0, arr.length - 1);
  }

  // Fisher-Yates algo for shuffling array in linear time.
  private void shuffle(int[] arr) {
    Random rnd = new Random();
    for (int i = 1; i < arr.length; i++) {
      int r = rnd.nextInt(i);
      int temp = arr[i];
      arr[i] = arr[r];
      arr[r] = temp;
    }
  }

  public void sort(int[] arr, int lo, int hi) {
    if (hi <= lo)
      return;
    int partition = partition(arr, lo, hi);
    sort(arr, lo, partition - 1);
    sort(arr, partition + 1, hi);
  }

  private int partition(int[] arr, int lo, int hi) {
    int p = lo, i = lo, j = hi + 1;
    while (true) {
      // find i smaller than partition.
      while (arr[++i] < arr[p]) {
        if (i == hi)
          break;
      }

      // find j greater than partition.
      while (arr[--j] > arr[p]) {
        if (j == lo)
          break;
      }

      if (i >= j)
        break;
      // swap i and j around the partition.
      swap(arr, i, j);
    }
    // swap the partition with j.
    swap(arr, lo, j);
    return j; // return the current partition position.
  }

  private void swap(int[] arr, int p, int q) {
    int temp = arr[p];
    arr[p] = arr[q];
    arr[q] = temp;
  }

  // simple test client for sanity check.
  public static void main(String[] args) {
    int[] arr = { 10, 2, 8, 12, 6, 13 };
    new QuickSort().sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
