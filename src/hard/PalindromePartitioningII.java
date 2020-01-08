package hard;

/*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class PalindromePartitioningII {

    public static void main(String... args) {

        PalindromePartitioningII palindromePartitioningII = new PalindromePartitioningII();
        System.out.println(palindromePartitioningII.minCut("aab"));
    }

    public int minCut(String s) {

        int n = s.length();
        if (n <= 1) return 0;
        int[] f = new int[n];
        char[] a = s.toCharArray();
        boolean[][] t = new boolean[n][n];
        for (int i = 0; i < n; i++) t[i][i] = true;
        for (int i = 1; i < n; i++) if (a[i] == a[i-1]) t[i-1][i] = true;

        for (int j = 2; j < n; j++)
            for (int i = 0; i < n-j; i++)
                t[i][i+j] = t[i+1][i+j-1] && a[i] == a[i+j];

        for (int i = 1; i < n; i++)
            if (!t[0][i]) {
                f[i] = f[i-1] + 1;
                for (int j = 1; j < i; j++) if (t[j][i]) f[i] = Math.min(f[i], f[j-1] + 1);
            }

        return f[n-1];
    }

}
