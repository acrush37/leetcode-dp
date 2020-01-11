package hard;

import java.util.*;

/*
    You are given an integer array A.  From some starting index, you can make a series of jumps.
    You may from index i jump forward to index j (with i < j) in the following way:

    During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is
    the smallest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
    During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is
    the largest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.

    A starting index is good if, starting from that index, you can reach the end of the array
    (index A.length - 1) by jumping some number of times (possibly 0 or more than once.)

    Return the number of good starting indexes.
 */
public class OddEvenJump {

    private Boolean[][] f;

    public static void main(String... args) {

        int[] A = {2, 3, 1, 1, 4};
        OddEvenJump oddEvenJump = new OddEvenJump();
        System.out.println(oddEvenJump.oddEvenJumps(A));
    }

    private boolean dfs(int k, int p, int n, int[][] t) {

        if (f[p][k] != null) return f[p][k];
        if (t[p][k] == 0) return false;
        if (t[p][k] == n-1) return true;
        return f[p][k] = dfs(k^1, t[p][k], n, t);
    }

    private int[] find(int n, int k, int[] A, int[] b, List<Integer>[] a) {

        int left = 0, right = n, p = 0, x = 0, y = 0;

        while (left <= right) {

            int mid = (left + right) >> 1;

            if (b[mid] == A[k]) {
                p = mid;
                break;
            }

            if (b[mid] > A[k]) right = mid - 1;
            else left = mid + 1;
        }

        for (int i = p; i >= 0; i--) {

            boolean flag = false;

            for (int j : a[b[i]])
                if (j > k) {
                    flag = true;
                    x = j;
                    break;
                }

            if (flag) break;
        }

        for (int i = p; i <= n; i++) {

            boolean flag = false;

            for (int j : a[b[i]])
                if (j > k) {
                    flag = true;
                    y = j;
                    break;
                }

            if (flag) break;
        }

        return new int[]{x, y};
    }

    public int oddEvenJumps(int[] A) {

        int n = A.length;
        if (n == 1) return 1;
        f = new Boolean[n][2];
        int[][] t = new int[n][2];
        Set<Integer> s = new TreeSet<>();
        List<Integer>[] a = new List[100001];

        for (int i = 0; i < n; i++) {
            if (a[A[i]] == null) a[A[i]] = new ArrayList<>();
            a[A[i]].add(i);
            s.add(A[i]);
        }

        int m = s.size(), k = 0, result = 1;
        int[] b = new int[m];
        for (int x : s) b[k++] = x;
        for (int i = 0; i < n-1; i++) t[i] = find(m-1, i, A, b, a);

        for (int i = 0; i < n-1; i++)
            if (f[i][1] == Boolean.TRUE || f[i][1] == null && dfs(1, i, n, t))
                result++;

        return result;
    }

}
