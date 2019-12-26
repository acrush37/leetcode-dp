package medium;

/*
    Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 */
public class MinimumAsciiDeleteSumForTwoStrings {

    public static void main(String... args) {

        MinimumAsciiDeleteSumForTwoStrings minimumAsciiDeleteSumForTwoStrings = new MinimumAsciiDeleteSumForTwoStrings();
        System.out.println(minimumAsciiDeleteSumForTwoStrings.minimumDeleteSum("delete", "leet"));
    }

    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        int[][] f = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) f[i][0] = f[i-1][0] + a[i-1];
        for (int j = 1; j <= n; j++) f[0][j] = f[0][j-1] + b[j-1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (a[i-1] == b[j-1]) f[i][j] = f[i-1][j-1];
                else f[i][j] = Math.min(f[i-1][j] + a[i-1], f[i][j-1] + b[j-1]);

        return f[m][n];
    }

}