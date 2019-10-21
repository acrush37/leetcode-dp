package easy;

/*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobber {

    public static void main(String... args) {

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums1));
        System.out.println(houseRobber.rob(nums2));
    }

    public int rob(int[] nums) {

        if (nums == null) return 0;
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] f = new int[n+1];
        f[1] = nums[0];
        f[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++) f[i] = Math.max(f[i-2] + nums[i-1], f[i-1]);
        return Math.max(f[n], f[n-1]);
    }

}
