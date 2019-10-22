package medium;

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {

    public static void main(String... args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] f = new int[m+1][n+1];
        f[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) f[i][0] = f[i-1][0] + grid[i][0];
        for (int i = 1; i < n; i++) f[0][i] = f[0][i-1] + grid[0][i];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];

        return f[m-1][n-1];
    }

}
