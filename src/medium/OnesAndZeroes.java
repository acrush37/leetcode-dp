package medium;

/*
    In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

    For now, suppose you are a dominator of m 0s and n 1s respectively.
    On the other hand, there is an array with strings consisting of only 0s and 1s.

    Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
    Each 0 and 1 can be used at most once.
 */
public class OnesAndZeroes {

    public static void main(String... args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        System.out.println(onesAndZeroes.findMaxForm(strs, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {

        int p = strs.length;
        int[][] t = new int[p+1][2];
        int[][][] f = new int[2][m+1][n+1];

        for (int i = 0; i < p; i++) {
            char[] ch = strs[i].toCharArray();
            for (char c : ch) t[i+1][c-48]++;
        }

        for (int i = 1; i <= p; i++) {

            int q = i & 1;

            for (int j = 0; j <= m; j++)
                for (int k = 0; k <= n; k++)
                    f[q][j][k] = f[q^1][j][k];

            for (int j = 0; j <= m; j++)
                for (int k = 0; k <= n; k++)
                    if (t[i][0] <= j && t[i][1] <= k)
                        f[q][j][k] = Math.max(f[q][j][k], 1 + f[q^1][j - t[i][0]][k - t[i][1]]);
        }

        return f[p & 1][m][n];
    }

}
