package medium;

import java.util.HashSet;
import java.util.Set;

/*
    We have an array A of non-negative integers.

    For every (contiguous) subarray B = [A[i], A[i+1], ..., A[j]] (with i <= j), we take the
    bitwise OR of all the elements in B, obtaining a result A[i] | A[i+1] | ... | A[j].

    Return the number of possible results.
    (Results that occur more than once are only counted once in the final answer.)
 */
public class BitwiseOrsOfSubarrays {

    public static void main(String... args) {

        int[] A = {1, 2, 4};
        BitwiseOrsOfSubarrays bitwiseOrsOfSubarrays = new BitwiseOrsOfSubarrays();
        System.out.println(bitwiseOrsOfSubarrays.subarrayBitwiseORs(A));
    }

    public int subarrayBitwiseORs(int[] A) {

        Set<Integer> t = new HashSet<>(), a = new HashSet<>();

        for (int x : A) {

            Set<Integer> b = new HashSet<>();
            for (int y : a) b.add(x | y);
            b.add(x);
            t.addAll(a = b);
        }

        return t.size();
    }

}
