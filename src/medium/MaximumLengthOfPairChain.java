package medium;

import java.util.Arrays;

/*
    You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

    Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c.
    Chain of pairs can be formed in this fashion.

    Given a set of pairs, find the length longest chain which can be formed.
    You needn't use up all the given pairs. You can select pairs in any order.
 */
public class MaximumLengthOfPairChain {

    public static void main(String... args) {

        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        MaximumLengthOfPairChain maximumLengthOfPairChain = new MaximumLengthOfPairChain();
        System.out.println(maximumLengthOfPairChain.findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {

        int result = 1, n = pairs.length;
        int[] f = new int[n];
        f[0] = 1;
        Arrays.sort(pairs, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        for (int i = 1; i < n; i++) {

            f[i] = 1;

            for (int j = 0; j < i; j++)
                if (pairs[i][0] > pairs[j][1])
                    f[i] = Math.max(f[i], f[j] + 1);

            result = Math.max(result, f[i]);
        }

        return result;
    }

}
