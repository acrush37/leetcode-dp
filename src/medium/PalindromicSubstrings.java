package medium;

/*
    Given a string, your task is to count how many palindromic substrings in this string.

    The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */

public class PalindromicSubstrings {

    public static void main(String... args) {

        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("abc"));
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {

        int n = s.length();
        if (n <= 1) return n;
        char[] a = s.toCharArray();
        boolean[][] f = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) f[i][i] = true;

        for (int i = 1; i < n; i++)
            if (a[i] == a[i-1])
                f[i][i+1] = true;

        for (int j = 2; j < n; j++)
            for (int i = 1; i <= n-j; i++)
                f[i][i+j] = f[i+1][i+j-1] && a[i-1] == a[i+j-1];

        int count = 0;

        for (int j = n-1; j >= 0; j--)
            for (int i = 1; i <= n-j; i++)
                if (f[i][i+j]) count++;

        return count;
    }

}
