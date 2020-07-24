package algorithms.dataStructureImpl.graph;

import algorithms.challenges.LongestRecommendation;

import java.util.*;

/**
 * given a graph and two vertices, check whether they are connected
 * <p>
 * this algorithm check single activity problem
 */
public class Connect {
    private GraphImpl<String> graph;
    private Map<String, Boolean> marked = new HashMap<>();

    public Connect(GraphImpl<String> graph) {
        this.graph = graph;
    }

    private void depthFirstSearch(GraphImpl<String> graph, String v) {
        marked.put(v, true);
        graph.getAdj(v).forEach(e -> {
            if (!marked.containsKey(e)) depthFirstSearch(graph, e);
        });
    }

    public boolean isConnected(String v1, String v2) {
        depthFirstSearch(graph, v1);
        return marked.containsKey(v2);
    }

    public static void main(String[] args) {
        GraphImpl<String> G = new GraphImpl<>();
        G.addEdge("i1", "i2");
        G.addEdge("i3", "i4");
        G.addEdge("i5", "i6");
        G.addEdge("i3", "i6");
        Connect connect = new Connect(G);
        boolean connected = connect.isConnected("i3", "i5");
        System.out.println("i3 and i5 is connected ?= " + connected);
    }
}
