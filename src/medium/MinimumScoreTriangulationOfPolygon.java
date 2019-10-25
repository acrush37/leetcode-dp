package medium;

/*
    Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.

    Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that triangle is the product of the labels of the vertices,
    and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.

    Return the smallest possible total score that you can achieve with some triangulation of the polygon.
 */

public class MinimumScoreTriangulationOfPolygon {

    public static void main(String... args) {

        int[] A1 = {1, 2, 3};
        int[] A2 = {3, 7, 4, 5};
        int[] A3 = {1, 3, 1, 4, 1, 5};
        MinimumScoreTriangulationOfPolygon minimumScoreTriangulationOfPolygon = new MinimumScoreTriangulationOfPolygon();
        System.out.println(minimumScoreTriangulationOfPolygon.minScoreTriangulation(A1));
        System.out.println(minimumScoreTriangulationOfPolygon.minScoreTriangulation(A2));
        System.out.println(minimumScoreTriangulationOfPolygon.minScoreTriangulation(A3));
    }

    public int minScoreTriangulation(int[] A) {

        int n = A.length;
        if (n == 3) return A[0] * A[1] * A[2];
        int[][] f = new int[n+1][n+1];
        for (int i = 1; i < n-1; i++) f[i][i+2] = A[i-1] * A[i] * A[i+1];

        for (int i = 3; i < n; i++)
            for (int j = 1; j <= n-i; j++) {

                f[j][i+j] = Integer.MAX_VALUE;

                for (int k = j+1; k < i+j; k++)
                    f[j][i+j] = Math.min(f[j][i+j], A[j-1] * A[k-1] * A[i+j-1] + f[j][k] + f[k][i+j]);
            }

        return f[1][n];
    }

}
