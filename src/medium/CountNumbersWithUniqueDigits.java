package medium;

/*
    Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 */

public class CountNumbersWithUniqueDigits {

    public static void main(String... args) {

        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(10));
    }

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) return 1;
        int[] f = new int[11];
        int[] a = {0, 10, 9*9, 9*9*8, 9*9*8*7, 9*9*8*7*6, 9*9*8*7*6*5, 9*9*8*7*6*5*4, 9*9*8*7*6*5*4*3, 9*9*8*7*6*5*4*3*2, 9*9*8*7*6*5*4*3*2*1};
        for (int i = 1; i <= 10; i++) f[i] = f[i-1] + a[i];
        return f[Math.min(10, n)];
    }

}
