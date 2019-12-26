package medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Given an array arr of positive integers, consider all binary trees such that:

    Each node has either 0 or 2 children;
    The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
    The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.

    Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.
 */
public class MinimumCostTreeFromLeafValues {

    public static void main(String... args) {

        int[] arr = {6, 2, 4};
        MinimumCostTreeFromLeafValues minimumCostTreeFromLeafValues = new MinimumCostTreeFromLeafValues();
        System.out.println(minimumCostTreeFromLeafValues.mctFromLeafValues(arr));
    }

    public int mctFromLeafValues(int[] arr) {

        int result = 0;
        List<Integer> t = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while (t.size() >= 2) {

            int n = 0, min = Integer.MAX_VALUE;

            for (int i = 1; i < t.size(); i++) {

                int j = Math.max(t.get(i-1), t.get(i));

                if (j < min) {
                    min = j;
                    n = i;
                }
            }

            result += t.get(n-1) * t.get(n);
            int max = Math.max(t.get(n-1), t.get(n));
            t.remove(n-1);
            t.remove(n-1);
            t.add(n-1, max);
        }

        return result;
    }

}
