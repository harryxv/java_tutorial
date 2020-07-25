package practice;

import java.util.*;

public class GraphSinglePath {
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
    }

    private Map<String, Boolean> marked = new HashMap<>();

    public boolean marked(String v) {
        if (marked.containsKey(v)) return marked.get(v);
        return false;
    }


    //how to build graph from various format of data source
    //direct pars array

    public static void main(String[] args) {
        //the first String stands for source, rest of elements in a array stands for its adjacent
        //adjacent is a relationship, it could be dependent,
        //we can build graph from two dimensional array:
        String[][] pairs = {
                {"i1", "i2", "i3", "i4"},
                {"i2", "i3"},
                {"i5", "i6"},
                {"i6", "i7"},
                {"i7", "i5"},
        };
        //or build graph from list of list<String>,similiar as two-dimensional array
        List<List<String>> pairList = new LinkedList<>();

        Graph graph = new Graph();
        for (String[] strings : pairs) {
            String source = strings[0];
            for (int i = 1; i < strings.length; i++) {
                graph.addEdge(source, strings[i]);
            }
        }
    }
}
