package easy;

/*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */

public class RangeSumQueryImmutable {

    public static void main(String... args) {

        int[] nums1 = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums1);
        System.out.println(rangeSumQueryImmutable.sumRange(0, 2));
        System.out.println(rangeSumQueryImmutable.sumRange(2, 5));
        System.out.println(rangeSumQueryImmutable.sumRange(0, 5));
    }

    public RangeSumQueryImmutable(int[] nums) {

    }

    public int sumRange(int i, int j) {
        return 0;
    }

}
