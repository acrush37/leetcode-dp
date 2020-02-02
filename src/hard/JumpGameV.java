package hard;

/*
    Given an array of integers arr and an integer d. In one step you can jump from index i to index:

    i + x where: i + x < arr.length and 0 < x <= d.
    i - x where: i - x >= 0 and 0 < x <= d.

    In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k]
    for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

    You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
    Notice that you can not jump outside of the array at any time.
 */
public class JumpGameV {

    private int[] f;

    public static void main(String... args) {

        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        JumpGameV jumpGameV = new JumpGameV();
        System.out.println(jumpGameV.maxJumps(arr, 2));
    }

    private int dfs(int p, int n, int d, int[] a) {

        if (f[p] != 0) return f[p];
        f[p] = 1;
        int x = Math.min(n, p+d), y = Math.max(0, p-d);

        for (int i = p+1; i <= x; i++) {
            if (a[i] >= a[p]) break;
            if (f[i] == 0) f[i] = dfs(i, n, d, a);
            f[p] = Math.max(f[p], f[i] + 1);
        }

        for (int i = p-1; i >= y; i--) {
            if (a[i] >= a[p]) break;
            if (f[i] == 0) f[i] = dfs(i, n, d, a);
            f[p] = Math.max(f[p], f[i] + 1);
        }

        return f[p];
    }

    public int maxJumps(int[] arr, int d) {

        int result = 0, n = arr.length;
        f = new int[n];

        for (int i = 0; i < n; i++)
            result = Math.max(result, f[i] != 0 ? f[i] : dfs(i, n-1, d, arr));

        return result;
    }

}
