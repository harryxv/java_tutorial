package algorithms.graphClient;

import algorithms.dataStructure.Graph;

import java.util.*;

/**
 * design a solution to handle module dependencies.
 * this solution should detect circular dependencies.
 */
public class DiGraphCycleDetection {

    //detect cycle

    boolean hasCycle = false;
    Map<String, Boolean> marked = new HashMap<>();
    Map<String, Boolean> onStack = new HashMap<>();
    Map<String, String> edgeTo = new HashMap<>();
    List<Deque> cycles = new ArrayList<>();

    public boolean isMarked(String v) {
        if (marked.containsKey(v)) return marked.get(v);
        return false;
    }

    public void mark(String v) {
        marked.put(v, true);
    }

    public boolean isOnStack(String v) {
        if (onStack.containsKey(v)) return onStack.get(v);
        return false;
    }

    public void pushToStack(String v) {
        onStack.put(v, true);
    }

    //findCircularDependencies
    public List<Deque> solution(String[][] arrays) {
        Graph<String> graph = this.buildGraph(arrays);
        for (String v : graph.v()) {
            if (!isMarked(v)) dfs(graph, v);
        }
        return cycles;
    }

    private void dfs(Graph<String> graph, String s) {
        mark(s);
        onStack.put(s, true);
        for (String v : graph.adj(s)) {
            if (hasCycle) return;
            if (!isMarked(v)) {
                edgeTo.put(v, s);
                dfs(graph, v);
            } else {
                if (isOnStack(v)) {//circular dependency
                    Deque<String> cycle = new ArrayDeque<>();
                    //cycle.push(v);
                    for (String vertex = s; vertex != null && vertex != v; vertex = edgeTo.get(vertex)) {
                        cycle.push(vertex);
                    }
                    cycle.push(v);
                    cycle.push(s);
                    cycles.add(cycle);
                    hasCycle = true;
                }
            }
        }
        onStack.put(s, false);
    }


    /**
     * first s, rest: dependents
     *
     * @param arrays
     * @return
     */
    private Graph<String> buildGraph(String[][] arrays) {
        Graph<String> graph = new Graph<>();
        for (String[] array : arrays) {
            for (int i = 1; i < array.length; i++) {
                graph.addEdge(array[0], array[i]);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        DiGraphCycleDetection client = new DiGraphCycleDetection();
        String[][] arrays = {
                {"m2", "m8"},
                {"m8", "m5", "m6", "m7", "m9"},
                {"m7", "m1"},
                {"m5", "m1"},
                {"m6", "m8"}
        };
        List<Deque> cycles = client.solution(arrays);
        System.out.println(cycles.size());
        for (Deque cycle : cycles) {
            System.out.println(cycle);
        }
    }
}
