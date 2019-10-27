package medium;

/*
    Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
    by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */

public class RangeSumQuery2DImmutable {

    private int m, n;
    private int[][] f, g;

    public static void main(String... args) {

        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        RangeSumQuery2DImmutable rangeSumQuery2DImmutable = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3));
        System.out.println(rangeSumQuery2DImmutable.sumRegion(1, 1, 2, 2));
        System.out.println(rangeSumQuery2DImmutable.sumRegion(1, 2, 2, 4));
    }

    public RangeSumQuery2DImmutable(int[][] matrix) {

        m = matrix.length;
        if (m == 0) return;
        n = matrix[0].length;
        f = new int[m+1][n+1];
        g = new int[m+1][n+1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {

                f[i][j] += f[i][j-1] + matrix[i-1][j-1];
                g[i][j] = g[i-1][j] + f[i][j];
            }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (m == 0) return 0;
        return g[row2+1][col2+1] + g[row1][col1] - g[row1][col2+1] - g[row2+1][col1];
    }

}
