package medium;

/*
    Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */

public class MaximumProductSubarray {

    public static void main(String... args) {

        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(nums1));
        System.out.println(maximumProductSubarray.maxProduct(nums2));
    }


    public int maxProduct(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        int max = f[1] = nums[0];
        g[1] = nums[0];

        for (int i = 2; i <= n; i++) {

            f[i] = g[i] = nums[i-1];

            if (nums[i-1] > 0) {
                f[i] = Math.max(f[i], f[i-1] * nums[i-1]);
                g[i] = Math.min(g[i], g[i-1] * nums[i-1]);
            } else if (nums[i-1] < 0){
                f[i] = Math.max(f[i], g[i-1] * nums[i-1]);
                g[i] = Math.min(g[i], f[i-1] * nums[i-1]);
            }

            max = Math.max(max, f[i]);
        }

        return max;
    }

}
