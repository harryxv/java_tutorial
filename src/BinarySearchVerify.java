import java.util.Arrays;

public class BinarySearchVerify {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 8, 9};
        //Arrays.sort(arr);
        int pos_built_in = Arrays.binarySearch(arr, 5);
        int pos = binarySearch(arr, 5);
        System.out.println(pos_built_in + "-- " + pos);
        System.out.println((1)/2);
        System.out.println(Math.round(0.5));
        double floatValue = 225.7;
        int intValue = (int) floatValue;
        System.out.println("The int value is: " + intValue);
    }

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
}
