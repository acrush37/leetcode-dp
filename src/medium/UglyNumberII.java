package medium;

/*
    Write a program to find the n-th ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */

public class UglyNumberII {

    public static void main(String... args) {

        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {

        int x = 0, y = 0, z = 0;
        int[] f = new int[n];
        f[0] = 1;

        for (int i = 1; i < n; i++) {

            f[i] = Math.min(Math.min(f[x] * 2, f[y] * 3), f[z] * 5);
            if (f[i] == f[x] * 2) x++;
            if (f[i] == f[y] * 3) y++;
            if (f[i] == f[z] * 5) z++;
        }

        return f[n-1];
    }

}
