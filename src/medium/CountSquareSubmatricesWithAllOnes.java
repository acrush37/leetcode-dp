package medium;

/*
    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */
public class CountSquareSubmatricesWithAllOnes {

    public static void main(String... args) {

        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        CountSquareSubmatricesWithAllOnes countSquareSubmatricesWithAllOnes = new CountSquareSubmatricesWithAllOnes();
        System.out.println(countSquareSubmatricesWithAllOnes.countSquares(matrix));
    }

    private int dfs(int x, int y, int[][] matrix) {

        int count = 1, n = Math.min(x, y);

        for (int i = 1; i <= n; i++) {

            for (int j = x-i; j <= x; j++) if (matrix[j][y-i] == 0) return count;
            for (int j = y-i; j <= y; j++) if (matrix[x-i][j] == 0) return count;
            count++;
        }

        return count;
    }

    public int countSquares(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m][n];
        f[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) f[i][0] = f[i-1][0] + matrix[i][0];
        for (int i = 1; i < n; i++) f[0][i] = f[0][i-1] + matrix[0][i];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                f[i][j] = f[i-1][j] + f[i][j-1] - f[i-1][j-1] + (matrix[i][j] == 0 ? 0 : dfs(i, j, matrix));

        return f[m-1][n-1];
    }

}
