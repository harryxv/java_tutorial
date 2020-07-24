package algorithms.challenges;

import java.util.*;

public class RemoveAdjDuplicate {


    /**
     * each check follows steps:
     * 1,
     * @param s
     * @return
     */
    public static String removeAjdDupUsingStack(String s) {
        //keep final result
        Stack<Character> stack = new Stack<>();
        boolean isDuplicated = false;
        Character prev = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (prev == null) prev = stack.pop();
//            if (!isDuplicated) {
//                prev = stack.pop();
//            }
            if (c == prev) {
                isDuplicated = true;
                //skip this character, go to next
            } else {
                if (!isDuplicated) {
                    stack.push(prev);
                    stack.push(c);
                } else {
                    //check current character with the one in stack
                    i--;
                }
                isDuplicated = false;
            }
        }
        StringBuilder stringBuider = new StringBuilder();
        stack.forEach(e -> stringBuider.append(e));
        return stringBuider.toString();
    }


    //brute force solution
    public static String removeAdjDup(String source) {
        StringBuilder resut = new StringBuilder();
        boolean containDuplicated = false;

        boolean isDuplicated = false;
        char prev = source.charAt(0);
        for (int i = 1; i < source.length(); i++) {
            char cur = source.charAt(i);
            if (cur == prev) {
                containDuplicated = true;
                isDuplicated = true;
            } else {
                if (!isDuplicated) {
                    resut.append(prev);
                }
                prev = cur;
                isDuplicated = false;
            }
        }
        if (!isDuplicated)
            resut.append(prev);

        if (containDuplicated) return removeAdjDup(resut.toString());
        return resut.toString();
    }

    public static void main(String[] args) {
        String result = removeAdjDup("abcdeffedcbaedfd");
        System.out.println(result);

        result = removeAjdDupUsingStack("abcdeffedcbaedfd");
        System.out.println(result);
    }
}
