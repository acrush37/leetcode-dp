package hard;

/*
    Given a square grid of integers arr, a falling path with non-zero shifts is a choice of exactly one
    element from each row of arr, such that no two elements chosen in adjacent rows are in the same column.

    Return the minimum sum of a falling path with non-zero shifts.
 */
public class MinimumFallingPathSumII {

    public static void main(String... args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MinimumFallingPathSumII minimumFallingPathSumII = new MinimumFallingPathSumII();
        System.out.println(minimumFallingPathSumII.minFallingPathSum(arr));
    }

    public int minFallingPathSum(int[][] arr) {

        int result = Integer.MAX_VALUE, n = arr.length, x = 0;
        int[][] f = new int[n][2];
        for (int i = 0; i < n; i++) f[i][0] = arr[0][i];

        for (int i = 1; i < n; i++) {

            x = i & 1;
            int y = x ^ 1;
            for (int j = 0; j < n; j++) f[j][x] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++)
                    if (j != k)
                        f[j][x] = Math.min(f[j][x], f[k][y]);

                f[j][x] += arr[i][j];
            }
        }

        for (int i = 0; i < n; i++) result = Math.min(result, f[i][x]);
        return result;
    }

}
