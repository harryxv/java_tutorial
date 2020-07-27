package algorithms.dataStructureImpl;

import java.util.*;

//Directed Graph representation
public class Graph<E> {
    private Map<E, List<E>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(E v1, E v2) {
        if (!adj.containsKey(v1)) adj.put(v1, new LinkedList<E>());
        if (!adj.containsKey(v2)) adj.put(v2, new LinkedList<E>());
        adj.get(v1).add(v2);
    }

    public List<E> adj(E v) {
        return adj.get(v);
    }

    public Set<E> v() {
        return adj.keySet();
    }
}
