package digraphs;

public class KosarajuSharirScc {
    private boolean[] marked;
    private int count;
    private int[] id;

    public KosarajuSharirScc(Digraph di) {
        marked = new boolean[di.V()];
        id = new int[di.V()];
        TopologicalSort tps = new TopologicalSort(di.reverse());
        for (int v : tps.reversePost()) {
            if (!marked[v]) {
                dfs(di, v);
                count++;
            }
        }
    }

    private void dfs(Digraph di, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : di.adj(v)) {
            if(!marked[w]) {
                dfs(di, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }


    public static void main(String[] args) {
        Digraph di = new Digraph(8);
        di.addEdge(0, 2);
        di.addEdge(0, 4);
        di.addEdge(0, 5);
        di.addEdge(2, 3);
        di.addEdge(2, 4);
        di.addEdge(1, 4);
        di.addEdge(5, 1);
        di.addEdge(4, 5);
        di.addEdge(3, 6);
        di.addEdge(1, 6);
        di.addEdge(6, 4);
        di.addEdge(3, 7);

        KosarajuSharirScc scc = new KosarajuSharirScc(di);
        System.out.println(scc.stronglyConnected(2, 4));
        System.out.println(scc.stronglyConnected(3, 1));
        System.out.println(scc.stronglyConnected(4, 1));
    }
}
