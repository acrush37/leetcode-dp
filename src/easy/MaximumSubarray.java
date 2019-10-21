package easy;

/*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */

public class MaximumSubarray {

    public static void main(String... args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        if (nums == null) return 0;
        int max = nums[0];
        int size = nums.length;
        int[] f = new int[size];
        f[0] = nums[0];

        for (int i = 1; i < size; i++) {

            f[i] = Math.max(nums[i], f[i-1] + nums[i]);
            max = Math.max(max, f[i]);
        }

        return max;
    }

}
