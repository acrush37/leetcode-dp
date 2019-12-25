package medium;

/*
    Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid
    that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
 */
public class Largest1BorderedSquare {

    private Integer[][][] f;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Largest1BorderedSquare largest1BorderedSquare = new Largest1BorderedSquare();
        System.out.println(largest1BorderedSquare.largest1BorderedSquare(grid));
    }

    private int dfs(int x, int y, int k, int m, int n, int[][] grid) {

        if (x == -1 || y == -1 || x == m || y == n || grid[x][y] == 0) return 0;
        if (f[x][y][k] != null) return f[x][y][k];
        return f[x][y][k] = 1 + dfs(x + a[k], y + b[k], k, m, n, grid);
    }

    public int largest1BorderedSquare(int[][] grid) {

        int m = grid.length, n = grid[0].length, result = 0;
        f = new Integer[m][n][4];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    for (int k = 0; k <= 3; k++)
                        f[i][j][k] = 0;

        for (int k = 0; k <= 3; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (f[i][j][k] == null)
                        dfs(i, j, k, m, n, grid);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {

                    int q = Math.min(f[i][j][1], f[i][j][3]);

                    while (--q >= 0)
                        if (f[i+q][j+q][0] >= q && f[i+q][j+q][2] >= q) {
                            result = Math.max(result, (1+q) * (1+q));
                            break;
                        }
                }

        return result;
    }

}
