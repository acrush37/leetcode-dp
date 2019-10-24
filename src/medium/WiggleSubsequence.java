package medium;

/*
    A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
    The first difference (if one exists) may be either positive or negative.
    A sequence with fewer than two elements is trivially a wiggle sequence.

    For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
    In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

    Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
    A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 */

public class WiggleSubsequence {

    public static void main(String... args) {

        int[] num1 = {1, 7, 4, 9, 2, 5};
        int[] num2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] num3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        System.out.println(wiggleSubsequence.wiggleMaxLength(num1));
        System.out.println(wiggleSubsequence.wiggleMaxLength(num2));
        System.out.println(wiggleSubsequence.wiggleMaxLength(num3));
    }

    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;
        if (n < 2) return n;
        int[] f = new int[n+1];
        int[] p = new int[n+1];
        int max = 1;

        for (int i = 2; i <= n; i++)
            if (nums[i-1] == nums[i-2]) {
                f[i] = 1;
                p[i] = i;
            } else {
                f[i] = 2;
                p[i] = i-1;
            }

        for (int i = 3; i <= n; i++)
            for (int j = 2; j < i; j++)
                if (f[j] >= f[i] && nums[i-1] != nums[j-1])
                    if (nums[i-1] > nums[j-1] && nums[j-1] < nums[p[j]-1]
                        || nums[i-1] < nums[j-1] && nums[j-1] > nums[p[j]-1]) {

                        p[i] = j;
                        f[i] = f[j] + 1;
                    }

        for (int i = 3; i <= n; i++) max = Math.max(max, f[i]);

        return max;
    }

}
