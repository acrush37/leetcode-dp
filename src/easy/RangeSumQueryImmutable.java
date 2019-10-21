package easy;

/*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */

public class RangeSumQueryImmutable {

    private int[] f;

    public static void main(String... args) {

        int[] nums1 = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums1);
        System.out.println(rangeSumQueryImmutable.sumRange(0, 2));
        System.out.println(rangeSumQueryImmutable.sumRange(2, 5));
        System.out.println(rangeSumQueryImmutable.sumRange(0, 5));
    }

    public RangeSumQueryImmutable(int[] nums) {

        int n = nums.length;
        if (n == 0) return;
        f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) f[i] = f[i-1] + nums[i];
    }

    public int sumRange(int i, int j) {
        return i == 0 ? f[j] : f[j] - f[i-1];
    }

}
