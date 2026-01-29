package mst;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class LazyPrimMST {
    private final boolean[] marked;
    private final Deque<Edge> mst;
    private final PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph) {
        marked = new boolean[graph.count()];
        mst = new ArrayDeque<>();
        pq = new PriorityQueue<>();

        visit(graph, 0);

        while (pq.size() > 0) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.add(e);
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph g, int vertex) {
        marked[vertex] = true;
        for (Edge e : g.adj(vertex)) {
            pq.add(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
         String csvData = """
            source,destination,weight
            0,1,7
            0,3,5
            1,2,8
            1,3,9
            1,4,7
            2,3,8
            2,4,11
            2,5,10
            3,4,15
            3,6,9
            4,5,13
            4,6,2
            """;

        EdgeWeightedGraph graph = new EdgeWeightedGraph(7);

        Scanner scanner = new Scanner(csvData);
        scanner.nextLine(); // skip header
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            int src = Integer.parseInt(parts[0].trim());
            int dest = Integer.parseInt(parts[1].trim());
            int weight = Integer.parseInt(parts[2].trim());
            graph.addEdge(new Edge(src, dest, weight));
        }
        scanner.close();

        LazyPrimMST mst = new LazyPrimMST(graph);
        for (Edge e : mst.edges()) {
            System.out.println(e.either() + "-" + e.other(e.either()));
        }
    }

}
