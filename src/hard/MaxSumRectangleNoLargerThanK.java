package hard;

/*
    Given a non-empty 2D matrix matrix and an integer k, find the max sum
    of a rectangle in the matrix such that its sum is no larger than k.
 */
public class MaxSumRectangleNoLargerThanK {

    public static void main(String... args) {

        int[][] matrix = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        MaxSumRectangleNoLargerThanK maxSumRectangleNoLargerThanK = new MaxSumRectangleNoLargerThanK();
        System.out.println(maxSumRectangleNoLargerThanK.maxSumSubmatrix(matrix, 8));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int result = Integer.MIN_VALUE, m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < n; i++) {

            int[] a = new int[m];

            for (int j = i; j < n; j++) {

                for (int p = 0; p < m; p++) a[p] += matrix[p][j];

                for (int p = 0; p < m; p++) {

                    int s = 0;

                    for (int q = p; q < m; q++)
                        if ((s += a[q]) <= k) {
                            if (s == k) return k;
                            result = Math.max(result, s);
                        }
                }
            }
        }

        return result;
    }

}
