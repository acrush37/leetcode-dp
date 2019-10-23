package medium;

/*
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.
 */

public class CoinChange {

    public static void main(String... args) {

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) return 0;
        int[] f = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {

            f[i] = Integer.MAX_VALUE;

            for (int coin : coins)
                if (coin > i) continue;
                else if (f[i-coin] != Integer.MAX_VALUE) f[i] = Math.min(f[i], f[i-coin] + 1);
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

}
