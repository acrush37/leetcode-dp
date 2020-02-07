package hard;

/*
    Say you have an array for which the i-th element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most k transactions.
 */
public class BestTimeBuyAndSellStockIV {

    public static void main(String... args) {

        int[] prices = {3, 2, 6, 5, 0, 3};
        BestTimeBuyAndSellStockIV bestTimeBuyAndSellStockIV = new BestTimeBuyAndSellStockIV();
        System.out.println(bestTimeBuyAndSellStockIV.maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (k >= n >> 1) {

            int s = 0;
            for (int i = 1; i < n; i++) s += Math.max(0, prices[i] - prices[i-1]);
            return s;
        }

        int p = 0;
        int[][] f = new int[2][n];

        for (int i = 0; i < k; i++) {

            int q = (p = i & 1) ^ 1, max = Integer.MIN_VALUE;

            for (int j = 1; j < n; j++) {
                max = Math.max(max, f[q][j-1] - prices[j-1]);
                f[p][j] = Math.max(f[p][j-1], max + prices[j]);
            }
        }

        return f[p][n-1];
    }

}
