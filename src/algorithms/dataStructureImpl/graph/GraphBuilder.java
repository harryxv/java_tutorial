package algorithms.dataStructureImpl.graph;

import java.util.*;

/**
 * Build a graph from two-dimensional array
 */
public class GraphBuilder {
    private static class Graph {
        Map<String, List<String>> adj = new HashMap<>();

        public List<String> adj(String v) {
            return adj.get(v);
        }

        public void addEdge(String v1, String v2) {
            for (String v : (String[]) new String[]{v1, v2}) {
                if (!adj.containsKey(v)) adj.put(v, new LinkedList<>());
            }
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        public Graph(String[][] arrays) {
            for (String[] array : arrays) {
                for (int i = 1; i < array.length; i++) {
                    this.addEdge(array[0], array[i]);
                }
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
        Graph graph = new Graph(pairs);
    }
}
