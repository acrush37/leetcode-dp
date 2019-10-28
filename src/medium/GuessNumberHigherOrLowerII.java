package medium;

/*
    We are playing the Guess Game. The game is as follows:

    I pick a number from 1 to n. You have to guess which number I picked.

    Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

    However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 */

public class GuessNumberHigherOrLowerII {

    public static void main(String... args) {

        GuessNumberHigherOrLowerII guessNumberHigherOrLowerII = new GuessNumberHigherOrLowerII();
        System.out.println(guessNumberHigherOrLowerII.getMoneyAmount(10));
    }

    public int getMoneyAmount(int n) {

        if (n <= 2) return n-1;
        int[][] f = new int[n+1][n+1];

        for (int i = 1; i < n; i++)
            for (int j = 1; j <= n-i; j++) {

                f[j][i+j] = Math.min(j + f[j+1][i+j], i + j + f[j][i+j-1]);

                for (int k = j+1; k < i+j; k++)
                    f[j][i+j] = Math.min(f[j][i+j], k + Math.max(f[j][k-1], f[k+1][i+j]));
            }

        return f[1][n];
    }

}
