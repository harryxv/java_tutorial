package algorithms.graphClient;

import java.util.*;
import java.util.stream.IntStream;

//adj list array implementation
public class ConvertMatrixToAdjListArray {
    private static class Graph {
        List<Integer>[] adj;

        public Graph(int N) {
            adj = (List<Integer>[]) new List[N];
            IntStream.range(0, N).forEach(i -> adj[i] = new LinkedList<Integer>());
        }

        public void addEdge(Integer v1, Integer v2) {
            adj[v1].add(v2);
        }
    }


    static List<Integer>[] solution(int[][] arr, int N) {
        Graph G = new Graph(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    G.addEdge(i, j);
                }
            }
        }
        return G.adj;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1},
                {0, 0, 1},
                {1, 1, 0}
        };
        int N = 3;
        List<Integer>[] result = solution(arr, 3);
        for (int i = 0; i < N; i++) {
            System.out.println(i + " -> " + result[i]);
        }
    }
}
