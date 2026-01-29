package digraphs;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Reverse DFS postOrder of a DAG(Directed Acyclic Graph) is a topological order.
 */
public class TopologicalSort {
    private boolean[] marked;
    private Deque<Integer> reversePostStack;

    public TopologicalSort(Digraph di) {
        marked = new boolean[di.V()];
        reversePostStack = new ArrayDeque<>();
        for(int v = 0; v < di.V(); v++) {
            if(!marked[v]) {
                dfs(di, v);
            }
        }
    }

    private void dfs(Digraph di, int v) {
        marked[v] = true;
        for(int w : di.adj(v)) {
            if(!marked[w]) {
                dfs(di, w);
            }
        }
        reversePostStack.push(v);
    }

    /**
     * Returns vertices in topological order for a graph.
     */
    public Iterable<Integer> reversePost() {
        return reversePostStack;
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

        TopologicalSort ts = new TopologicalSort(di);
        for(int v : ts.reversePost()) {
            System.out.print(v + "->");
        }
    }
}
