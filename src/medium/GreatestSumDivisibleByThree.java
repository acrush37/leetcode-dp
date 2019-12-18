package medium;

/*
    Given an array nums of integers, we need to find the maximum possible
    sum of elements of the array such that it is divisible by three.
 */
public class GreatestSumDivisibleByThree {

    public static void main(String... args) {

        int[] nums = {3, 6, 5, 1, 8};
        GreatestSumDivisibleByThree greatestSumDivisibleByThree = new GreatestSumDivisibleByThree();
        System.out.println(greatestSumDivisibleByThree.maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {

        int[] f = new int[3];
        int[] t = new int[3];

        for (int n : nums) {

            t[0] = f[0];
            t[1] = f[1];
            t[2] = f[2];
            int p = n % 3;

            if (p == 0) {

                f[0] += n;
                if (t[1] != 0) f[1] += n;
                if (t[2] != 0) f[2] += n;
            } else if (p == 1) {

                if (t[0] != 0) f[1] = Math.max(t[1], t[0] + n);
                if (t[2] != 0) f[0] = Math.max(t[0], t[2] + n);

                if (t[1] == 0) f[1] = Math.max(n, t[0] + n);
                else f[2] = Math.max(t[2], t[1] + n);

            } else {

                if (t[0] != 0) f[2] = Math.max(t[2], t[0] + n);
                if (t[1] != 0) f[0] = Math.max(t[0], t[1] + n);

                if (t[2] == 0) f[2] = Math.max(n, t[0] + n);
                else f[1] = Math.max(t[1], t[2] + n);
            }
        }

        return f[0];
    }

}
