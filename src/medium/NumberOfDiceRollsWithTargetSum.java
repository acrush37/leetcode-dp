package medium;

/*
    You have d dice, and each die has f faces numbered 1, 2, ..., f.

    Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 */

public class NumberOfDiceRollsWithTargetSum {

    public static void main(String... args) {

        NumberOfDiceRollsWithTargetSum numberOfDiceRollsWithTargetSum = new NumberOfDiceRollsWithTargetSum();
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(1, 6, 3));
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(2, 6, 7));
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(2, 5, 10));
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(1, 2, 3));
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int d, int f, int target) {

        int[][] t = new int[d+1][target+1];
        t[0][0] = 1;

        for (int i = 1; i <= d; i++)
            for (int j = 1; j <= target; j++)
                for (int k = 1; k <= f; k++)
                    if (k > j) break;
                    else t[i][j] = (t[i][j] + t[i-1][j-k]) % 1000000007;

        return t[d][target];
    }

}
