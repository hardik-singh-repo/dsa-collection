
public class QuickFindUF {
    private int[] id; // access to component id (site indexed)

    public QuickFindUF(int N) {
        // Initialize component id array.
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        // Check if p and q are in the same component.
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        // Change all entries with id[p] to id[q].
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(7, 8);
        uf.union(5,6);
        uf.union(3,4);
        uf.union(4,5);
        System.out.println(uf.connected(1, 6)); 
    }
}