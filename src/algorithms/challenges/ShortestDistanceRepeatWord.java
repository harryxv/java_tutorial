package algorithms.challenges;

import java.util.*;

public class ShortestDistanceRepeatWord {
    public static void main(String[] args) {
        String s = "hello how are hello test you really this is again hello how are you";
        String word = getShortestDist(s);
        System.out.print(word);
    }

    //Edge data type to hold every distance for a same token
    static class Edge implements Comparable<Edge> {
        String token;
        int from, to;
        int dist;

        public Edge(String token, int from, int to) {
            this.token = token;
            this.from = from;
            this.to = to;
            dist = Math.abs(from - to);
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }


    }

    //regular expression for white space, or puntuation marks
    static String getShortestDist(String s) {
        Map<String, Integer> tokenPos = new HashMap<>();  //track every token's latest index position
        List<Edge> edges = new ArrayList<>();  //hold all edges

        String[] tokens = s.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (tokenPos.containsKey(token)) {
                edges.add(new Edge(token,tokenPos.get(token),i));
                tokenPos.put(token, i);
            }else{
                tokenPos.put(token, i);
            }
        }

        Collections.sort(edges);
        edges.forEach(e->{
            System.out.println(e.token + "  " +e.dist);
        });

        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        return pq.peek().token;
    }
}
