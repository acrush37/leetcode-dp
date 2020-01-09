package hard;

/*
    We are given an array A of N lowercase letter strings, all of the same length.

    Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

    Suppose we chose a set of deletion indices D such that after deletions, the final array has every element (row) in lexicographic order.

    Return the minimum possible value of D.length.
 */
public class DeleteColumnsToMakeSortedIII {

    public static void main(String... args) {

        String[] A = {"baabab"};
        DeleteColumnsToMakeSortedIII deleteColumnsToMakeSortedIII = new DeleteColumnsToMakeSortedIII();
        System.out.println(deleteColumnsToMakeSortedIII.minDeletionSize(A));
    }

    public int minDeletionSize(String[] A) {

        int m = A.length, n = A[0].length();
        boolean[][] t = new boolean[n][n];
        char[][] c = new char[m][n];
        int[] f = new int[n];
        int count = f[0] = 1;
        for (int i = 0; i < m; i++) c[i] = A[i].toCharArray();

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++) {

                t[i][j] = true;

                for (int k = 0; k < m; k++)
                    if (c[k][i] > c[k][j]) {
                        t[i][j] = false;
                        break;
                    }
            }

        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) if (t[j][i]) f[i] = Math.max(f[i], f[j] + 1);
            count = Math.max(count, f[i]);
        }

        return n - count;
    }

}
