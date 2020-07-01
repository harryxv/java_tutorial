package algorithms.common;

import java.util.Arrays;

/**
 * use string.toCharaArray() to get a character array.
 *
 * use String(char[])  constructor to get a String from an array
 */
public class ConvertStringToArrayOfCharacter {
    public static void main(String[] args) {
        String s = "this is a string";
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));

        String s1 = new String(arr);
        System.out.println(s1);
    }
}
