package medium;

/*
    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {

    public static void main(String... args) {

        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) return 0;
        int max = 0, n = matrix[0].length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1') {

                    f[i][j] = 1;

                    if (i >= 1 && j >= 1 && matrix[i-1][j-1] == '1') {

                        int k = 1;
                        while (k <= f[i-1][j-1] && matrix[i][j-k] == '1' && matrix[i-k][j] == '1') k++;
                        f[i][j] = k;
                    }

                    max = Math.max(max, f[i][j]);
                }

        return max * max;
    }

}
