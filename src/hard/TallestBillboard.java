package hard;

import java.util.*;

/*
    You are installing a billboard and want it to have the largest height.
    The billboard will have two steel supports, one on each side.
    Each steel support must be an equal height.

    You have a collection of rods which can be welded together.
    For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.

    Return the largest possible height of your billboard installation.
    If you cannot support the billboard, return 0.
 */
public class TallestBillboard {

    private int result = -1;

    private int[] t;

    private List<Integer>[] f;

    public static void main(String... args) {

        int[] rods = {100, 100};
        TallestBillboard tallestBillboard = new TallestBillboard();
        System.out.println(tallestBillboard.tallestBillboard(rods));
    }

    private void dfs(int p, int n, int s, int x, int half, int[] r) {

        if (s > result) {

            if (f[s] == null) f[s] = new ArrayList<>();

            for (int y : f[s])
                if ((x & y) == 0) {
                    result = s;
                    break;
                }

            if (s != result) f[s].add(x);
        } else if (p != n && s + t[p] <= result) return;

        for (int i = p; i < n; i++) {

            int y = s + r[i];
            if (y > half) break;
            dfs(i+1, n, y, x + (1 << i), half, r);
        }
    }

    public int tallestBillboard(int[] rods) {

        int n = rods.length;
        if (n <= 1) return 0;
        Arrays.sort(rods);
        int half = 0, k = n-1, m = 0;
        while (k >= 1 && rods[k] == rods[k-1]) k--;
        k = n - k;

        if (k >= 2) {

            int x = k >> 1;
            m += x * rods[n-1];
            if ((n -= x << 1) <= 1) return m;
        }

        for (int i = 0; i < n; i++) half += rods[i];
        half >>= 1;
        t = new int[n];
        t[n-1] = rods[n-1];
        for (int i = n-2; i >= 0; i--) t[i] = t[i+1] + rods[i];
        f = new List[half+1];
        dfs(0, n, 0, 0, half, rods);
        return result == -1 ? 0 : result + m;
    }

}
