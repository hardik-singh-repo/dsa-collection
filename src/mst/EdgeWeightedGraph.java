package mst;

import java.util.LinkedList; 
import java.util.List;

public class EdgeWeightedGraph {
    private List<Edge>[] vertices; 
    private int vertexCount;
    
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int vertexCount) {
        vertices = (List<Edge>[]) new LinkedList[vertexCount];
        this.vertexCount = vertexCount;
        for(int i = 0; i < vertexCount; i++) {
            vertices[i] = new LinkedList<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        vertices[v].add(e);
        vertices[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return vertices[v];
    }

    public int count() {
        return vertexCount;
    }
}

