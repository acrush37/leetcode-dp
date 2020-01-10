package hard;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string S and a string T, count the number of distinct subsequences of S which equals T.

    A subsequence of a string is a new string which is formed from the original string by deleting some
    (can be none) of the characters without disturbing the relative positions of the remaining characters.
 */
public class DistinctSubsequences {

    private Map<String, Integer>[] f;

    public static void main(String... args) {

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("babgbag", "bag"));
    }

    private int dfs(int k, int p, int m, int n, char[] a, char[] b, String[] c) {

        if (k == n) return 1;
        Integer x = f[k].get(c[p]);
        if (x != null) return x;
        int y = m-n+k;
        x = 0;

        for (int i = p; i <= y; i++)
            if (a[i] == b[k])
                x += dfs(k+1, i+1, m, n, a, b, c);

        f[k].put(c[p], x);
        return x;
    }

    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        f = new Map[m];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        String[] c = new String[m];
        StringBuilder sb = new StringBuilder();

        for (int i = m-1; i >= 0; i--) {
            f[i] = new HashMap<>();
            c[i] = sb.insert(0, a[i]).toString();
        }

        return dfs(0, 0, m, n, a, b, c);
    }

}
