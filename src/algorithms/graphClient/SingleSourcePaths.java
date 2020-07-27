package algorithms.graphClient;

import algorithms.dataStructure.Graph;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Given a graph and a source vertex s.
 * Is there a path from s to any given target vertex v?
 * if so, find such a path
 */

//this is fundamental to graph processing
public class SingleSourcePaths {
    private String s;
    private Map<String, Boolean> marked = new HashMap<>();
    private Map<String, String> pathTo = new HashMap<>();

    public boolean isMarked(String v) {
        if (marked.containsKey(v)) return marked.get(v);
        return false;
    }

    public void mark(String v) {
        marked.put(v, true);
    }

    public void preProcess(String[][] arrs, String s) {
        this.s = s;
        Graph<String> graph = buildGraph(arrs);
        dfs(graph, s);
    }

    private Graph<String> buildGraph(String[][] arrs) {
        Graph<String> graph = new Graph<>();
        for (String[] arr : arrs) {
            IntStream.range(1, arr.length).forEach(e -> {
                graph.addEdge(arr[0], arr[e]);
            });
        }
        return graph;
    }

    private void dfs(Graph<String> graph, String s) {
        mark(s);
        for (String v : graph.adj(s)) {
            if (!isMarked(v)) {
                pathTo.put(v, s);
                dfs(graph, v);
            }
        }
    }

    public boolean hasPathTo(String v) {
        if (marked.containsKey(v)) return marked.get(v);
        return false;
    }

    public Iterable<String> pathTo(String v) {
        Deque<String> stack = new ArrayDeque<String>();
        for (String x = v; x != null; x = pathTo.get(x))
            stack.push(x);

        return stack;
    }

    public Iterable<String> findPath(String v) {
        if (!isMarked(v)) return null;
        return pathTo(v);
    }

    public static void main(String[] args) {
        //input array,
        String[][] arrs = {
                {"i1", "i2", "i3"},
                {"i4", "i5", "i6"},
                {"i7", "i8", "i9"}
        };
        String s = "i1";

        SingleSourcePaths graphClient = new SingleSourcePaths();
        graphClient.preProcess(arrs, s);
        for (String[] arr : arrs) {
            for (String v : arr) {
                if (graphClient.hasPathTo(v))
                    System.out.println("from " + s + " to " + v + ": " + graphClient.pathTo(v));
                else
                    System.out.println("from " + s + " to " + v + ": No such a path");
            }
        }
    }
}
