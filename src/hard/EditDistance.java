package hard;

/*
    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
 */
public class EditDistance {

    public static void main(String... args) {

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] f = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) f[i][0] = f[i-1][0] + 1;
        for (int i = 1; i <= n; i++) f[0][i] = f[0][i-1] + 1;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (word1.charAt(i-1) == word2.charAt(j-1)) f[i][j] = f[i-1][j-1];
                else f[i][j] = 1 + Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1]));

        return f[m][n];
    }

}
