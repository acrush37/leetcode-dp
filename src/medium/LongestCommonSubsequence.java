package medium;

/*
    Given two strings text1 and text2, return the length of their longest common subsequence.

    A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters.
    (eg, "ace" is a subsequence of "abcde" while "aec" is not).
    A common subsequence of two strings is a subsequence that is common to both strings.

    If there is no common subsequence, return 0.
 */

public class LongestCommonSubsequence {

    public static void main(String... args) {

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "def"));
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] f = new int[m+1][n+1];
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (a[i-1] == b[j-1]) f[i][j] = f[i-1][j-1] + 1;
                else f[i][j] = Math.max(f[i-1][j], f[i][j-1]);

        return f[m][n];
    }

}
