package hard;

/*
    Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
    If multiple answers exist, you may return any of them.
 */
public class ShortestCommonSupersequence {

    public static void main(String... args) {

        String str1 = "adbddcdt";
        String str2 = "cabyc";
        ShortestCommonSupersequence shortestCommonSupersequence = new ShortestCommonSupersequence();
        System.out.println(shortestCommonSupersequence.shortestCommonSupersequence(str1, str2));
    }

    private void dfs(int k, int m, int n, char[] a, char[] c, int[][] t) {

        if (t[m][n] == 2) dfs(k, m-1, n, a, c, t);
        else if (t[m][n] == 3) dfs(k, m, n-1, a, c, t);
        else if (t[m][n] == 1) {
            c[k--] = a[m-1];
            dfs(k, m-1, n-1, a, c, t);
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int[][] f = new int[m+1][n+1], t = new int[m+1][n+1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (a[i-1] == b[j-1]) {
                    t[i][j] = 1;
                    f[i][j] = f[i-1][j-1] + 1;
                } else if (f[i-1][j] > f[i][j-1]) {
                    t[i][j] = 2;
                    f[i][j] = f[i-1][j];
                } else {
                    t[i][j] = 3;
                    f[i][j] = f[i][j-1];
                }

        if (f[m][n] == 0) return str1 + str2;
        char[] ch = new char[f[m][n]];
        dfs(f[m][n]-1, m, n, a, ch, t);
        StringBuilder s = new StringBuilder();
        int x = 0, y = 0;

        for (char c : ch) {

            while (a[x] != c) s.append(a[x++]);
            while (b[y] != c) s.append(b[y++]);
            s.append(c);
            x++;
            y++;
        }

        while (x < m) s.append(a[x++]);
        while (y < n) s.append(b[y++]);
        return s.toString();
    }

}
