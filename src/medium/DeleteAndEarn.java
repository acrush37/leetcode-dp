package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given an array nums of integers, you can perform operations on the array.

    In each operation, you pick any nums[i] and delete it to earn nums[i] points.
    After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

    You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 */
public class DeleteAndEarn {

    public static void main(String... args) {

        int[] nums = {2, 2, 3, 3, 3, 4};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {

        int[] f = new int[10001];
        for (int x: nums) f[x]++;
        int x = 0, y = 0, z = 0;

        for (int i = 0; i <= 10000; i++)
            if (f[i] > 0) {

                int max = Math.max(x, y);
                y = i * f[i] + (i == z+1 ? x : max);
                x = max;
                z = i;
            }

        return Math.max(x, y);
    }

}
