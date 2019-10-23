package medium;

/*
    A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

    For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
    OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
    That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

    Return the length of a maximum size turbulent subarray of A.
 */

public class LongestTurbulentSubarray {

    public static void main(String... args) {

        int[] A1 = {9,4,2,10,7,8,8,1,9};
        int[] A2 = {4, 8, 12, 16};
        int[] A3 = {100};
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(A1));
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(A2));
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(A3));
    }

    public int maxTurbulenceSize(int[] A) {

        int n = A.length;
        if (n == 1) return 1;
        int max = 1;
        int[] f = new int[n+1];

        for (int i = 2; i <= n; i++) f[i] = A[i-2] == A[i-1] ? 1 : 2;

        for (int i = 3; i <= n; i++)
            if (A[i-1] > A[i-2] && A[i-3] > A[i-2] || A[i-1] < A[i-2] && A[i-3] < A[i-2])
                f[i] = f[i-1] + 1;

        for (int i = 2; i <= n; i++) max = Math.max(max, f[i]);

        return max;
    }

}
