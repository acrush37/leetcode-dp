package medium;

/*
    Given a non-empty array containing only positive integers, find if the array can be
    partitioned into two subsets such that the sum of elements in both subsets is equal.
 */

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String... args) {

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {1, 2, 3, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(nums1));
        System.out.println(partitionEqualSubsetSum.canPartition(nums2));
    }

    private boolean find(int s, int k, int[] nums) {

        if (s == 0) return true;
        if (k < 0 || nums[k] > s) return false;
        return find(s - nums[k], k - 1, nums) || find(s, k - 1, nums);
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        if (n == 1) return false;
        int s = 0;
        for (int num : nums) s += num;
        if ((s & 1) == 1) return false;
        Arrays.sort(nums);
        return find(s >> 1, n-1, nums);
    }

}
