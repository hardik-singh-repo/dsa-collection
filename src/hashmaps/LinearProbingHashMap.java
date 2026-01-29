package hashmaps;
/**
 * The bucket size has to be carefully considered as when the number of item N
 * grows proportional to the size of the bucket M (M/N ~ 1).
 * The performance degrades as multiple lookup needs to be done to find the
 * place to park the value, it can even degrade to O(n).
 * To prevent this we can double the array as and when it crosses the threshold
 * but double and rehasing all the value can slowdown critical process.
 * If the max size is not known in advance the use Linear probing solution for
 * hash function.
 * 
 * NOTE: resizing logic not implemented yet.
 */
public class LinearProbingHashMap<Key, Value> {
    private int M = 30001; // this bucket size should be considered carefully.
    @SuppressWarnings("unchecked")
    private Key[] keys = (Key[]) new Object[M];
    @SuppressWarnings("unchecked")
    private Value[] vals = (Value[]) new Object[M];

    public void put(Key key, Value val) {
        int i;
        //resizing is needed or else the loop will enter an infinite loop in certain conditions.
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) { 
            if (keys[i].equals(key)) // when key already exists we should update the value.
                break;
        }
        keys[i] = key; // key is update in both cases when null or already exists.
        vals[i] = val;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                return vals[i];
            }
        }
        return null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public static void main(String[] args) {
        int[] a = { 97, 1, 25, 61, 2, 88, 68, 97, 1, 25, 61, 2, 88, 68 };
        LinearProbingHashMap<Integer, Integer> hm = new LinearProbingHashMap<>();
        for(int i = 0; i < a.length; i++) {
            hm.put(a[i], a[i]);
        }
        System.out.println(hm.get(25));
    }
}
