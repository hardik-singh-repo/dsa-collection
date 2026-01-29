package digraphs;

import java.util.List;
import java.util.LinkedList;

public class Digraph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int v) {
        V = v;
        adj = (List<Integer>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Digraph reverse() {
        Digraph reverseGraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverseGraph.addEdge(w, v);
            }
        }
        return reverseGraph;
    }

    public static void main(String[] args) {
        Digraph di = new Digraph(7);
        di.addEdge(0, 2);
        di.addEdge(0, 4);
        di.addEdge(0, 5);
        di.addEdge(2, 3);
        di.addEdge(2, 4);
        di.addEdge(1, 4);
        di.addEdge(1, 5);
        di.addEdge(4, 5);
        di.addEdge(3, 6);
        di.addEdge(6, 1);
        di.addEdge(6, 4);
    }

}
