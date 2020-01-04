package hard;

/*
    In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial
    called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.

    Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the
    keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.
 */
public class FreedomTrail {

    private int[][][] f;

    public static void main(String... args) {

        FreedomTrail freedomTrail = new FreedomTrail();
        System.out.println(freedomTrail.findRotateSteps("godding","gd"));
    }

    private int dfs(int k, int x, int m, int n, int[][] d, int[] b) {

        if (k == n) return 0;
        int y = b[k];
        if (f[x][y][k] > 0) return f[x][y][k];
        f[x][y][k] = Integer.MAX_VALUE;

        for (int i = 1; i <= d[y][0]; i++) {

            int z = Math.abs(d[y][i] - x);
            z = Math.min(z, m-z);
            f[x][y][k] = Math.min(f[x][y][k], z + dfs(k+1, d[y][i], m, n, d, b));
        }

        return ++f[x][y][k];
    }

    public int findRotateSteps(String ring, String key) {

        int m = ring.length(), n = key.length();
        int[] a = new int[m], b = new int[n];
        int[][] d = new int[26][m+1];
        char[] c = key.toCharArray();
        for (int i = 0; i < n; i++) b[i] = c[i]-97;
        c = ring.toCharArray();

        for (int i = 0; i < m; i++) {
            a[i] = c[i]-97;
            d[a[i]][++d[a[i]][0]] = i;
        }

        f = new int[m][26][n];
        return dfs(0, 0, m, n, d, b);
    }

}
