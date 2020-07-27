package algorithms.dataStructureImpl.graph;

import algorithms.dataStructureImpl.Graph;

import java.util.*;


public class GraphBuilder {

    //Build a graph from two-dimensional array, an array of arrays.
    //for each String[], the first element is the source, all the rest are the dependents of the source
    public static void buildGraph(Graph<String> graph, String[][] grid) {
        for (String[] s : grid) {
            for (int i = 1; i < s.length; i++) {
                graph.addEdge(s[0], s[i]);
            }
        }
    }

    //how to build graph from various format of data source
    public static void main(String[] args) {
        String[][] pairs = {
                {"i1", "i2", "i3", "i4"},
                {"i2", "i3"},
                {"i5", "i6"},
                {"i6", "i7"},
                {"i7", "i5"},
        };
        Graph<String> graph = new Graph<>();
        buildGraph(graph, pairs);

        for (String s : graph.v()) {
            System.out.println(s + ": " + graph.adj(s));
        }
    }
}
