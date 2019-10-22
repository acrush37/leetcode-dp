package easy;

/*
    Given a string s and a string t, check if s is subsequence of t.

    You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.

    (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence {

    public static void main(String... args) {

        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {

        int x = s.length();
        if (x == 0) return true;
        int y = t.length();
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int[][] f = new int[x+1][y+1];

        for (int i = 1; i <= x; i++)
            for (int j = 1; j <= y; j++)
                if (a[i-1] == b[j-1]) f[i][j] = f[i-1][j-1] + 1;
                else f[i][j] = Math.max(f[i-1][j], f[i][j-1]);

        return f[x][y] == x;
    }

}
