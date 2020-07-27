package algorithms.dataStructureImpl.graph;

import algorithms.dataStructureImpl.Graph;

import java.util.*;

/**
 * Given a graph and a source vertex s.
 * Is there a path from s to any given target vertex v?
 * if so, find such a path
 */
public class SingleSourcePaths {
    private String s;
    private Map<String, Boolean> marked = new HashMap<>();
    private Map<String, String> pathTo = new HashMap<>();

    public SingleSourcePaths(Graph<String> graph, String s) {
        this.s = s;
        for (String v : graph.v()) {
            marked.put(v, false);
        }
        dfs(graph, s);
    }

    private void dfs(Graph<String> graph, String v0) {
        marked.put(v0, true); //mark visit
        for (String v : graph.adj(v0)) {
            if (!marked.get(v)) {
                pathTo.put(v, v0);
                dfs(graph, v);
            }
        }
    }

    public boolean hasPathTo(String v) {
        return marked.get(v);
    }

    public Iterable<String> pathTo(String v) {
        Deque<String> stack = new ArrayDeque<String>();
        for (String x = v; x != null; x = pathTo.get(x))
            stack.push(x);

        return stack;
    }

    //can be a part of Constructor, or build a graph
    public static void buildGraph(Graph<String> graph, String[][] grid, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) graph.addEdge(grid[i][j], grid[i][j + 1]);
                if (i + 1 < M) graph.addEdge(grid[i][j], grid[i + 1][j]);
            }
        }
    }

    public static void main(String[] args) {
        //step1, build graph

        String[][] arr = {
                {"i1", "i2", "i3"},
                {"i4", "i5", "i6"},
                {"i7", "i8", "i9"}
        };
        int M = 3, N = 3;
        Graph<String> graph = new Graph<>();
        buildGraph(graph, arr, 3, 3);
        String s = "i1";
        SingleSourcePaths processor = new SingleSourcePaths(graph, s);
        for (String[] strings : arr) {
            for (String string : strings) {
                if (processor.hasPathTo(string)) {
                    System.out.println("from " + s + " to " + string + ": " + processor.pathTo(string));
                } else {
                    System.out.println("has not path " + "from " + s + " to " + string);
                }
            }
        }
    }
}
