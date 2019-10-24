package medium;

/*
    Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

    Note that every number in the answer must not have leading zeros except for the number 0 itself.

    For example, 01 has one leading zero and is invalid, but 0 is valid.

    You may return the answer in any order.
 */

import java.util.HashSet;
import java.util.Set;

public class NumbersWithSameConsecutiveDifferences {

    public static void main(String... args) {

        NumbersWithSameConsecutiveDifferences numbersWithSameConsecutiveDifferences = new NumbersWithSameConsecutiveDifferences();
        System.out.println(numbersWithSameConsecutiveDifferences.numsSameConsecDiff(3, 7));
        System.out.println(numbersWithSameConsecutiveDifferences.numsSameConsecDiff(2, 1));
    }

    private void find(int p, int n, int k, int[] a, Set<Integer> set) {

        if (p == n) {

            String s = "";
            for (int x : a) s += x;
            set.add(Integer.parseInt(s));
            return;
        }

        if (p == 0)
            for (int i = 1; i <= 9; i++) {
                a[p] = i;
                find(p+1, n, k, a, set);
                a[p] = -1;
            }
        else {
            int x = a[p-1] + k;
            int y = a[p-1] - k;

            if (x >= 0 && x <= 9) {
                a[p] = x;
                find(p+1, n, k, a, set);
                a[p] = -1;
            }

            if (y >= 0 && y <= 9) {
                a[p] = y;
                find(p+1, n, k, a, set);
                a[p] = -1;
            }
        }
    }

    public int[] numsSameConsecDiff(int N, int K) {

        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = -1;
        Set<Integer> set = new HashSet<>();
        find(0, N, K, a, set);
        return set.stream().mapToInt(i -> i).toArray();
    }

}
