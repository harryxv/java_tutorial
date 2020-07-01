package algorithms.challenges;

import java.util.*;

public class LongestRecommendation {
    Map<String, List<String>> adj = new HashMap<>();
    Map<String, Boolean> marked = new HashMap<>();
    Map<String, List<String>> components = new HashMap<>();

    private static class Pair {
        String first, second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isMarked(String v) {
        return marked.get(v);
    }

    private void addPair(Pair p) {
        if (!adj.containsKey(p.first)) adj.put(p.first, new ArrayList<String>());
        if (!adj.containsKey(p.second)) adj.put(p.second, new ArrayList<String>());
        adj.get(p.first).add(p.second);
        adj.get(p.second).add(p.first);
    }

    public static void main(String[] args) {
        LongestRecommendation graph = new LongestRecommendation();
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("i1", "i2"));
        pairs.add(new Pair("i3", "i4"));
        pairs.add(new Pair("i5", "i6"));
        pairs.add(new Pair("i3", "i6"));
        List<String> list = graph.findLongestRecommendation(pairs);
        System.out.println(list);
    }

    private List<String> findLongestRecommendation(List<Pair> pairs) {
        //build Graph: distribute each pair to the adj
        pairs.forEach((Pair p) -> {
            addPair(p);
        });

        System.out.println(adj);
        //run DFS to create components
        List<String> vertices = new ArrayList<>(adj.keySet());
        vertices.forEach(e -> marked.put(e, Boolean.FALSE));
        for (String root : vertices) {
            if (!isMarked(root)) {
                components.put(root, new ArrayList<>());
                dfs(root, root);
            }
        }
        //compare longest component
        List<Map.Entry<String, List<String>>> entris = new ArrayList<>(components.entrySet());
        Collections.sort(entris, (o1, o2) -> {
            return (o1.getValue().size() == o2.getValue().size()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().size() - o1.getValue().size();
        });

        return entris.get(0).getValue();
    }

    private void dfs(String node, String root) {
        if (isMarked(node)) return;
        //start DFS
        marked.put(node, true);
        components.get(root).add(node);
        for (String v : adj.get(node)) {
            dfs(v, root);
        }
    }
}
