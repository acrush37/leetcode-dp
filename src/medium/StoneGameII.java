package medium;

/*
    Alex and Lee take turns, with Alex starting first. Initially, M = 1.

    On each player's turn, that player can take all the stones in the first
    X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

    The game continues until all the stones have been taken.
    Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 */
public class StoneGameII {

    private int[][] t;

    private Integer[][][] f;

    public static void main(String... args) {

        int[] piles = {8,9,5,4,5,4,1,1,9,3,1,10,5,9,6,2,7,6,6,9};
        StoneGameII stoneGameII = new StoneGameII();
        System.out.println(stoneGameII.stoneGameII(piles));
    }

    private int dfs(int x, int y, int m, int n) {

        if (y == n) return t[x][n];
        m = Math.min(m, n - x + 1);
        if (y >= 0 && f[x][y][m] != null) return f[x][y][m];
        int max = 0, z = Math.min(n - y, m << 1);
        for (int i = 1; i <= z; i++) max = Math.max(max, dfs(y+1, y+i, Math.max(m, i), n));
        return y == -1 ? max : (f[x][y][m] = t[x][y] + t[y+1][n] - max);
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;
        int[] s = new int[n+1];
        f = new Integer[n][n][n];
        t = new int[n][n];
        for (int i = 0; i < n; i++) s[i+1] = s[i] + piles[i];

        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                t[i][j] = s[j+1] - s[i];

        return dfs(0, -1, 1, n-1);
    }

}
