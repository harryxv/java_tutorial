package algorithms.common.String;

public class FindLongestCommonPrefix {
    public String findLongestCommonPrefix(String s1, String s2) {
        int longestPrefixLength = findLongestCommonPrefixLength(s1, s2);
        return s1.substring(0, longestPrefixLength);
    }

    private int findLongestCommonPrefixLength(String s1, String s2) {
        int N = Math.min(s1.length(), s2.length());
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return N;
    }

    public static void main(String[] args) {
        FindLongestCommonPrefix me = new FindLongestCommonPrefix();
        String common = me.findLongestCommonPrefix("thisisTom","thisisJerry");
        System.out.println(common);
    }
}
