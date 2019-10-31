package medium;

/*
    Given a list of words, each word consists of English lowercase letters.

    Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.
    For example, "abc" is a predecessor of "abac".

    A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
    where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

    Return the longest possible length of a word chain with words chosen from the given list of words.
 */

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public static void main(String... args) {

        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        LongestStringChain longestStringChain = new LongestStringChain();
        System.out.println(longestStringChain.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {

        int n = words.length;
        if (n == 1) return 1;
        Arrays.sort(words, Comparator.comparing(i -> i.length()));
        boolean[][] t = new boolean[n+1][n+1];
        int[] f = new int[n+1];
        int max = f[1] = 1;
        char[] u, v;
        int[][] g;

        for (int i = 1; i < n; i++) {

            int k = words[i-1].length();

            for (int j = 2; j <= n; j++) {

                int p = words[j-1].length();
                if (p - k > 1) break;

                if (p == k+1) {

                    int x = words[i-1].length();
                    int y = words[j-1].length();
                    u = words[i-1].toCharArray();
                    v = words[j-1].toCharArray();
                    g = new int[x+1][y+1];

                    for (int a = 1; a <= x; a++)
                        for (int b = 1; b <= y; b++)
                            if (u[a-1] == v[b-1]) g[a][b] = g[a-1][b-1] + 1;
                            else g[a][b] = Math.max(g[a][b-1], g[a-1][b]);

                    t[i][j] = g[x][y] == x;
                }
            }
        }

        for (int i = 2; i <= n; i++) {

            f[i] = 1;
            int k = words[i-1].length();

            for (int j = i - 1; j >= 1; j--) {

                int p = words[j-1].length();
                if (k - p > 1) break;
                if (k == p+1 && t[j][i]) f[i] = Math.max(f[i], f[j] + 1);
            }

            max = Math.max(max, f[i]);
        }

        return max;
    }

}
