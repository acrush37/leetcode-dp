package medium;

import java.util.Arrays;

/*
    Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.

    The result of this smash is:
    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.

    At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone
 */
public class LastStoneWeightII {

    public static void main(String... args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        System.out.println(lastStoneWeightII.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {

        int n = stones.length, s = Arrays.stream(stones).sum();
        boolean[][] f = new boolean[n][s+1];
        f[0][stones[0]] = true;

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= s; j++)
                if (f[i-1][j])
                    f[i][j+stones[i]] = f[i][Math.abs(j-stones[i])] = true;

        for (int i = 0; i <= s; i++) if (f[n-1][i]) return i;
        return 0;
    }

}
