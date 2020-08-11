package algorithms.challenges;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class CycleDetection {
    class Graph {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        public List<Integer> adj(Integer i) {
            return adj.get(i);
        }

        public void addEdge(Integer i1, Integer i2) {
            if (!adj.containsKey(i1)) adj.put(i1, new LinkedList<>());
            if (!adj.containsKey(i2)) adj.put(i2, new LinkedList<>());
            adj.get(i1).add(i2);
        }
    }

    Map<Integer, Boolean> marked = new HashMap<>();
    boolean hasCycle = false;
    Map<Integer, Boolean> onStack = new HashMap<>();

    boolean isMarked(Integer v) {
        return marked.containsKey(v);
    }

    Graph buildGraph(int[][] grid) {
        Graph graph = new Graph();
        for (int[] arr : grid) {
            graph.addEdge(arr[0], arr[1]);
        }
        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = buildGraph(prerequisites);
        for (Integer v : graph.adj.keySet()) {
            if (!isMarked(v)) {
                hasCycle = dfs(graph, v);
                if (hasCycle) return false;
            }
        }
        return true;
    }

    //return true if hasCycle
    boolean dfs(Graph graph, Integer v) {
        marked.put(v, true); //mark this vertex as visited.
        onStack.put(v, true); //mark this vertex on the call statck
        for (Integer w : graph.adj(v)) {
            if (hasCycle) return true;
            if (!isMarked(w)) {
                hasCycle = dfs(graph, w);
            } else {
                if (onStack.containsKey(w) && onStack.get(w) == true) {
                    hasCycle = true;
                    return true;
                }
            }
        }
        onStack.put(v, false); //mark this vertex on the call statck
        return hasCycle;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //hyperthread is enabled, returns 4
        System.out.println("runtime.availableProcessors()=" + runtime.availableProcessors());
        System.out.println("runtime.freeMemory()=" + runtime.freeMemory());
        CycleDetection solution = new CycleDetection();
        int[][] pre = {
                {0, 1},
                {1, 0}
        };
        boolean result = solution.canFinish(2, pre);
        System.out.println(result);
        System.out.println("runtime.freeMemory()=" + runtime.freeMemory());
    }

}
