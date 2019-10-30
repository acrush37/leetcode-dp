package medium;

/*
    Given a string s, find the longest palindromic substring in s.
    You may assume that the maximum length of s is 1000.
 */

public class LongestPalindromicSubstring {

    public static void main(String... args) {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("abc"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {

        int n = s.length();
        if (n <= 1) return s;
        char[] a = s.toCharArray();
        boolean[][] f = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) f[i][i] = true;

        for (int i = 1; i < n; i++)
            if (a[i] == a[i-1])
                f[i][i+1] = true;

        for (int j = 2; j < n; j++)
            for (int i = 1; i <= n-j; i++)
                f[i][i+j] = f[i+1][i+j-1] && a[i-1] == a[i+j-1];

        for (int j = n-1; j >= 0; j--)
            for (int i = 1; i <= n-j; i++)
                if (f[i][i+j]) return s.substring(i-1, i+j);

        return null;
    }

}
