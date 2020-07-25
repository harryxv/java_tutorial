package algorithms.dataStructureImpl.graph;

import java.util.*;

public class SingleSourcePathDetectionDFS implements SingleSourcePathDetection<String> {
    private GraphImpl<String> graph;
    private String source;
    //aux
    private Map<String, Boolean> marked = new HashMap<>();
    private Map<String, String> edgeTo = new HashMap<>();

    public SingleSourcePathDetectionDFS() {
    }

    public SingleSourcePathDetectionDFS(GraphImpl g, String source) {
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
    private void dfs(GraphImpl<String> graph, String s) {
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
        GraphImpl<String> graph = new GraphImpl<>();
        graph.addEdge("i1", "i2");
        graph.addEdge("i3", "i4");
        graph.addEdge("i5", "i6");
        graph.addEdge("i3", "i6");
        String source = "i3";
        SingleSourcePathDetectionDFS graphProcessor = new SingleSourcePathDetectionDFS(graph, source);
        for (String v : (String[]) new String[]{"i1", "i2", "i3", "i4", "i5", "i6"}) {
            boolean hasPath = graphProcessor.hasPathTo(v);
            System.out.println("is there a path from " + source + " to " + v + "? " + hasPath);
        }
    }
}
