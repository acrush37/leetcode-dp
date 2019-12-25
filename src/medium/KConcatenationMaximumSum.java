package medium;

/*
    Given an integer array arr and an integer k, modify the array by repeating it k times.
    For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

    Return the maximum sub-array sum in the modified array.
    Note that the length of the sub-array can be 0 and its sum in that case is 0.

    As the answer can be very large, return the answer modulo 10^9 + 7.
 */
public class KConcatenationMaximumSum {

    public static void main(String... args) {

        int[] arr = {-5, 4, -4, -3, 5, -3};
        KConcatenationMaximumSum kConcatenationMaximumSum = new KConcatenationMaximumSum();
        System.out.println(kConcatenationMaximumSum.kConcatenationMaxSum(arr, 5));
    }

    public int kConcatenationMaxSum(int[] arr, int k) {

        int n = arr.length, left = Math.max(0, arr[0]), x = arr[0], y = arr[n-1];
        int[] f = new int[n];
        int max = Math.max(0, f[0] = arr[0]), right = Math.max(0, arr[n-1]);

        for (int i = 1; i < n; i++) {

            f[i] = arr[i] + Math.max(0, f[i-1]);
            max = Math.max(max, f[i]);
            left = Math.max(left, x += arr[i]);
        }

        if (max == 0 || k == 1) return max;
        for (int i = n-2; i >= 0; i--) right = Math.max(right, y += arr[i]);
        if (k == 2 || x <= 0) return Math.max(max, left + right);
        int result = 0, mod = 1000000007;
        for (int i = 2; i < k; i++) result = (result + x) % mod;
        return (result + left + right) % mod;
    }

}
