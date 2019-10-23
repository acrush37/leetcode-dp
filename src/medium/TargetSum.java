package medium;

/*
    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.

    Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

    Find out how many ways to assign symbols to make sum of integers equal to target S.
 */

public class TargetSum {

    public static void main(String... args) {

        int S = 3;
        int[] nums = {1, 1, 1, 1, 1};
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(nums, S));
    }

    private int find(int k, int[] nums, int s) {

        if (k < 0) return s == 0 ? 1 : 0;
        return find(k-1, nums, s-nums[k]) + find(k-1, nums, s+nums[k]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return find(nums.length-1, nums, S);
    }

}
