package graphs;

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[] marked; // list of all marked vertices. If a vertex is not marked it is because it is
                              // not reachable from this source node.
    private int[] edgeTo;
    private final int s;

    // Creates search data specific to a given source vertex.
    public DepthFirstSearch(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, s);
    }

    /**
     * Marks all reachable vertices adds the path as edge.
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v]; // if a vertex is marked it means that it has a path from source or else there
                          // is no path.
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        // when x equals the source break out of loop and add it separately.
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 4);
        g.addEdge(4, 3);
        g.addEdge(3, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 0);

        System.out.println("-------path 0 to 4------");
        DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
        dfs.hasPathTo(4);
        for (int p : dfs.pathTo(4)) {
            System.out.print(p + "-> ");
        }

        System.out.println("\n-------path 2 to 4------");
        dfs = new DepthFirstSearch(g, 2);
        dfs.hasPathTo(4);
        for (int p : dfs.pathTo(4)) {
            System.out.print(p + "-> ");
        }
    }
}