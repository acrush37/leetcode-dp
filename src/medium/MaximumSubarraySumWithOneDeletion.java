package medium;

/*
    Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion.

    In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

    Note that the subarray needs to be non-empty after deleting one element.
 */

public class MaximumSubarraySumWithOneDeletion {

    public static void main(String... args) {

        int[] arr1 = {1, -2, 0, 3};
        int[] arr2 = {1, -2, -2, 3};
        int[] arr3 = {-1, -1, -1, -1};
        MaximumSubarraySumWithOneDeletion maximumSubarraySumWithOneDeletion = new MaximumSubarraySumWithOneDeletion();
        System.out.println(maximumSubarraySumWithOneDeletion.maximumSum(arr1));
        System.out.println(maximumSubarraySumWithOneDeletion.maximumSum(arr2));
        System.out.println(maximumSubarraySumWithOneDeletion.maximumSum(arr3));
    }

    public int maximumSum(int[] arr) {

        int n = arr.length;
        if (n == 1) return arr[0];
        int max = arr[0];
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        f[1] = arr[0];
        g[n] = arr[n-1];

        for (int i = 2; i <= n; i++) f[i] = Math.max(arr[i-1], f[i-1] + arr[i-1]);
        for (int i = n-1; i >= 1; i--) g[i] = Math.max(arr[i-1], g[i+1] + arr[i-1]);
        for (int i = 1; i < n; i++) max = Math.max(max, Math.max(f[i], f[i-1] + g[i+1]));

        return Math.max(max, f[n]);
    }

}
