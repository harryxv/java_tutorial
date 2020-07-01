public class StringBuilderVerify {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("prefix");
        StringBuilder sbCopy = new StringBuilder(sb);
        System.out.println(sb.append("a"));
        System.out.println(sb.append("b"));
        System.out.println(sbCopy);
    }
}

