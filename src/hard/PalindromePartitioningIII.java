package hard;

/*
    You are given a string s containing lowercase letters and an integer k. You need to :

    First, change some characters of s to other lowercase English letters.
    Then divide s into k non-empty disjoint substrings such that each substring is palindrome.

    Return the minimal number of characters that you need to change to divide the string.
 */
public class PalindromePartitioningIII {

    public static void main(String... args) {

        PalindromePartitioningIII palindromePartitioningIII = new PalindromePartitioningIII();
        System.out.println(palindromePartitioningIII.palindromePartition("zepagxqjowzac", 2));
    }

    public int palindromePartition(String s, int k) {

        int n = s.length();
        char[] c = s.toCharArray();
        int[][] t = new int[n][n], f = new int[n][2];

        for (int i = 0; i < n-1; i++)
            for (int j = 1; j < n; j++) {
                int x = i + j, y = (x - 1) >> 1;
                for (int p = i; p <= y ; p++) if (c[p] != c[x-p]) t[i][j]++;
            }

        for (int i = 1; i < n; i++) f[i][0] = t[0][i];

        for (int j = 1; j < k; j++) {

            int x = j & 1;

            for (int i = j; i < n; i++) {
                f[i][x] = n;
                for (int p = j - 1; p < i; p++) f[i][x] = Math.min(f[i][x], t[p+1][i] + f[p][x^1]);
            }
        }

        return f[n-1][k & 1 ^ 1];
    }

}
