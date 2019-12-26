package medium;

import java.util.Arrays;

/*
    Given an array of integers nums and a positive integer k, find whether it's possible
    to divide this array into k non-empty subsets whose sums are all equal.
 */
public class PartitionToKEqualSumSubsets {

    public static void main(String... args) {

        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        PartitionToKEqualSumSubsets partitionToKEqualSumSubsets = new PartitionToKEqualSumSubsets();
        System.out.println(partitionToKEqualSumSubsets.canPartitionKSubsets(nums, 4));
    }

    private boolean dfs(int k, int p, int n, int s, int x, int[] nums, boolean[] t) {

        if (k == 0) return true;

        for (int i = p; i >= 0; i--)
            if (!t[i] && nums[i] <= s) {

                t[i] = true;
                boolean f = nums[i] == s;
                if (dfs(k-1, f ? n-1 : i-1, n, f ? x : s-nums[i], x, nums, t)) return true;
                t[i] = false;
                while (i > 0 && nums[i-1] == nums[i]) i--;
            }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int n = nums.length;
        if (n == 1) return true;
        int s = Arrays.stream(nums).sum();
        if (s % k != 0) return false;
        Arrays.sort(nums);
        return dfs(n, n-1, n,s/k, s/k, nums, new boolean[n]);
    }

}
