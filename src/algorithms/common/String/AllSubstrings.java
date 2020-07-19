package algorithms.common.String;

import java.util.*;

/**
 * given a string, list all substrings
 */
public class AllSubstrings {
    public static List<String> listAllSubstrings(String s) {
        List<String> allSubs = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                allSubs.add(s.substring(i, j));
            }
        }
        return allSubs;
    }

    public static void main(String[] args) {
        String s = "string";
        List<String> subs = listAllSubstrings(s);
        System.out.println("there are " + subs.size() + " subStrings for string \"" + s + "\"");
        subs.forEach(System.out::println);
    }
}
