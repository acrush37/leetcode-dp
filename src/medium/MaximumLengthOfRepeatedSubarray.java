package medium;

/*
    Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 */

public class MaximumLengthOfRepeatedSubarray {

    public static void main(String... args) {

        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {

        int max = 0;
        int m = A.length;
        int n = B.length;
        int[][] f = new int[m+1][n+1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= m; j++) {

                if (A[i-1] != B[j-1]) f[i][j] = 0;
                else f[i][j] = f[i-1][j-1] + 1;

                max = Math.max(max, f[i][j]);
            }

        return max;
    }

}
