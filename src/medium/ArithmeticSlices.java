package medium;

/*
    A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

    A slice (P, Q) of array A is called arithmetic if the sequence:
    A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

    The function should return the number of arithmetic slices in the array A.
 */

public class ArithmeticSlices {

    public static void main(String... args) {

        int[] A = {1, 2, 3, 4};
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(A));
    }

    public int numberOfArithmeticSlices(int[] A) {

        int n = A.length;
        if (n < 3) return 0;
        boolean[][] f = new boolean[n+1][n+1];
        int s = 0;

        for (int i = 3; i <= n; i++)
            if (A[i-2] << 1 == A[i-3] + A[i-1]) {

                f[i][3] = true;
                s++;
            }

        for (int i = 4; i <= n; i++)
            for (int j = i; j <= n; j++)
                if (f[j-1][i-1] && A[j-2] << 1 == A[j-3] + A[j-1]) {

                    f[j][i] = true;
                    s++;
                }

        return s;
    }

}
