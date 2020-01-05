package hard;

/*
    Your task is to collect maximum number of cherries possible by following the rules below:

    Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells
    After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;

    When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
    If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 */
public class CherryPickup {

    public static void main(String... args) {

        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        CherryPickup cherryPickup = new CherryPickup();
        System.out.println(cherryPickup.cherryPickup(grid));
    }

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int[][][][] f = new int[n+1][n+1][n+1][n+1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                for (int k = 0; k <= n; k++)
                    for (int p = 0; p <= n; p++)
                        f[i][j][k][p] = -1;

        f[0][1][0][1] = f[0][1][1][0] = f[1][0][0][1] = f[1][0][1][0] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++)
                    for (int p = 1; p <= n; p++)
                        if (grid[i-1][j-1] != -1 && grid[k-1][p-1] != -1) {

                            if (f[i-1][j][k-1][p] != -1) f[i][j][k][p] = Math.max(f[i][j][k][p], f[i-1][j][k-1][p]);
                            if (f[i-1][j][k][p-1] != -1) f[i][j][k][p] = Math.max(f[i][j][k][p], f[i-1][j][k][p-1]);
                            if (f[i][j-1][k-1][p] != -1) f[i][j][k][p] = Math.max(f[i][j][k][p], f[i][j-1][k-1][p]);
                            if (f[i][j-1][k][p-1] != -1) f[i][j][k][p] = Math.max(f[i][j][k][p], f[i][j-1][k][p-1]);
                            if (f[i][j][k][p] != -1) f[i][j][k][p] += i == k && j == p ? grid[i-1][j-1] : grid[i-1][j-1] + grid[k-1][p-1];
                        }

        return f[n][n][n][n] == -1 ? 0 : f[n][n][n][n];
    }

}
