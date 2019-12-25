package medium;

/*
    A die simulator generates a random number from 1 to 6 for each roll. You introduced a constraint
    to the generator such that it cannot roll the number i more than rollMax[i] (1-indexed) consecutive times.

    Given an array of integers rollMax and an integer n, return the number
    of distinct sequences that can be obtained with exact n rolls.

    Two sequences are considered different if at least one element differs from each other.
    Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class DiceRollSimulation {

    public static void main(String... args) {

        int[] rollMax = {1, 1, 1, 2, 2, 3};
        DiceRollSimulation diceRollSimulation = new DiceRollSimulation();
        System.out.println(diceRollSimulation.dieSimulator(3, rollMax));
    }

    public int dieSimulator(int n, int[] rollMax) {

        int[][] f = new int[n][6];
        int result = 0, mod = 1000000007;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < 6; j++)
                for (int k = 1; k <= rollMax[j]; k++)
                    if (k > i) {
                        f[i][j] += 1;
                        break;
                    } else for (int p = 0; p < 6; p++)
                        if (p != j) f[i][j] = (f[i][j] + f[i-k][p]) % mod;

        for (int i = 0; i < 6; i++) result = (result + f[n-1][i]) % mod;
        return result % mod;
    }

}
