package algorithms.challenges;

import java.util.*;

/**
 * given a set of numbers, find the median value
 * a value in an ordered set of values below and above which there is an equal number of values
 * or
 * which is the arithmetic mean of the two middle values if there is no one middle number
 */
public class FindMedian {
    public int getMedian(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("parameter is invalid");
            System.exit(-1);
        }

        int N = arr.length;
        Arrays.sort(arr);

        return N % 2 == 1 ? arr[N / 2] : (arr[N / 2 - 1] + arr[N / 2]) / 2;
    }

    /**
     * get array list sub arrays
     * for example: 12345: width = 3
     * then result: {1,2,3},{2,3,4},{3,4,5}
     *
     * @param arr
     * @param w:  width
     * @return
     */
    public List<int[]> copyOfRange(int[] arr, int w) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= arr.length - w; i++) {
            int[] subArr = Arrays.copyOfRange(arr, i, i + w);
            result.add(subArr);
        }
        return result;
    }

    public List<Integer> getMedians(int[] arr, int w) {
        List<Integer> result = new ArrayList<>();
        List<int[]> subArrays = copyOfRange(arr, w);
        for (int[] subArray : subArrays) {
            int median = getMedian(subArray);
            result.add(median);
        }
        return result;
    }

    public static void main(String[] args) {
        FindMedian findMedian = new FindMedian();
        int[] arr = {3, 2, 4, 51,  6, 8, 7};
        int w = 3;
        List<Integer> list = findMedian.getMedians(arr, 5);
        System.out.println(list);
    }
}
