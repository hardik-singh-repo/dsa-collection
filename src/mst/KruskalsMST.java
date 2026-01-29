package mst;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class KruskalsMST {
    private final Queue<Edge> mst = new LinkedList<>();

    public KruskalsMST(EdgeWeightedGraph graph) {
        int vertCount = graph.count();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < vertCount; i++) {
            for (Edge e : graph.adj(i)) {
                if (e.either() == i) {
                    pq.add(e);
                }
            }
        }

        QuickUnionUF uf = new QuickUnionUF(vertCount);
        while (pq.size() > 0 && mst.size() < vertCount - 1) {
            Edge minEdge = pq.poll();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(minEdge);
            }
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

        KruskalsMST mst = new KruskalsMST(graph);
        for (Edge e : mst.edges()) {
            System.out.println(e.either() + "-" + e.other(e.either()));
        }
    }
}
