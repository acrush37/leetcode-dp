package hard;

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class BestTimeBuyAndSellStockIII {

    public static void main(String... args) {

        int[] prices = {3, 2, 6, 5, 0, 3};
        BestTimeBuyAndSellStockIII bestTimeBuyAndSellStockIII = new BestTimeBuyAndSellStockIII();
        System.out.println(bestTimeBuyAndSellStockIII.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n <= 1) return 0;
        int result = 0, min = prices[0], max = prices[n-1];
        int[] f = new int[n];

        for (int i = 1; i < n; i++) {

            f[i] = Math.max(0, prices[i] - min);
            min = Math.min(min, prices[i]);
            result = Math.max(result, f[i] = Math.max(f[i], f[i-1]));
        }

        for (int i = n-2; i >= 2; i--) {
            result = Math.max(result, max - prices[i] + f[i-1]);
            max = Math.max(max, prices[i]);
        }

        return result;
    }

}
