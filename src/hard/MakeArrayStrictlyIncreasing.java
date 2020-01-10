package hard;

import java.util.*;

/*
    Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

    In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].

    If there is no way to make arr1 strictly increasing, return -1.
 */
public class MakeArrayStrictlyIncreasing {

    private Map<Integer, Integer>[] f;

    public static void main(String... args) {

        int[] arr1 = {0, 11, 6, 1, 4, 3};
        int[] arr2 = {5, 4, 11, 10, 1, 0};
        MakeArrayStrictlyIncreasing makeArrayStrictlyIncreasing = new MakeArrayStrictlyIncreasing();
        System.out.println(makeArrayStrictlyIncreasing.makeArrayIncreasing(arr1, arr2));
    }

    private int find(int x, int n, int[] a) {

        if (a[n] <= x) return -1;
        int left = 0, right = n;

        while (left <= right) {

            if (left == right) return a[left] > x ? a[left] : -1;
            int mid = (left + right) >> 1;

            if (a[mid] <= x) left = mid + 1;
            else right = mid;
        }

        return -1;
    }

    private int dfs(int p, int k, int m, int n, int[] arr1, int[] arr2) {

        if (k == m) return arr1[k] > p ? 0 : arr2[n] > p ? 1 : -1;
        if (f[k].containsKey(p)) return f[k].get(p);
        int min = -1;
        if (arr1[k] > p) min = dfs(arr1[k], k+1, m, n, arr1, arr2);
        int x = find(p, n, arr2);

        if (x != -1) {
            int min1 = dfs(x, k+1, m, n, arr1, arr2);
            if (min1 != -1) min = min == -1 ? 1 + min1 : Math.min(min, 1 + min1);
        }

        f[k].put(p, min);
        return min;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {

        Arrays.sort(arr2);
        f = new Map[arr1.length];
        for (int i = 0; i < arr1.length; i++) f[i] = new HashMap<>();
        return dfs(-1,0, arr1.length-1, arr2.length-1, arr1, arr2);
    }

}
