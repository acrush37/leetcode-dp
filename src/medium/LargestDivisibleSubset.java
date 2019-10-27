package medium;

/*
    Given a set of distinct positive integers, find the largest subset such that
    every pair (Si, Sj) of elements in this subset satisfies:

    Si % Sj = 0 or Sj % Si = 0.

    If there are multiple solutions, return any subset is fine.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String... args) {

        int[] nums1 = {2, 3, 8, 9, 27};
        int[] nums2 = {1, 2, 4, 8};
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums1));
        System.out.println(largestDivisibleSubset.largestDivisibleSubset(nums2));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Arrays.asList(nums[0]);
        Arrays.sort(nums);
        int[] f = new int[n+1];
        int[] p = new int[n+1];
        f[1] = 1;
        int k = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {

            f[i] = 1;

            for (int j = 1; j < i; j++)
                if (nums[i-1] % nums[j-1] == 0 && f[j] >= f[i]) {

                    p[i] = j;
                    f[i] = f[j] + 1;
                }

            if (f[i] > max) {
                max = f[i];
                k = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[k-1]);

        while ((k = p[k]) != 0) {
            list.add(0, nums[k-1]);
        }

        return list;
    }

}
