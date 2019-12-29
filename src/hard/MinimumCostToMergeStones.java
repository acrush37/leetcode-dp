package hard;

/*
    There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.

    A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.

    Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.
 */
public class MinimumCostToMergeStones {

    public static void main(String... args) {

        int[] stones = {29,59,31,7,51,99,47,40,24,20,98,41,42,81,92,55};
        MinimumCostToMergeStones minimumCostToMergeStones = new MinimumCostToMergeStones();
        System.out.println(minimumCostToMergeStones.mergeStones(stones, 2));
    }

    public int mergeStones(int[] stones, int K) {

        int n = stones.length;
        if ((n-1) % (K-1) != 0) return -1;
        int[][] f = new int[n][n];
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) s[i+1] = s[i] + stones[i];

        for (int p = K; p <= n; p++)
            for (int i = 0; i <= n-p; i++) {

                int j = i+p-1;
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k += K-1) f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j]);
                if ((j-i) % (K-1) == 0) f[i][j] += s[j+1] - s[i];
            }

        return f[0][n-1];
    }

}
