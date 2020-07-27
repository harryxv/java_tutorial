package algorithms.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        Node node = new Node(key, value);
        root = put(root, node);
    }

    private Node put(Node root, Node node) {
        if (root == null) return node;

        int cmp = node.key.compareTo(root.key);
        if (cmp < 0)
            root.left = put(root.left, node);
        else if (cmp > 0)
            root.right = put(root.right, node);
        else root.value = node.value;

        return root;
    }

    //use BFS to print the tree shape.
    //we need to track the height of a node, we add all the same-level nodes into the queue, and give a counter to mark the number.
    void printTree() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int counter = queue.size();
            for (int i = counter; i > 0; i--) {
                Node node = queue.poll();
                System.out.print(" [ " + node.key + " ] ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl<String, Integer>();
        bst.put("Tom", 23);
        bst.put("Jerry", 2);
        bst.put("To", 12);
        bst.put("Tom3", 12);
        bst.put("Jerry3", 12);
        bst.printTree();
    }
}
