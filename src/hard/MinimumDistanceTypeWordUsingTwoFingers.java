package hard;

/*
    You have a keyboard layout as shown above in the XY plane, where each English uppercase letter is located
    at some coordinate, for example, the letter A is located at coordinate (0,0), the letter B is located at
    coordinate (0,1), the letter P is located at coordinate (2,3) and the letter Z is located at coordinate (4,1).

    Given the string word, return the minimum total distance to type such string using only two fingers.
    The distance between coordinates (x1,y1) and (x2,y2) is |x1 - x2| + |y1 - y2|.
 */
public class MinimumDistanceTypeWordUsingTwoFingers {

    public static void main(String... args) {

        MinimumDistanceTypeWordUsingTwoFingers minimumDistanceTypeWordUsingTwoFingers = new MinimumDistanceTypeWordUsingTwoFingers();
        System.out.println(minimumDistanceTypeWordUsingTwoFingers.minimumDistance("HAPPY"));
    }

    public int minimumDistance(String word) {

        int n = word.length();
        if (n <= 2) return 0;
        int[][] t = new int[27][27];
        char[] c = word.toCharArray();
        int[][][] f = new int[2][27][27];

        for (int i = 0; i < 26; i++) {
            int x = i / 6, y = i % 6;
            for (int j = i; j < 26; j++) t[i][j] = t[j][i] = Math.abs(x - j / 6) + Math.abs(y - j % 6);
        }

        for (int i = n-1; i >= 0; i--) {

            int x = i & 1;
            int y = x ^ 1;
            int p = c[i] - 65;

            for (int j = 0; j <= 26; j++)
                for (int k = 0; k <= 26; k++)
                    f[x][j][k] = Math.min(f[y][p][k] + t[p][j], f[y][j][p] + t[p][k]);
        }

        return f[0][26][26];
    }

}
