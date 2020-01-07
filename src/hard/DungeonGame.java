package hard;

import java.util.Arrays;

/*
    The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
    The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially
    positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

    The knight has an initial health point represented by a positive integer.
    If at any point his health point drops to 0 or below, he dies immediately.

    In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
    Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 */
public class DungeonGame {

    public static void main(String... args) {

        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        DungeonGame dungeonGame = new DungeonGame();
        System.out.println(dungeonGame.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length, n = dungeon[0].length;
        int[][] f = new int[m][n];

        for (int i = m-1; i >= 0; i--)
            for (int j = n-1; j >= 0; j--)
                if (i == m-1 && j == n-1) f[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == m-1) f[i][j] = Math.max(1, f[i][j+1] - dungeon[i][j]);
                else if (j == n-1) f[i][j] = Math.max(1, f[i+1][j] - dungeon[i][j]);
                else f[i][j] = Math.max(1, Math.min(f[i+1][j], f[i][j+1]) - dungeon[i][j]);

        return f[0][0];
    }

}
