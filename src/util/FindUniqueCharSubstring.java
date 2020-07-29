package util;

import java.util.*;

public class FindUniqueCharSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int max = 0;
        int N = s.length();
        Set<Character> dupCheck = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int endIndex = getUniqCharSubString(s, i);
            int stringLength = endIndex - i;
            if (stringLength > max) {
                max = stringLength;
            }
        }
        return max;
    }

    int getUniqCharSubString(String string, int startIndex) {
        if (string == null) return 0;
        Set<Character> dupCheck = new HashSet<>();
        int i = startIndex;
        for (; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!dupCheck.contains(c)) {
                dupCheck.add(c);
            } else {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        FindUniqueCharSubstring client = new FindUniqueCharSubstring();
        //String string = "this is a string";
        String string = "  ";
        int length = client.lengthOfLongestSubstring(string);
        System.out.println("\"" + length + "\"");
    }
}
