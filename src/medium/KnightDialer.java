package medium;

/*
    This time, we place our chess knight on any numbered key of a phone pad (indicated above),
    and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

    Each time it lands on a key (including the initial placement of the knight),
    it presses the number of that key, pressing N digits total.

    How many distinct numbers can you dial in this manner?
    Since the answer may be large, output the answer modulo 10^9 + 7.
 */
public class KnightDialer {

    private Integer[][] f;

    private int[][] t = {{2, 4, 6}, {2, 6, 8}, {2, 7, 9}, {2, 4, 8}, {3, 0, 3, 9}, {0},
            {3, 0, 1, 7}, {2, 2, 6}, {2, 1, 3}, {2, 2, 4}, {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}};

    public static void main(String... args) {

        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(3));
    }

    private int dfs(int k, int n) {

        if (k == -1) return 1;
        if (f[n][k] != null) return f[n][k];
        f[n][k] = 0;
        for (int i = 1; i <= t[n][0]; i++) f[n][k] = (f[n][k] + dfs(k-1, t[n][i])) % 1000000007;
        return f[n][k];
    }

    public int knightDialer(int N) {

        f = new Integer[11][N];
        return dfs(N-1, 10);
    }

}
