package algorithms.graphClient;

import algorithms.dataStructure.Graph;

import java.util.List;
import java.util.stream.IntStream;

//Build a graph from two-dimensional array, an array of arrays.
//Two-Dimensional Array may represent different relationship
public class GraphBuilder {

    //for each nested array: String[], the first element is the source, all the rest are the dependents of the source
    public static Graph<String> buildGraph(String[][] grid) {
        Graph<String> graph = new Graph<>();
        for (String[] s : grid) {
            for (int i = 1; i < s.length; i++) {
                graph.addEdge(s[0], s[i]);
            }
        }
        return graph;
    }


    public static Graph<String> buildGraphForRobot(String[][] grid, int M, int N) {
        //for each grid[i][j], the grid[i][j+1], grid[i+1][j] should be its dependent
        Graph<String> graph = new Graph<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) graph.addEdge(grid[i][j], grid[i][j + 1]);
                if (i < M - 1) graph.addEdge(grid[i][j], grid[i + 1][j]);
            }
        }
        return graph;
    }

    public static Graph<Integer> convertMatrixToGraph(int[][] arr, int N) {
        Graph<Integer> graph = new Graph<>();
        IntStream.range(0, N).forEach(i -> {
            IntStream.range(0, N).forEach(j -> {
                if (arr[i][j] == 1) graph.addEdge(i, j);
            });
        });
        return graph;
    }

    //how to build graph from various format of data source
    public static void main(String[] args) {
        String[][] pairs = {
                {"i1", "i2", "i3", "i4"},
                {"i2", "i3"},
                {"i5", "i6"},
                {"i6", "i7"},
                {"i7", "i5"},
        };
        Graph<String> graph = buildGraph(pairs);

        for (String s : graph.v()) {
            System.out.println(s + ": " + graph.adj(s));
        }


        int[][] arr = {
                {0, 0, 1},
                {0, 0, 1},
                {1, 1, 0}
        };
        int N = 3;
        Graph<Integer> integerGraph = convertMatrixToGraph(arr, 3);

        for (int i = 0; i < N; i++) {
            System.out.println(i + " -> " + integerGraph.adj(i));
        }
    }
}
