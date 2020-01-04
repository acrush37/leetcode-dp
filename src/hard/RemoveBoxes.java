package hard;

import java.util.*;

/*
    Given several boxes with different colors represented by different positive numbers.
    You may experience several rounds to remove boxes until there is no box left.

    Each time you can choose some continuous boxes with the same color
    (composed of k boxes, k >= 1), remove them and get k*k points.

    Find the maximum points you can get.
 */
public class RemoveBoxes {

    private int[][][] f;

    public static void main(String... args) {

        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        RemoveBoxes removeBoxes = new RemoveBoxes();
        System.out.println(removeBoxes.removeBoxes(boxes));
    }

    private int dfs(int x, int y, int z, int[] boxes) {

        if (x > y) return 0;
        if (f[x][y][z] > 0) return f[x][y][z];
        f[x][y][z] = (z+1)*(z+1) + dfs(x+1, y, 0, boxes);

        for (int i = x+1; i <= y; i++)
            if (boxes[i] == boxes[x])
                f[x][y][z] = Math.max(f[x][y][z], dfs(x+1, i-1, 0, boxes) + dfs(i, y, z+1, boxes));

        return f[x][y][z];
    }

    public int removeBoxes(int[] boxes) {

        int n = boxes.length;
        f = new int[n][n][n];
        return dfs(0, n-1, 0, boxes);
    }

}
