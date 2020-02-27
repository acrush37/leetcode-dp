package hard;

/*
    Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.
 */
public class CountDifferentPalindromicSubsequences {

    public static void main(String... args) {

        CountDifferentPalindromicSubsequences countDifferentPalindromicSubsequences = new CountDifferentPalindromicSubsequences();
        System.out.println(countDifferentPalindromicSubsequences.countPalindromicSubsequences("bccb"));
    }

    public int countPalindromicSubsequences(String S) {

        int n = S.length(), p = 1000000007;
        char[] c = S.toCharArray();
        int[] a = {-1, -1, -1, -1};
        int[][] f = new int[n][n];
        int[] l = new int[n], r = new int[n];

        for (int i = 0; i < n; i++) {

            l[i] = n;
            r[i] = -1;
            f[i][i] = 1;
            int x = c[i] - 97;

            if (a[x] != -1) {
                l[a[x]] = i;
                r[i] = a[x];
            }

            a[x] = i;
        }

        for (int i = n-2; i >= 0; i--)
            for (int j = i+1; j < n; j++) {

                if (c[i] != c[j]) f[i][j] = f[i][j-1] + f[i+1][j] - f[i+1][j-1];
                else {

                    int x = Math.min(l[i], j), y = Math.max(r[j], x-1);

                    if (x > y) f[i][j] = (f[i+1][j-1] << 1) + 2;
                    else if (x == y) f[i][j] = (f[i+1][j-1] << 1) + 1;
                    else f[i][j] = (f[i+1][j-1] << 1) - f[x+1][y-1];
                }

                f[i][j] = (f[i][j] % p + p) % p;
            }

        return f[0][n-1];
    }

}
