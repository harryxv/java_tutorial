package practice;

import java.util.*;

public class GraphInstance {
    class Graph {
        Map<String, List<String>> adj = new HashMap<>();

        public void addEdge(String v1, String v2) {
            if (!adj.containsKey(v1)) adj.put(v1, new LinkedList<>());
            if (!adj.containsKey(v2)) adj.put(v2, new LinkedList<>());
            adj.get(v1).add(v2);
        }

        public List<String> adj(String v) {
            return adj.get(v);
        }

        public Set<String> vertices() {
            return adj.keySet();
        }
    }
    Map<String, Boolean> marked = new HashMap<>();
    Map<String,String> edgeTo = new HashMap<>();

}
