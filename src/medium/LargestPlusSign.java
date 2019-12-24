package medium;

/*
    In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given
    list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid?

    Return the order of the plus sign. If there is none, return 0.
 */
public class LargestPlusSign {

    private Integer[][][] f;

    private int[] a = {-1, 1, 0, 0};

    private int[] b = {0, 0, -1, 1};

    public static void main(String... args) {

        int[][] mines = {{4, 2}};
        LargestPlusSign largestPlusSign = new LargestPlusSign();
        System.out.println(largestPlusSign.orderOfLargestPlusSign(5, mines));
    }

    private int dfs(int x, int y, int k, int n, boolean[][] t) {

        if (x == -1 || y == -1 || x == n || y == n) return 0;
        if (f[x][y][k] != null) return f[x][y][k];
        if (t[x][y]) return f[x][y][k] = 0;
        return f[x][y][k] = 1 + dfs(x + a[k], y + b[k], k, n, t);
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {

        int result = 0;
        f = new Integer[N][N][4];
        boolean[][] t = new boolean[N][N];
        for (int[] x : mines) t[x[0]][x[1]] = true;

        for (int k = 0; k <= 3; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (f[i][j][k] == null)
                        dfs(i, j, k, N, t);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                result = Math.max(result,
                        Math.min(Math.min(f[i][j][0], f[i][j][1]),
                        Math.min(f[i][j][2], f[i][j][3])));

        return result;
    }

}
