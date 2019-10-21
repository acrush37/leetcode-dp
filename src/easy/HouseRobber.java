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
        return 0;
    }

}
