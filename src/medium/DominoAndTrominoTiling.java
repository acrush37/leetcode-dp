package medium;

/*
    We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

    Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
 */
public class DominoAndTrominoTiling {

    public static void main(String... args) {

        DominoAndTrominoTiling dominoAndTrominoTiling = new DominoAndTrominoTiling();
        System.out.println(dominoAndTrominoTiling.numTilings(3));
    }

    public int numTilings(int N) {

        if (N <= 2) return N;
        int[] f = new int[N+1];
        int p = 1000000007;
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= N; i++) f[i] = ((f[i-1] << 1) % p + f[i-3]) % p;
        return f[N] % p;
    }

}
