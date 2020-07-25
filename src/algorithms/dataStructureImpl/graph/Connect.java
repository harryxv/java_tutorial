package algorithms.dataStructureImpl.graph;


import java.util.*;

/**
 * given a graph and two vertices, check whether they are connected
 * Solution: start from one vertex, use DFS to check whether the other one is connected.
 * the auxiliary Map, marked whether a vertex is visited during DFS process.
 * <p>
 * this algorithm check single activity problem
 */

//DFS implementation
public class Connect {
    private GraphImpl<String> graph;
    private Map<String, Boolean> marked = new HashMap<>();

    public Connect(GraphImpl<String> graph) {
        this.graph = graph;
    }

    public boolean isVisited(String v) {
        return marked.containsKey(v);
    }

    private boolean depthFirstSearch(GraphImpl<String> graph, String v, String dest) {
        System.out.println("Visit " + v);
        marked.put(v, true);
        if (v.equalsIgnoreCase(dest)) return true;
        for (String s : graph.adj(v)) {
            if (!isVisited(s)) {
                boolean result = depthFirstSearch(graph, s, dest);
                if (result == true) return true;
            }
        }
        return false;
    }

    public boolean isConnected(String source, String dest) {
        return depthFirstSearch(graph, source, dest);
    }

    public static void main(String[] args) {
        GraphImpl<String> G = new GraphImpl<>();
        String[][] pairs = {
                {"i1", "i2"},
                {"i3", "i4"},
                {"i5", "i6"},
                {"i3", "i6"}
        };
//        G.addEdge("i1", "i2");
//        G.addEdge("i3", "i4");
//        G.addEdge("i5", "i6");
//        G.addEdge("i3", "i6");
        for (String[] pair : pairs) {
            for(int i=1;i<pair.length;i++){
               G.addEdge(pair[0],pair[i]);
            }
        }
        Connect connect = new Connect(G);
        boolean connected = connect.isConnected("i3", "i5");
        System.out.println("i3 and i5 is connected ?= " + connected);
    }
}
