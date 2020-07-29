package algorithms.challenges;

import java.util.*;

public class BuildGraphFromNode {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    class Solution {
        Map<Integer, Node> nodes = new HashMap<>();
        Map<Node, Boolean> marked = new HashMap<>();

        public boolean isMarked(Node node) {
            return marked.containsKey(node);
        }

        public Node cloneGraph(Node node) {
            Node root = new Node(node.val);
            dfs(root, node);
            return root;
        }


        //dfs:depth first search.
        //it will start from top, then implicitly using call stack to call all its dependecicie,
        public void dfs(Node dest, Node src) {
            nodes.put(dest.val, dest);
            marked.put(dest, true);

            for (Node neighbour : src.neighbors) {
                if (!nodes.containsKey(neighbour.val)) {
                    Node n = new Node(neighbour.val);
                    nodes.put(n.val, n);
                }
                Node destNeighbour = nodes.get(neighbour.val);
                dest.neighbors.add(destNeighbour);
                if (!isMarked(destNeighbour)) dfs(destNeighbour, neighbour);
            }
        }
    }
}
