package algorithms.dataStructureImpl.graph;

import java.util.*;

/**
 * given a graph G and a single source S, detect whether there is a path from S to any vertex V.
 * if yes, give the path.
 */
public interface SingleSourcePathDetection<E> {
    boolean hasPathTo(E e);

    List<E> pathTo(E e);
}
