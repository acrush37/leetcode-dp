package medium;

/*
    Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous
    subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 */

public class ContinuousSubarraySum {

    public static void main(String... args) {

        int[] nums1 = {23, 2, 4, 6, 7};
        int[] nums2 = {23, 2, 6, 4, 7};
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        System.out.println(continuousSubarraySum.checkSubarraySum(nums1, 6));
        System.out.println(continuousSubarraySum.checkSubarraySum(nums2, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        if (n < 2) return false;

        if (k == 0) {

            for (int i = 1; i < n; i++)
                if (nums[i-1] == 0 && nums[i] == 0)
                    return true;

            return false;
        }

        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) f[i] = f[i-1] + nums[i-1];

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= n; j++)
                if ((f[j] - f[j-i]) % k == 0) return true;

        return false;
    }

}
