package medium;

/*
    Given a triangle, find the minimum path sum from top to bottom.
    Each step you may move to adjacent numbers on the row below.
 */

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String... args) {

        Triangle triangle = new Triangle();
        List<Integer> t1 = Arrays.asList(2);
        List<Integer> t2 = Arrays.asList(3, 4);
        List<Integer> t3 = Arrays.asList(6, 5, 7);
        List<Integer> t4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> t = Arrays.asList(t1, t2, t3, t4);
        System.out.println(triangle.minimumTotal(t));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] f = triangle.get(n-1).stream().mapToInt(i -> i).toArray();

        for (int i = n-2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                f[j] = Math.min(f[j], f[j+1]) + triangle.get(i).get(j);

        return f[0];
    }

}
