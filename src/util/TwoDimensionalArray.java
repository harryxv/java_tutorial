package util;


/**
 * a Two-dimensional array is a array of one-dimensional array
 * (array of arrays)
 * <p>
 * int[] a = {1,1,2,3,5,8}; //fabnaci
 * int[][] b = {
 * {1,1,2,3,5,8},
 * {1,1,2,3,5,8},
 * {1,1,2,3,5,8},
 * };
 */
public class TwoDimensionalArray {
    //illustrate an M-by-N two-dimensional arrays:
    //are arrays of M Rows, each an array of length N. (N columns)

    public TwoDimensionalArray(int M, int N) {
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; i++) {
                arr[i][j] = i * j;
            }
        }
    }
}
