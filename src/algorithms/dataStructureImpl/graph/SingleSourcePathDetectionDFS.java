package algorithms.dataStructureImpl.graph;

import algorithms.dataStructureImpl.Graph;

import java.util.*;

public class SingleSourcePathDetectionDFS implements SingleSourcePathDetection<String> {
    private Graph<String> graph;
    private String source;
    //aux
    private Map<String, Boolean> marked = new HashMap<>();
    private Map<String, String> edgeTo = new HashMap<>();

    public SingleSourcePathDetectionDFS() {
    }

    public SingleSourcePathDetectionDFS(Graph g, String source) {
        graph = g;
        this.source = source;
        dfs(g, source);
    }

    public boolean isMarked(String e) {
        return marked.containsKey(e) && marked.get(e) == true;
    }

    /**
     * Depth first search implementation: start from source vertex, process it, then recursively process all its adjacency
     *
     * @param graph
     * @param s
     */
    private void dfs(Graph<String> graph, String s) {
        marked.put(s, true);
        for (String v : graph.adj(s)) {
            if (!isMarked(v)) dfs(graph, v);
        }
    }

    @Override
    public boolean hasPathTo(String v) {
        return isMarked(v);
    }

    @Override
    public List<String> pathTo(String e) {
        return null;
    }


    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        String[][] pairs = {
                {"i1", "i2"},
                {"i3", "i4"},
                {"i5", "i6"},
                {"i3", "i6"}
        };
        String source = "i3";

        for (String[] pair : pairs) {
            for (int i = 1; i < pair.length; i++) {
                graph.addEdge(pair[0], pair[i]);
            }
        }

        SingleSourcePathDetectionDFS graphProcessor = new SingleSourcePathDetectionDFS(graph, source);

        for (String v : graph.v()) {
            boolean hasPath = graphProcessor.hasPathTo(v);
            System.out.println("is there a path from " + source + " to " + v + "? " + hasPath);
        }
    }
}
