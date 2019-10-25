package medium;

/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */

public class UniquePathsII {

    public static void main(String... args) {

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m+1][n+1];
        f[0][1] = 1;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (obstacleGrid[i-1][j-1] == 0)
                    f[i][j] = f[i][j-1] + f[i-1][j];

        return f[m][n];
    }

}
