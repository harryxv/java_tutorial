package algorithms.dataStructureImpl;

import java.util.*;

/**
 * adjacency-list-map implementation
 * Undirected Graph
 */
public class AdjListMapGraph {
    private Map<String, List<String>> adj = new HashMap<>();
    private int V; //number of vertices
    private int E; //number of edges

    public AdjListMapGraph() {
        this.adj = new HashMap<>();
    }

    //deep copy of an existing graph object
    //in case the original one need keep stable for other scenario, all operations on the cloned one.
    public AdjListMapGraph(AdjListMapGraph graph) {
        this.adj.putAll(graph.getAdj());
        this.V = graph.getV();
        this.E = graph.getE();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Map<String, List<String>> getAdj() {
        return adj;
    }


    void addVertex(String label) {
        this.adj.putIfAbsent(label, new ArrayList<>());
        V++;
    }

    //this assume all vertices are added first
    void addEdge(String label1, String label2) {
        if (this.adj.get(label1) == null) this.addVertex(label1);
        if (this.adj.get(label2) == null) this.addVertex(label2);

        this.adj.get(label1).add(label2);
        this.adj.get(label2).add(label1);
        E++;
    }

    //remove vertex after the graph is established.
    public void removeVertex(String label) {
        List<String> adjs = adj.get(label);
        adjs.forEach(e -> removeEdge(label, e));
        V--;
    }

    public void removeEdge(String label1, String label2) {
        this.adj.get(label1).remove(label2);
        this.adj.get(label2).remove(label1);
        E--;
    }

    public List<String> getAdj(String vertex) {
        return this.adj.get(vertex);
    }

    /**
     * @param graph
     * @param root
     * @return
     */

    //Depth-First: put priority to one branch and its descendants, by pushing descendants to the Stack.
    //use explicit Stack is the key of DFS algorithm
    Set<String> depthFirstTraversal(AdjListMapGraph graph, String root) {
        Set<String> result = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!result.contains(vertex)) {
                result.add(vertex);
                List<String> adjs = graph.getAdj(vertex);
                adjs.forEach(e -> stack.push(e));
            }
        }
        return result;
    }


    /**
     * @param graph
     * @param root
     * @return
     */
    Set<String> breadthFirstTraversal(AdjListMapGraph graph, String root) {
        Set<String> result = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            if (!result.contains(vertex)) {
                result.add(vertex);
                List<String> adjs = graph.getAdj(vertex);
                adjs.forEach(e -> queue.add(e));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AdjListMapGraph graph = new AdjListMapGraph();
        String[] vertices = {"Bob", "Alice", "Mark", "Rob", "Maria"};
        Arrays.asList(vertices).forEach(e -> graph.addVertex(e));

        String[][] edges = {{"Bob", "Alice"}, {"Bob", "Rob"}, {"Alice", "Mark"}, {"Rob", "Mark"}, {"Alice", "Maria"}, {"Alice", "Maria"}, {"Rob", "Maria"}};
        Arrays.asList(edges).forEach(e -> graph.addEdge(e[0], e[1]));

        Set<String> dfsResult = graph.depthFirstTraversal(graph, "Bob");
        System.out.println(dfsResult);

        //get a clone of existing graph
        AdjListMapGraph graphForCheck = new AdjListMapGraph(graph);

        Set<String> bfsResult = graph.breadthFirstTraversal(graph, "Bob");
        System.out.println(bfsResult);

        if (dfsResult.size() == graph.getV()) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is connected");
        }
    }
}

