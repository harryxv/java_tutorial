package algorithms.dataStructure;

import java.util.*;

public class TrieImpl {
    private Node root;

    private class Node {
        private boolean isWord;
        private Map<Character, Node> children;

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public Node() {
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    public TrieImpl() {
        root = new Node();
    }

    public void addString(String s) {
        Node parent = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            boolean isWord = (i == s.length() - 1);
            parent = put(parent, c, isWord);
        }
    }

    //recursively put node to the tries
    Node put(Node parent, Character c, boolean isWord) {
        Node node = parent.getChildren().get(c);
        if (node != null) {
            if (isWord) node.setWord(true);
        } else {
            node = new Node();
            node.setWord(isWord);
            parent.getChildren().put(c, node);
        }
        return node;
    }

    private Node find(Node parent, Character c) {
        return parent.getChildren().get(c);
    }

    private Set<String> search(String prefix) {
        Set<String> result = new LinkedHashSet<>();
        Node parent = root;
        for (int i = 0; i < prefix.length() && (parent != null); i++) {
            Character c = prefix.charAt(i);
            parent = find(parent, c);
        }
        collect(prefix, parent, result);
        return result;
    }

    private void collect(String prefix, Node node, Set<String> result) {
        if (node == null) return;
        if (node.isWord()) result.add(prefix);
        for (Map.Entry<Character, Node> entry : node.getChildren().entrySet()) {
            collect(prefix + entry.getKey(), entry.getValue(), result);
        }
    }


    public static void main(String[] args) {
        String[] strings = {"tomcat", "jerry", "tommy", "jeep", "thanks", "todolist"};
        TrieImpl trie = new TrieImpl();
        for (String s : strings) {
            trie.addString(s);
        }
        Set<String> result = trie.search("to");
        System.out.println(result);
        Set<String> result1 = trie.search("tom");
        System.out.println(result1);

    }
}
