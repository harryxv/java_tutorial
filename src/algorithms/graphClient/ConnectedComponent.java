package algorithms.graphClient;

import algorithms.dataStructure.Graph;

import java.util.*;

/**
 * Given a graph
 * find connected components
 */
//this is fundamental graph processing

//use DFS to generate connected components
//with this connected components, we can
//1, for any vertex, find which components it belongs to
//2, get the longest connected component

public class ConnectedComponent {
    Map<String, List<String>> components = new HashMap<>();
    Map<String, Boolean> marked = new HashMap<>();

    public ConnectedComponent() {
    }

    public void mark(String v) {
        marked.put(v, true);
    }

    public boolean isMarked(String v) {
        return marked.containsKey(v);
    }

    //each Sting[] represents a dependency chain
    public Graph<String> buildGraph(String[][] arrs) {
        Graph<String> graph = new Graph<>();
        for (String[] arr : arrs) {
            for (int i = 0; i < arr.length - 1; i++) {
                graph.addEdge(arr[i], arr[i + 1]);
            }
        }
        return graph;
    }


    public void processGraph(Graph<String> graph) {
        Set<String> vertices = graph.v();
        for (String vertex : vertices) {
            if (!marked.containsKey(vertex)) {
                List<String> component = new LinkedList<>();
                components.put(vertex, component);
                dfs(graph, vertex, component);
            }
        }
    }

    /**
     * depth first search to go through each vertex that connected
     *
     * @param graph
     * @param vertex
     * @param component
     */
    private void dfs(Graph<String> graph, String vertex, List<String> component) {
        mark(vertex);
        component.add(vertex);
        graph.adj(vertex).forEach(e -> {
            if (!isMarked(e)) dfs(graph, e, component);
        });
    }

    //build graph
    //run graph client constructor method.
    //run client API to get required query
    public static void main(String[] args) {

        String[][] pairs = {
                {"i1", "i2", "i3", "i4"},
                {"i2", "i3"},
                {"i5", "i6"},
                {"i6", "i7"},
                {"i7", "i5"},
        };

        ConnectedComponent client = new ConnectedComponent();
        Graph<String> graph = client.buildGraph(pairs);
        client.processGraph(graph);
        client.components.forEach((k, v) -> {
            System.out.println("component " + k + " contains " + v);
        });
    }
}
