package medium;

/*
    We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group.

    What is the largest score we can achieve?

    Note that our partition must use every number in A, and that scores are not necessarily integers.
 */

public class LargestSumOfAverages {

    public static void main(String... args) {

        int[] A = {1, 2, 3, 4, 5, 6, 7};
        LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        System.out.println(largestSumOfAverages.largestSumOfAverages(A,  4));
    }

    public double largestSumOfAverages(int[] A, int K) {

        int n = A.length;
        if (n == 1) return A[0];
        double[][] f = new double[n+1][K+1];
        double[] s = new double[n+1];
        f[1][1] = A[0];

        for (int i = 1; i <= n; i++) {

            s[i] += s[i-1] + A[i-1];
            f[i][1] = s[i] / i;
        }

        for (int k = 2; k <= K; k++)
            for (int i = k; i <= n; i++)
                for (int j = k - 1; j < i; j++)
                    f[i][k] = Math.max(f[i][k], f[j][k - 1] + (s[i] - s[j]) / (i - j));


        return f[n][K];
    }

}
