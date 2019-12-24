package medium;

/*
    There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move
    the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right).
    However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary.
    The answer may be very large, return it after mod 109 + 7.
 */
public class OutOfBoundaryPaths {

    private Integer[][][] f = new Integer[50][50][51];

    public static void main(String... args) {

        OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
        System.out.println(outOfBoundaryPaths.findPaths(8,7,16,1,5));
    }

    public int findPaths(int m, int n, int N, int i, int j) {

        if (N == -1) return 0;
        if (i == -1 || j == -1 || i == m || j == n) return 1;
        if (f[i][j][N] != null) return f[i][j][N];
        int up = findPaths(m, n, N-1, i-1, j);
        int down = findPaths(m, n, N-1, i+1, j);
        int left = findPaths(m, n, N-1, i, j-1);
        int right = findPaths(m, n, N-1, i, j+1);
        f[i][j][N] = (up + down) % 1000000007 + (left + right) % 1000000007;
        return f[i][j][N] %= 1000000007;
    }

}
