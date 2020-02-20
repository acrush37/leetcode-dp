package medium;

/*
    Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all
    elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 */
public class MatrixBlockSum {

    public static void main(String... args) {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();
        System.out.println(matrixBlockSum.matrixBlockSum(mat, 1));
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int m = mat.length;
        if (m == 0) return new int[0][0];
        int n = mat[0].length;
        int[][] result = new int[m][n], s = new int[m+1][n+1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + mat[i-1][j-1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

                int a = Math.min(m, i + K + 1);
                int b = Math.min(n, j + K + 1);
                int c = Math.max(0, i - K);
                int d = Math.max(0, j - K);
                result[i][j] = s[a][b] - s[c][b] - s[a][d] + s[c][d];
            }

        return result;
    }

}
