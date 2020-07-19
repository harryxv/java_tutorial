package algorithms.common.String;

/**
 * given a string, abcddcba, check whether this is a palindrome.
 * 2 ways to check
 */
public class PalindromeString {
    public static boolean isPalindrome(String s) {
        return isPalindromeByDefinition(s);
    }

    private static boolean isPalindromeByDefinition(String s) {
        int len = s.length();
        for (int l = 0, r = len - 1; l <= r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }

    private static boolean isPalindromByCheckingFromMiddle(String s) {
        int mid = s.length();
        for (int l = mid - 1, r = s.length() % 2 == 0 ? mid : mid + 1; l >= 0 && r < s.length(); l--, r++) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdddcba";
        boolean isPalindrom = isPalindromeByDefinition(s);
        System.out.format("is \"%s\" palindrom? %b\r", s, isPalindrom);
        System.out.println();

        isPalindrom = isPalindromByCheckingFromMiddle(s);
        System.out.format("is \"%s\" palindrom? %b\r", s, isPalindrom);

    }
}
