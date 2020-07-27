package algorithms.dataStructure;

import java.util.Arrays;

public class ArrayBinarySearch {

    /**
     * binary search sorted array.
     * return position if found
     * -(insertion_postion) -1: to avoid 0 confusion.
     * or return
     *
     * @param arr
     * @param key
     * @return
     */
    static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1, mid = lo + (hi - lo) / 2;
        while (hi >= lo) {
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) hi = mid - 1;
            else lo = mid + 1;
            mid = lo + (hi - lo) / 2;
        }
        return -mid - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 8, 9};
        int pos_built_in = Arrays.binarySearch(arr, 4);
        int pos = binarySearch(arr, 4);
        System.out.println(pos_built_in + "-- " + pos);
    }
}
