package medium;

/*
    We have two integer sequences A and B of the same non-zero length.

    We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.

    At the end of some number of swaps, A and B are both strictly increasing.
    (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)

    Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 */

public class MinimumSwapsToMakeSequencesIncreasing {

    public static void main(String... args) {

        int[] A = {0, 2, 5, 8, 9, 10, 12, 14, 18, 19, 20, 20, 24, 27, 28, 31, 33, 34, 36, 38};
        int[] B = {1, 2, 5, 7, 8, 9,  11, 17, 15, 16, 19, 21, 28, 29, 30, 31, 33, 34, 38, 39};
        MinimumSwapsToMakeSequencesIncreasing minimumSwapsToMakeSequencesIncreasing = new MinimumSwapsToMakeSequencesIncreasing();
        System.out.println(minimumSwapsToMakeSequencesIncreasing.minSwap(A, B));
    }

    public int minSwap(int[] A, int[] B) {

        int n = A.length;
        if (n == 1) return 0;
        if (n == 2) return A[0] < A[1] && B[0] < B[1] ? 0 : 1;
        int[] f = new int[n+1];
        int[] g = new int[n+1];

        if (A[0] != B[0]) f[1] = 1;

        for (int i = 2; i <= n; i++)
            if (A[i-2] >= A[i-1] || B[i-2] >= B[i-1]) {

                g[i] = f[i-1];
                f[i] = g[i-1] + 1;
            } else {

                g[i] = g[i-1];
                f[i] = f[i-1] + 1;

                if (A[i-2] < B[i-1] && B[i-2] < A[i-1]) {

                    g[i] = Math.min(g[i], f[i-1]);
                    f[i] = Math.min(f[i], g[i-1] + 1);
                }
            }

        return Math.min(f[n], g[n]);
    }
}
