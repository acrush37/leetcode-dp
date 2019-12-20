package medium;

/*
    Your are given an array of integers prices, for which the i-th element is the price
    of a given stock on day i; and a non-negative integer fee representing a transaction fee.

    You may complete as many transactions as you like, but you need to pay the transaction
    fee for each transaction. You may not buy more than 1 share of a stock at a time
    (ie. you must sell the stock share before you buy again.)

    Return the maximum profit you can make.
 */
public class BestTimeBuyAndSellStockWithTransactionFee {

    public static void main(String... args) {

        int[] prices = {1, 3, 2, 8, 4, 9};
        BestTimeBuyAndSellStockWithTransactionFee bestTimeBuyAndSellStockWithTransactionFee = new BestTimeBuyAndSellStockWithTransactionFee();
        System.out.println(bestTimeBuyAndSellStockWithTransactionFee.maxProfit(prices, 2));
    }

    public int maxProfit(int[] prices, int fee) {

        int result = 0, max = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, max + prices[i] - fee);
            max = Math.max(max, result - prices[i]);
        }

        return result;
    }

}
