package medium;

/*
    Given an integer array with all positive numbers and no duplicates,
    find the number of possible combinations that add up to a positive integer target.
 */

import java.util.Arrays;

public class CombinationSumIV {

    public static void main(String... args) {

        int[] nums = {1, 2, 3};
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        System.out.println(combinationSumIV.combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        int[] f = new int[target+1];
        f[0] = 1;

        for (int i = nums[0]; i <= target; i++)
            for (int num : nums)
                if (num > i) break;
                else f[i] += f[i-num];

        return f[target];
    }

}
