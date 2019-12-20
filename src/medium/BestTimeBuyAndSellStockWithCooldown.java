package medium;

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
public class BestTimeBuyAndSellStockWithCooldown {

    public static void main(String... args) {

        int[] prices = {1, 2, 3, 0, 2};
        BestTimeBuyAndSellStockWithCooldown bestTimeBuyAndSellStockWithCooldown = new BestTimeBuyAndSellStockWithCooldown();
        System.out.println(bestTimeBuyAndSellStockWithCooldown.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n <= 1) return 0;
        int[] f = new int[n];
        int min = Math.min(prices[0], prices[1]);
        f[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < n; i++) {
            min = Math.min(min, prices[i] - f[i-2]);
            f[i] = Math.max(f[i-1], prices[i] - min);
        }

        return f[n-1];
    }

}
