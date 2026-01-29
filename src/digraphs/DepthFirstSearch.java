package digraphs;

import java.util.Deque;
import java.util.ArrayDeque;

public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstSearch(Digraph di, int s) {
        this.s = s;
        marked = new boolean[di.V()];
        edgeTo = new int[di.V()];
        dfs(di, s);
    }

    private void dfs(Digraph di, int v) {
        marked[v] = true;
        for (int w : di.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(di, w);
            }
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.add(w);
        }
        stack.add(s);
        return stack;
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

        DepthFirstSearch dfs = new DepthFirstSearch(di, 0);
        for (int i : dfs.pathTo(6)) {
            System.out.print(i + "->");
        }

        dfs = new DepthFirstSearch(di, 4);
        if (dfs.hasPathTo(3)) {
            for (int i : dfs.pathTo(3)) {
                System.out.print(i + "->");
            }
        } else {
            System.out.print("\n no path found from 4 to 3");
        }
    }
}
