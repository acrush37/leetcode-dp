package medium;

/*
    Given an unsorted array of integers, find the number of longest increasing subsequence.
 */

public class NumberOfLongestIncreasingSubsequence {

    private int s = 0;

    public static void main(String... args) {

        int[] nums1 = {1, 3, 5, 4, 7};
        int[] nums2 = {2, 2, 2, 2, 2};
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        System.out.println(numberOfLongestIncreasingSubsequence.findNumberOfLIS(nums1));
        System.out.println(numberOfLongestIncreasingSubsequence.findNumberOfLIS(nums2));
    }

    private void find(int k, int p, int[] f, int[] nums) {

        if (k == 1) {
            s++;
            return;
        }

        for (int i = p-1; i >= 1; i--)
            if (f[i] == k-1 && nums[i-1] < nums[p-1])
                find(k-1, i, f, nums);
    }

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        if (n <= 1) return n;
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) f[i] = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j < i; j++)
                if (nums[i - 1] > nums[j - 1])
                    f[i] = Math.max(f[i], f[j] + 1);

            max = Math.max(max, f[i]);
        }

        if (max == 1) return n;

        for (int i = 1; i <= n; i++)
            if (f[i] == max)
                find(max, i, f, nums);

        return s;
    }

}
