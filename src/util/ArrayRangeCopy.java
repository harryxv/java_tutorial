package util;

import java.util.Arrays;

//get a sub array
public class ArrayRangeCopy {
    public int[] copyRangeOf(int[] src, int startInclusive, int endInclusive) {
        return Arrays.copyOfRange(src, startInclusive, endInclusive);
    }

    public static void main(String[] args) {
        ArrayRangeCopy test = new ArrayRangeCopy();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int from = 0;
        int width = 3;
        int to = from + width;
        int[] result = test.copyRangeOf(arr, from, to);
        System.out.println(Arrays.toString(result));
    }
}
