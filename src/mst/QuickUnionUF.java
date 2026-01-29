package mst;

public class QuickUnionUF {
    int[] arr; 

    public QuickUnionUF (int n) {
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private int root (int i) {
        while (arr[i] != i) {
            i = arr[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        arr[i] = j;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(0,1);
        uf.union(1,2);
        uf.union(2,3);
        uf.union(3,4);
        uf.union(4,5);
        uf.union(5,6);

        System.out.println(uf.connected(0,6));
    }
}