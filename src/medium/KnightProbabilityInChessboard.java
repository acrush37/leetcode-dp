package medium;

/*
    A chess knight has 8 possible moves it can make, as illustrated below.
    Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

    Each time the knight is to move, it chooses one of eight possible moves uniformly at random
    (even if the piece would go off the chessboard) and moves there.

    The knight continues moving until it has made exactly K moves or has moved off the chessboard.
    Return the probability that the knight remains on the board after it has stopped moving.
 */
public class KnightProbabilityInChessboard {

    private Double[][][] f;

    private int[] a = {-1, -2, -1, -2, 1, 2, 1, 2};

    private int[] b = {-2, -1, 2, 1, -2, -1, 2, 1};

    public static void main(String... args) {

        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        System.out.println(knightProbabilityInChessboard.knightProbability(3, 2, 0, 0));
    }

    private double dfs(int k, int x, int y, int n) {

        if (x < 0 || y < 0 || x >= n || y >= n) return 0;
        if (k == 0) return 1;
        if (f[x][y][k] != null) return f[x][y][k];
        f[x][y][k] = 0d;
        for (int i = 0; i <= 7; i++) f[x][y][k] += dfs(k-1, x+a[i], y+b[i], n);
        return f[x][y][k] /= 8;
    }

    public double knightProbability(int N, int K, int r, int c) {

        f = new Double[N][N][K+1];
        return dfs(K, r, c, N);
    }

}
