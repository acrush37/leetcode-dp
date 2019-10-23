package medium;

/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?
 */

public class UniquePaths {

    public static void main(String... args) {

        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
        System.out.println(uniquePaths.uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {

        int[][] f = new int[m+1][n+1];
        f[0][1] = f[1][0] = 1;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (i == 1) f[i][j] = f[i][j-1];
                else if (j == 1) f[i][j] = f[i-1][j];
                else f[i][j] = f[i-1][j] + f[i][j-1];

        return f[m][n];
    }

}