public class QueueUsingResizingArray {
    private int[] array;
    private int first;
    private int last;

    QueueUsingResizingArray() {
        first = last = 0;
    }

    public void enqueue(int item) {
        if(array == null) {
            array = new int[1];
        }

        if(last == array.length) {
            array = resizeArray(array, array.length * 2); 
        }

        array[last++] = item;
    }

    public int dequeue() {
        if(array == null) {
            throw new IllegalStateException();
        }

        int val  = array[first++];
        
        if(last > first && (last - first) < array.length / 4) {
            array = resizeArray(array, array.length / 2);
        }

        return val;
    }

    public int Size() {
        return last - first;
    }

    private int[] resizeArray(int[] array, int newLength) {
        if (newLength < 1) {
            newLength = 1;
        }
        //get the actual filled length in the array.
        int filledLength = last - first;
        int[] newArray = new int[newLength];
        for (int i = 0; i < last && i < newArray.length; i++) {
            newArray[i] = array[first];
            first++;
        }

        //reassigning the first and the last element of the array since the array has been resized.
        first = 0;
        last = filledLength;
        return newArray;
    }
}