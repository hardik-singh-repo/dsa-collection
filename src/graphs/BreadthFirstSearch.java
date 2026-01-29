package graphs;

import java.util.Deque;
import java.util.ArrayDeque;

public class BreadthFirstSearch {
    private int s;
    private int[] edgeTo;
    private boolean[] marked;

    public BreadthFirstSearch(Graph g, int s) {
        this.s = s;
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Deque<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int v = queue.removeFirst();
            for(int w : g.adj(v)) {
                if(!marked[w]) {
                    queue.add(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Deque<Integer> pathStack = new ArrayDeque<>();
        // when x equals the source break out of loop and add it separately.
        for (int x = v; x != s; x = edgeTo[x]) {
            pathStack.push(x);
        }
        pathStack.push(s);
        return pathStack;
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
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
        bfs.hasPathTo(4);
        for (int p : bfs.pathTo(4)) {
            System.out.print(p + "-> ");
        }

        System.out.println(" \n -------path 2 to 4------");
        bfs = new BreadthFirstSearch(g, 2);
        bfs.hasPathTo(4);
        for (int p : bfs.pathTo(4)) {
            System.out.print(p + "-> ");
        }
    }
}
