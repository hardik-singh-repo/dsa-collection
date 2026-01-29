package graphs;

public class ConnectedComponent {
    private boolean[] marked;
    private int[] id;
    private int count; // keeps count of connected components in a graph.

    public ConnectedComponent(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];

        // This loop helps to categorize, the component in to connected categories. The
        // connect components will have same id.
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count; // add connected component category.
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return this.count;
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,7);
        g.addEdge(5,2);
        g.addEdge(0,3);
        g.addEdge(3,7);
        g.addEdge(1,4);
        g.addEdge(1,5);
        g.addEdge(2,4);

        ConnectedComponent cc = new ConnectedComponent(g);
        System.out.println(cc.count());

        System.out.println(cc.connected(1,2));
        System.out.println(cc.connected(1,7));
    }
}
