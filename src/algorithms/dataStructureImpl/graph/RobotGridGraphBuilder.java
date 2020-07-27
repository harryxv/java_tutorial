package algorithms.dataStructureImpl.graph;

import java.util.*;

public class RobotGridGraphBuilder {
    private static class Graph {
        Map<String, List<String>> adj = new HashMap<>();

        public List<String> adj(String v) {
            return adj.get(v);
        }

        public void addEdge(String v1, String v2) {
            for (String v : (String[]) new String[]{v1, v2}) {
                if (!adj.containsKey(v)) adj.put(v, new LinkedList<>());
            }
        }

        /**
         * M*N grid
         *
         * @param grid
         */
        public Graph(String[][] grid, int M, int N) {
            //for each grid[i][j], the grid[i][j+1], grid[i+1][j] should be its dependent
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (j < N - 1) this.addEdge(grid[i][j], grid[i][j + 1]);
                    if (i < M - 1) this.addEdge(grid[i][j], grid[i + 1][j]);
                }
            }
        }
    }
}
