package medium;

/*
    Given a positive integer n, break it into the sum of at least two positive integers
    and maximize the product of those integers. Return the maximum product you can get.
 */

public class IntegerBreak {

    public static void main(String... args) {

        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(10));
    }

    public int integerBreak(int n) {

        int[] f = new int[n+1];
        f[1] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                f[i] = Math.max(f[i], Math.max(j * (i-j), f[j] * (i-j)));

        return f[n];
    }

}
