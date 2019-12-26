package medium;

import java.util.Arrays;

/*
    Given an array of scores that are non-negative integers. Player 1 picks one of the
    numbers from either end of the array followed by the player 2 and then player 1 and so on.

    Each time a player picks a number, that number will not be available for the next player.
    This continues until all the scores have been chosen. The player with the maximum score wins.

    Given an array of scores, predict whether player 1 is the winner.
    You can assume each player plays to maximize his score.
 */
public class PredictTheWinner {

    public static void main(String... args) {

        int[] nums = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        System.out.println(predictTheWinner.PredictTheWinner(nums));
    }

    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        if (n <= 2) return true;
        if (n == 3) return nums[1] <= nums[0] + nums[2];
        int[][] f = new int[n+1][n+1];
        int s = Arrays.stream(nums).sum();
        for (int i = 1; i < n; i++) f[i][i+1] = Math.max(nums[i-1], nums[i]);
        for (int i = 1; i < n-1; i++) f[i][i+2] = nums[i-1] + nums[i+1];

        for (int i = 3; i < n; i++)
            for (int j = 1; j <= n-i; j++)
                f[j][i+j] = Math.max(nums[j-1] + Math.min(f[j+1][i+j-1], f[j+2][i+j]), nums[i+j-1] + Math.min(f[j+1][i+j-1], f[j][i+j-2]));

        return f[1][n] << 1 >= s;
    }

}
