package medium;

/*
    Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
    calculate the number of 1's in their binary representation and return them as an array.
 */

public class CountingBits {

    public static void main(String... args) {

        CountingBits countingBits = new CountingBits();
        System.out.println(countingBits.countBits(2));
        System.out.println(countingBits.countBits(5));
    }

    public int[] countBits(int num) {

        int[] f = new int[num+1];

        for (int i = 1; i <= num; i++) {

            int x = i;
            int s = 0;

            while (x != 0) {

                s += (x & 1);
                x >>= 1;
            }

            f[i] = s;
        }

        return f;
    }

}
