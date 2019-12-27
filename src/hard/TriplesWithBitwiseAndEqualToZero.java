package hard;

import java.util.*;

import static java.util.Map.Entry;

/*
    Given an array of integers A, find the number of triples of indices (i, j, k) such that:
    0 <= i < A.length, 0 <= j < A.length, 0 <= k < A.length
    A[i] & A[j] & A[k] == 0, where & represents the bitwise-AND operator.
 */
public class TriplesWithBitwiseAndEqualToZero {

    public static void main(String... args) {

        int[] A = {2, 1, 3, 1, 1, 2, 6};
        TriplesWithBitwiseAndEqualToZero triplesWithBitwiseAndEqualToZero = new TriplesWithBitwiseAndEqualToZero();
        System.out.println(triplesWithBitwiseAndEqualToZero.countTriplets(A));
    }

    public int countTriplets(int[] A) {

        int result = 0, n = A.length;
        Map<Integer, List<Integer>> f = new HashMap<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((A[i] & A[i] & A[j]) == 0)
                    result += i == j ? 1 : 3;

        for (int i = 0; i < n-2; i++)
            for (int j = i+1; j < n-1; j++) {

                int k = A[i] & A[j];

                if (k == 0) {
                    result += (n - j - 1) * 6;
                    continue;
                }

                List<Integer> t = f.get(k);
                if (t == null) t = new ArrayList<>();
                t.add(j+1);
                f.put(k, t);
            }

        Set<Entry<Integer, List<Integer>>> set = f.entrySet();

        for (Entry<Integer, List<Integer>> entry : set) {

            int x = entry.getKey();
            List<Integer> y = entry.getValue();

            for (int z : y)
                for (int i = z; i < n; i++)
                    if ((x & A[i]) == 0)
                        result += 6;
        }

        return result;
    }

}
