package medium;

/*
    Given a string s, find the longest palindromic subsequence's length in s.
    You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubsequence {

    public static void main(String... args) {

        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        System.out.println(longestPalindromicSubsequence.longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        if (n <= 1) return n;
        char[] c = s.toCharArray();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) f[i][i] = 1;

        for (int i = n-2; i >= 0; i--)
            for (int j = i+1; j < n; j++)
                f[i][j] = c[i] == c[j] ? f[i][j] = f[i+1][j-1] + 2 : Math.max(f[i+1][j], f[i][j-1]);

        return f[0][n-1];
    }

}
