package algorithms.common;

import java.util.*;

public class StringUtils {
    private final static String REGEX_SINGLE_DIGIT = "\\d"; // a single digit
    private final static String REGEX_SINGLE_WHITESPACE = "\\s"; // a single digit
    private final static String REGEX_WHITESPACE = "\\s+"; // split by one or multiple whitespace

    public static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    /**
     * get longest common prefix
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String lcp(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int i;
        for (i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) break;
        }
        return s1.substring(0, i);
    }

    public static List<String> getAllSubstrings(String s) {
        List<String> substrings = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings;
    }

    //REGEXP
    public static String[] splitBySingleDigit(String s) {
        return s.split(REGEX_SINGLE_DIGIT);
    }

    public static String[] splitByWhitespace(String s) {
        return s.split(REGEX_SINGLE_WHITESPACE);
    }

    public static String[] splitByWhitespaces(String s) {
        return s.split(REGEX_WHITESPACE);
    }

    /**
     * check starting from side
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int l = 0, r = len - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }

    /**
     * @param s
     * @param firstIndex
     * @param lastIndex
     * @return
     */
    private static boolean isPalindrome(String s, int firstIndex, int lastIndex) {
        boolean isOdd = (lastIndex - firstIndex + 1) % 2 == 1;
        int midIndex = firstIndex + (lastIndex - firstIndex) / 2; //(pointing to the left side of middles, or the middle)
        for (int left = isOdd ? midIndex - 1 : midIndex, right = midIndex + 1;
             left >= firstIndex && right <= lastIndex;
             left--, right++) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }

    /**
     * @param s
     * @param firstIndex
     * @param lastIndex
     * @return
     */
    private static String palindromeSubstring(String s, int firstIndex, int lastIndex) {
        boolean isPalindrome = true;
        boolean isOdd = (lastIndex - firstIndex + 1) % 2 == 1;
        int midIndex = firstIndex + (lastIndex - firstIndex) / 2; //(pointing to the left side of middles, or the middle)
        int left = isOdd ? midIndex - 1 : midIndex, right = midIndex + 1;
        for (;
             left >= firstIndex && right <= lastIndex;
             left--, right++) {
            //System.out.println(s.charAt(left) + " == " + s.charAt(right));
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome ? s.substring(firstIndex, lastIndex + 1) : s.substring(left + 1, right);
    }

    public static List<String> getAllPalindromeSubstrings(String s) {
        List<String> allPalindromeSubstrings = new LinkedList<>();
        int N = s.length();
        for (int i = 0; i < s.length(); i++) {
            String palindromSub = palindromeSubstring(s, i, Math.min(2 * i, N - 1));
            if (palindromSub.length() > 1) allPalindromeSubstrings.add(palindromSub);
            palindromSub = palindromeSubstring(s, i, Math.min(2 * i + 1, N - 1));
            if (palindromSub.length() > 1) allPalindromeSubstrings.add(palindromSub);
        }
        return allPalindromeSubstrings;
    }

    public static List<String> getAllPermutations(String s) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        String s = "thisABCBA";
//        System.out.println(reverse(s));
//
//        List<String> subs = getAllSubstrings(s);
//        System.out.println("there are " + subs.size() + " subStrings for string \"" + s + "\"");
//        subs.forEach(System.out::println);

//        String s1 = "thisasfdsafsad";
//        System.out.println(lcp(s1, s));

//        String[] strings = splitBySingleDigit("ab1cd3ef56ghh");
//        for (String string : strings) {
//            System.out.println(string);
//        }

//        String[] strings = splitByWhitespace("ab 1cd   3ef56ghh");
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        String[] strings = splitByWhitespaces("ab 1cd   3ef56ghh");
//        for (String string : strings) {
//            System.out.println(string);
//        }

//        String palindromeSub = palindromeSubString("thisabcbathat");
//        System.out.println(palindromeSub);

//        String palindromeString = "abccba";
//        System.out.println(isPalindrome(palindromeString, 0, 5));
//        System.out.println(palindromeSubstring("thisabccbae", 3, 10));

        List<String> allPalindromes = getAllPalindromeSubstrings("thisabcbaeabcbahhh");
        allPalindromes.forEach(System.out::println);

        List<String> permutations = getAllPermutations("ABC");
        permutations.forEach(System.out::println);
    }
}
