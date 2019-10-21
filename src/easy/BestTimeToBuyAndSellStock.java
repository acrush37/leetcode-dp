package easy;

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

    Note that you cannot sell a stock before you buy one.
 */

public class BestTimeToBuyAndSellStock {

    public static void main(String... args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices1));
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {

        int max = 0;
        int n = prices.length;
        int[] f = new int[n+1];

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j < i; j++) f[i] = Math.max(f[i], prices[i-1] - prices[j-1]);
            max = Math.max(max, f[i]);
        }

        return max;
    }

}
