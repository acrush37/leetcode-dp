package medium;

/*
    A sequence X_1, X_2, ..., X_n is fibonacci-like if:

    n >= 3  X_i + X_{i+1} = X_{i+2} for all i + 2 <= n

    Given a strictly increasing array A of positive integers forming a sequence,
    find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 */

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {

    public static void main(String... args) {

        int[] A1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] A2 = {1, 3, 7, 11, 12, 14, 18};
        int[] A3 = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = new LengthOfLongestFibonacciSubsequence();
        System.out.println(lengthOfLongestFibonacciSubsequence.lenLongestFibSubseq(A1));
        System.out.println(lengthOfLongestFibonacciSubsequence.lenLongestFibSubseq(A2));
        System.out.println(lengthOfLongestFibonacciSubsequence.lenLongestFibSubseq(A3));
    }

    public int lenLongestFibSubseq(int[] A) {

        int n = A.length;
        int[][] f = new int[n+1][n+1];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 2;

        for (int i = 0; i < n; i++) map.put(A[i], i+1);

        for (int i = 1; i < n; i++)
            for (int j = i+1; j <= n; j++)
                f[i][j] = 2;

        for (int i = 2; i < n; i++)
            for (int j = i+1; j <= n; j++) {

                int k = A[j-1] - A[i-1];
                Integer p = map.get(k);

                if (p != null && p < i) {

                    f[i][j] = f[p][i] + 1;
                    max = Math.max(max, f[i][j]);
                }
            }

        return max == 2 ? 0 : max;
    }

}
