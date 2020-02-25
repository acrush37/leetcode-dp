package hard;

/*
    Given two integers n and k, find how many different arrays consist
    of numbers from 1 to n such that there are exactly k inverse pairs.

    We define an inverse pair as following: For ith and jth element in the array,
    if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.

    Since the answer may be very large, the answer should be modulo 109 + 7.
 */
public class KInversePairsArray {

    public static void main(String... args) {

        KInversePairsArray kInversePairsArray = new KInversePairsArray();
        System.out.println(kInversePairsArray.kInversePairs(3, 1));
    }

    public int kInversePairs(int n, int k) {

        int p = 0, m = 1000000007;
        int[][] f = new int[2][k+1];

        for (int i = 1; i <= n; i++) {

            f[p = i & 1][0] = 1;
            int q = p ^ 1, r = Math.min(k, (i * (i-1)) >> 1);

            for (int j = 1; j <= r; j++)
                f[p][j] = ((f[p][j-1] + f[q][j]) % m + m - (i <= j ? f[q][j-i] : 0)) % m;
        }

        return f[p][k];
    }

}
