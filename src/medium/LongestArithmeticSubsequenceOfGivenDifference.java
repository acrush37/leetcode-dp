package medium;

/*
    Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which
    is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String... args) {

        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 3, 5, 7};
        int[] arr3 = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        LongestArithmeticSubsequenceOfGivenDifference longestArithmeticSubsequenceOfGivenDifference = new LongestArithmeticSubsequenceOfGivenDifference();
        System.out.println(longestArithmeticSubsequenceOfGivenDifference.longestSubsequence(arr1, 1));
        System.out.println(longestArithmeticSubsequenceOfGivenDifference.longestSubsequence(arr2, 1));
        System.out.println(longestArithmeticSubsequenceOfGivenDifference.longestSubsequence(arr3, -2));
    }

    public int longestSubsequence(int[] arr, int difference) {

        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {

            int count = 1 + map.getOrDefault(a-difference, 0);
            max = Math.max(max, count);
            map.put(a, count);
        }

        return max;
    }

}
