package medium;

/*
    Given a square array of integers A, we want the minimum sum of a falling path through A.

    A falling path starts at any element in the first row, and chooses one element from each row.

    The next row's choice must be in a column that is different from the previous row's column by at most one.
 */

public class MinimumFallingPathSum {

    public static void main(String... args) {

        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
        System.out.println(minimumFallingPathSum.minFallingPathSum(A));
    }

    public int minFallingPathSum(int[][] A) {

        int n = A.length;
        if (n == 1) return A[0][0];
        int[][] f = new int[n+1][n+1];
        int min = 10000;

        for (int i = 1; i <= n; i++) f[1][i] = A[0][i-1];

        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (j == 1) f[i][j] = A[i-1][j-1] + Math.min(f[i-1][j], f[i-1][j+1]);
                else if (j == n) f[i][j] = A[i-1][j-1] + Math.min(f[i-1][j], f[i-1][j-1]);
                else f[i][j] = A[i-1][j-1] + Math.min(f[i-1][j], Math.min(f[i-1][j-1], f[i-1][j+1]));

        for (int i = 1; i <= n; i++) min = Math.min(min, f[n][i]);

        return min;
    }

}
