package hard;

/*
    Given two arrays of length m and n with digits 0-9 representing two numbers.
    Create the maximum number of length k <= m + n from digits of the two.

    The relative order of the digits from the same array must be preserved.
    Return an array of the k digits.
 */
public class CreateMaximumNumber {

    public static void main(String... args) {

        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        System.out.println(createMaximumNumber);
    }

    private int[] merge(int[] a, int[] b, int k, int m, int n) {

        int x = 0, y = 0;
        int[] c = new int[k];

        for (int i = 0; i < k; i++)
            if (x == m) c[i] = b[y++];
            else if (y == n || a[x] > b[y]) c[i] = a[x++];
            else if (a[x] < b[y]) c[i] = b[y++];
            else {
                int u = x, v = y;

                while (u < m && v < n && a[u] == b[v]) {
                    u++;
                    v++;
                }

                if (u == m) c[i] = b[y++];
                else if (v == n || a[u] > b[v]) c[i] = a[x++];
                else c[i] = b[y++];
            }

        return c;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] result = new int[k];
        int m = nums1.length, n = nums2.length;
        int[][] a = new int[m][m], b = new int[n][n];

        for (int i = 0; i < m; i++) {

            a[i][i] = i;
            int max = nums1[i];

            for (int j = i+1; j < m; j++) {
                a[i][j] = a[i][j-1];
                if (nums1[j] > max) max = nums1[a[i][j] = j];
            }
        }

        for (int i = 0; i < n; i++) {

            b[i][i] = i;
            int max = nums2[i];

            for (int j = i+1; j < n; j++) {
                b[i][j] = b[i][j-1];
                if (nums2[j] > max) max = nums2[b[i][j] = j];
            }
        }

        int[] c = new int[k];
        int[] d = new int[k];
        int y, z = Math.min(m, k);

        for (int x = z; x >= 0; x--) {

            if ((y = k-x) > n) break;
            int p = 0;

            for (int i = 0; i < x; i++) {

                int q = Math.max(p, m-x+i);
                c[i] = nums1[a[p][q]];
                p = a[p][q] + 1;
            }

            p = 0;

            for (int i = 0; i < y; i++) {

                int q = Math.max(p, n-y+i);
                d[i] = nums2[b[p][q]];
                p = b[p][q] + 1;
            }

            int[] merge = merge(c, d, k, x, y);

            for (int i = 0; i < k; i++)
                if (merge[i] < result[i]) break;
                else if (merge[i] > result[i]) {
                    result = merge;
                    break;
                }
        }

        return result;
    }

}
