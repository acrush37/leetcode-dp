package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    You are given a square board of characters.
    You can move on the board starting at the bottom right square marked with the character 'S'.

    You need to reach the top left square marked with the character 'E'.
    The rest of the squares are labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'.
    In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

    Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect,
    and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.

    In case there is no path, return [0, 0].
 */
public class NumberOfPathsWithMaxScore {

    public static void main(String... args) {

        List<String> board = Arrays.asList("E12","1X1","21S");
        NumberOfPathsWithMaxScore numberOfPathsWithMaxScore = new NumberOfPathsWithMaxScore();
        int[] arr = numberOfPathsWithMaxScore.pathsWithMaxScore(board);
        System.out.println("[" + arr[0] + ',' + arr[1] + "]");
    }

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size(), p = 1000000007;
        int[][] f = new int[n+1][n+1];
        int[][] a = new int[n+1][n+1];
        Map<Integer, Integer>[][] t = new Map[n+1][n+1];

        for (int i = 0; i < n; i++) {
            char[] c = board.get(i).toCharArray();
            for (int j = 0; j < n; j++) a[i][j] = c[j] == 'X' ? -1 : c[j] - 48;
        }

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                t[i][j] = new HashMap<>();

        t[n-1][n-1].put(0, 1);
        a[0][0] = a[n-1][n-1] = 0;

        for (int i = n-1; i >= 0; i--)
            for (int j = n-1; j >= 0; j--)
                if (a[i][j] != -1) {

                    if (a[i+1][j+1] != -1) {

                        f[i][j] = f[i+1][j+1];
                        Integer x = t[i+1][j+1].get(f[i+1][j+1]);
                        if (x != null) t[i][j].put(a[i][j] + f[i+1][j+1], x % p);
                    }

                    if (a[i+1][j] != -1) {

                        f[i][j] = Math.max(f[i][j], f[i+1][j]);
                        Integer x = t[i+1][j].get(f[i+1][j]);

                        if (x != null) {
                            Integer y = t[i][j].get(a[i][j] + f[i+1][j]);
                            t[i][j].put(a[i][j] + f[i+1][j], y == null ? x % p : (x+y) % p);
                        }
                    }

                    if (a[i][j+1] != -1) {

                        f[i][j] = Math.max(f[i][j], f[i][j+1]);
                        Integer x = t[i][j+1].get(f[i][j+1]);

                        if (x != null) {
                            Integer y = t[i][j].get(a[i][j] + f[i][j+1]);
                            t[i][j].put(a[i][j] + f[i][j+1], y == null ? x % p : (x+y) % p);
                        }
                    }

                    f[i][j] += a[i][j];
                }

        Integer x = t[0][0].get(f[0][0]);
        return x == null ? new int[]{0, 0} : new int[]{f[0][0], x};
    }

}
