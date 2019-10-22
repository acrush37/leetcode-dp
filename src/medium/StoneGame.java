package medium;

/*
    Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

    The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

    Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
    This continues until there are no more piles left, at which point the person with the most stones wins.

    Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */

public class StoneGame {

    public static void main(String... args) {

        int[] piles = {5, 3, 4, 5};
        StoneGame stoneGame = new StoneGame();
        System.out.println(stoneGame.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        if (n == 2) return true;
        int s = 0;
        int[][] f = new int[n+1][n+1];
        for (int p : piles) s += p;
        for (int i = 1; i < n; i++) f[i][i+1] = Math.max(piles[i-1], piles[i]);
        for (int i = 3; i < n; i = i+2)
            for (int j = 1; j <= n-i; j++)
                f[j][i+j] = Math.max(Math.min(f[j+1][i+j-1], f[j][i+j-2]) + piles[i+j-1],
                        Math.min(f[j+2][i+j], f[j+1][i+j-1]) + piles[j-1]);

        return f[1][n] << 1 > s;
    }

}
