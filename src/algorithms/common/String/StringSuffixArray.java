package algorithms.common.String;

import java.util.Arrays;

public class StringSuffixArray {

    private static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        char tmp;
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcde"));

        String s = "thisABCDEDCBAHasPalindromeAndABCBA";
        String s_reverse = reverseString(s);

        int len = s.length();
        String[] sa = new String[s.length() * 2];
        for (int i = 0; i < len; i++) {
            sa[i] = s.substring(i);
        }
        for (int i = len; i < 2 * len; i++) {
            sa[i] = s_reverse.substring(i - len);
        }

        Arrays.sort(sa);
        for (String s1 : sa) {
            System.out.println(s1);
        }
    }
}
