package algorithms.common.String;

import java.util.*;

public class Permutation {

    public static List<String> getAllPermutations(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        String source;
        int qSize = queue.size();

        for (int i = 0; i < s.length(); i++) {
            int newQSize = 0;
            for (int k = 0; k < qSize; k++) {
                source = queue.poll();

                for (int j = i; j < s.length(); j++) {
                    queue.add(swap(source, i, j));
                    newQSize++;
                }

            }
            qSize = newQSize;
        }
        return new ArrayList<>(queue);
    }


    public static String swap(String s, int first, int second) {
        if (first == second) return s;
        char[] chars = s.toCharArray();

        char tmp = chars[first];
        chars[first] = chars[second];
        chars[second] = tmp;

        return new String(chars);
    }

    public static void main(String[] args) {
        List<String> permutations = getAllPermutations("ABC");
        permutations.forEach(System.out::println);
//        String result = exchange("abced", 0, 1);
//        System.out.println(result);
    }
}
