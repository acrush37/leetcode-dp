package medium;

/*
    Given an unsorted array of integers, find the length of longest increasing subsequence.
 */

public class LongestIncreasingSubsequence {

    public static void main(String... args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        if (n <= 1) return n;
        int max = 0;
        int[] f = new int[n+1];

        for (int i = 1; i <= n; i++) {

            f[i] = 1;
            for (int j = 1; j < i; j++)
                if (nums[i-1] > nums[j-1]) f[i] = Math.max(f[i], f[j]+1);
            max = Math.max(max, f[i]);
        }

        return max;
    }

}
