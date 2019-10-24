package medium;

/*
    Given an array A of integers, return the length of the longest arithmetic subsequence in A.

    Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1,
    and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 */

public class LongestArithmeticSequence {

    public static void main(String... args) {

        int[] A1 = {3, 6, 9, 12};
        int[] A2 = {9, 4, 7, 2, 10};
        int[] A3 = {20, 1, 15, 3, 10, 5, 8};
        LongestArithmeticSequence longestArithmeticSequence = new LongestArithmeticSequence();
        System.out.println(longestArithmeticSequence.longestArithSeqLength(A1));
        System.out.println(longestArithmeticSequence.longestArithSeqLength(A2));
        System.out.println(longestArithmeticSequence.longestArithSeqLength(A3));
    }

    public int longestArithSeqLength(int[] A) {

        int n = A.length;
        if (n == 2) return 2;
        int[][] f = new int[n+1][n+1];
        int max = 2;

        for (int i = 1; i < n; i++)
            for (int j = i+1; j <= n; j++)
                f[i][j] = 2;

        for (int i = 2; i <= n-1; i++)
            for (int j = i+1; j <= n; j++) {

                for (int k = 1; k < i; k++)
                    if (A[i-1] << 1 == A[j-1] + A[k-1])
                        f[i][j] = Math.max(f[i][j], f[k][i] + 1);

                max = Math.max(max, f[i][j]);
            }

        return max;
    }

}
