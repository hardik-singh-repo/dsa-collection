package graphs;

import java.util.List;
import java.util.LinkedList;

public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.V = v;
        adj = (List<Integer>[]) new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * This functions helps created the adjacency list. 
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * Returns iterator for the Graph and can be used by other graph process to get the adjacent vertex.
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
