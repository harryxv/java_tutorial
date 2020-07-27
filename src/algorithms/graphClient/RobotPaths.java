package algorithms.graphClient;

import java.util.*;

public class RobotPaths {
    private static class Graph {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        public Graph(Integer[][] grid, int M, int N) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (j < N - 1) this.addEdge(grid[i][j], grid[i][j + 1]);
                    if (i < M - 1) this.addEdge(grid[i][j], grid[i + 1][j]);
                }
            }
        }

        private void addEdge(Integer v, Integer child) {
            if (!adj.containsKey(v)) adj.put(v, new LinkedList<Integer>());
            if (!adj.containsKey(child)) adj.put(child, new LinkedList<Integer>());
            adj.get(v).add(child);
        }

        public List<Integer> adj(Integer v) {
            return adj.get(v);
        }

    }

    private static class Path {
        List<Integer> path = new LinkedList<>();

        public void add(Integer v) {
            path.add(v);
        }
    }

    /**
     * base case is the end node it self should return an empty list
     *
     * @param g
     * @param from
     * @return
     */
    static List<Path> findPaths(Graph g, Integer from) {
        List<Path> paths = new LinkedList<>();
        List<Integer> adjs = g.adj(from);
        if (adjs.isEmpty()) {
            Path path = new Path();
            path.add(from);
            paths.add(path);
        }
        for (Integer v : adjs) {
            List<Path> subPaths = findPaths(g, v);
            for (Path subPath : subPaths) {
                subPath.add(from);
            }
            paths.addAll(subPaths);
        }
        return paths;
    }

    //Map<Integer, List<Path>> paths = new HashMap<>(); //paths from one vertex to the given dest

    public static void main(String[] args) {
        Integer[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Graph g = new Graph(grid, 3, 3);
        g.adj.forEach((k, v) -> {
            System.out.println(k + "---" + v);
        });

        //get paths from root to the end
        Integer root = grid[0][0];
        List<Path> allPaths = findPaths(g, 1);
        System.out.println("from " + root + "paths = " + allPaths.size());
        for (Path path : allPaths) {
            System.out.println(path.path);
        }
    }
}
