package hard;

/*
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
    You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
    coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

    Find the maximum coins you can collect by bursting the balloons wisely.
 */
public class BurstBalloons {

    public static void main(String... args) {

        int[] nums = {3, 1, 5, 8};
        BurstBalloons burstBalloons = new BurstBalloons();
        System.out.println(burstBalloons.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] a = new int[n+=2];
        a[0] = a[n-1] = 1;
        for (int i = 1; i < n-1; i++) a[i] = nums[i-1];
        int[][] f = new int[n-1][n];

        for (int p = 2; p < n; p++)
            for (int i = 0; i < n-p; i++) {
                int j = i + p;
                for (int k = i+1; k < j; k++) f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + a[i] * a[k] * a[j]);
            }

        return f[0][n-1];
    }

}
