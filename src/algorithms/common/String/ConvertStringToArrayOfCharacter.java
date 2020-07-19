package algorithms.common.String;

import java.util.Arrays;

/**
 * use string.toCharaArray() to get a character array.
 *
 * use String(char[])  constructor to get a String from an array
 */
public class ConvertStringToArrayOfCharacter {
    public static void main(String[] args) {
        String s = "this is a string";

        //get char array from string
        char[] arr = s.toCharArray();

        //get string from array, using String constructor
        String s1 = new String(arr);
        System.out.println(s1);
    }
}
