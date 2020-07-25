package algorithms.dataStructureImpl.graph;

import java.util.*;

public class GraphImpl<E> {
    Map<E, List<E>> adj = new HashMap<>();  //vertex - adj_list map

    public List<E> getAdj(E e) {
        return adj.get(e);
    }

    public void addEdge(E first, E second) {
        for (E v : (E[]) new Object[]{first, second}) {
            if (!adj.containsKey(v)) adj.put(v, new LinkedList<>());
        }
        adj.get(first).add(second);
        //if undirected graph, add line below.
        adj.get(second).add(first);
    }
}
