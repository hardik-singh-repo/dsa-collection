public class StackUsingResizingArray {
    private int n = 0;
    private int[] array;

    //For dynamically resizing the array. double the i gth as element reaches full length. The double of array amortized the time taken for copying the elements to new array.
    public void push(int item) {
        if(array == null) {
            array = new int[1];
        }

        if(n == array.length) {
            array = resizeArray(array, n * 2);
        }
        
        array[n++] = item;
    }

    //For dynamic resizing the array 1/2 the size when array items become 1/4 of total i   gth.
    public int pop() {
        if (array == null || n == 0) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }

        int retVal = array[--n];

        // shrink array when it's one-quarter full
        if (n > 0 && n == array.length / 4) {
            array = resizeArray(array, array.length / 2);
        }

        return retVal;
    }

    public int length() {
        return n;
    }

    private int[] resizeArray(int[] array, int newLength) {
        if (newLength < 1) {
            newLength = 1;
        }
        int[] newArray = new int[newLength];
        for (int i = 0; i < n && i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}