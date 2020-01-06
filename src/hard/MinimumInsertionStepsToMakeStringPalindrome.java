package hard;

/*
    Given a string s. In one step you can insert any character at any index of the string.

    Return the minimum number of steps to make s palindrome.
 */
public class MinimumInsertionStepsToMakeStringPalindrome {

    public static void main(String... args) {

        MinimumInsertionStepsToMakeStringPalindrome minimumInsertionStepsToMakeStringPalindrome = new MinimumInsertionStepsToMakeStringPalindrome();
        System.out.println(minimumInsertionStepsToMakeStringPalindrome.minInsertions("ab"));
    }

    public int minInsertions(String s) {

        int n = s.length();
        if (n <= 1) return 0;
        char[] c = s.toCharArray();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) f[i][i] = 1;

        for (int i = n-2; i >= 0; i--)
            for (int j = i+1; j < n; j++)
                f[i][j] = c[i] == c[j] ? f[i][j] = f[i+1][j-1] + 2 : Math.max(f[i+1][j], f[i][j-1]);

        return n - f[0][n-1];
    }

}
