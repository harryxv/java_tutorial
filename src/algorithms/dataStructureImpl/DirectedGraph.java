package algorithms.dataStructureImpl;

import java.util.*;

/**
 * handles vertices and their relationships(edges).
 * the typical representation is adjacency list. use a hashmap<String, List<String>>
 * adj-list map implementation.
 */
public class DirectedGraph {
    Set<String> vertices;
    Map<String, List<String>> adj = new HashMap<>();

    /*
     *         String[][] pairs = {
     *                 {"i1", "i2"},
     *                 {"i3", "i4"},
     *                 {"i5", "i6"},
     *                 {"i3", "i6"}
     *         };
     */
    public DirectedGraph(String[][] pairs) {
        for (String[] pair : pairs) {
            String first = pair[0], second = pair[1];
            //initialize all list to empty
            if (!adj.containsKey(first)) adj.put(first, new LinkedList<>());
            if (!adj.containsKey(second)) adj.put(second, new LinkedList<>());

            adj.get(first).add(second);
        }
        vertices = adj.keySet();
        for (List<String> value : adj.values()) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        String[][] pairs = {
                {"i1", "i2"},
                {"i3", "i4"},
                {"i5", "i6"},
                {"i3", "i6"}
        };
        DirectedGraph graph = new DirectedGraph(pairs);
        graph.vertices.stream().forEach(System.out::println);
    }
}
