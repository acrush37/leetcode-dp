package medium;

/*
    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
    That means the first house is the neighbor of the last one.

    Meanwhile, adjacent houses have security system connected and it will automatically
    contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house,
    determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {

    public static void main(String... args) {

        int[] nums = {4, 1, 2, 7, 5, 3, 1};
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(nums));
    }

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] f = new int[n];
        int result = f[0] = nums[0];

        for (int i = 2; i < n-1; i++) {
            f[i] = f[i-2] + nums[i];
            if (i >= 3) f[i] = Math.max(f[i], f[i-3] + nums[i]);
        }

        result = Math.max(result, f[n-2]);
        if (n >= 3) result = Math.max(result, f[n-3]);
        f[0] = 0;
        f[1] = nums[1];

        for (int i = 2; i < n; i++) {
            f[i] = f[i-2] + nums[i];
            if (i >= 3) f[i] = Math.max(f[i], f[i-3] + nums[i]);
        }

        return Math.max(result, Math.max(f[n-1], f[n-2]));
    }

}
