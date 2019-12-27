package medium;

/*
    For example, two players might take turns drawing from a common pool of
    numbers of 1..15 without replacement until they reach a total >= 100.

    Given an integer maxChoosableInteger and another integer desiredTotal, determine if
    the first player to move can force a win, assuming both players play optimally.

    You can always assume that maxChoosableInteger will not be
    larger than 20 and desiredTotal will not be larger than 300.
 */
public class CanIWin {

    private Boolean[] f;

    public static void main(String... args) {

        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(10, 42));
    }

    private boolean dfs(int x, int y, boolean[] t) {

        int z = 0;
        for (int i = 1; i <= x; i++) if (t[i]) z += 1 << (i-1);
        if (f[z] != null) return f[z];
        f[z] = false;

        for (int i = x; i >= 1; i--)
            if (!t[i]) {

                if (i >= y) return f[z] = true;
                t[i] = true;
                if (!dfs(x, y-i, t)) f[z] = true;
                t[i] = false;
            }

        return f[z];
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger == desiredTotal-1) return false;
        int x = (maxChoosableInteger * (1+maxChoosableInteger)) >> 1;
        if (x < desiredTotal) return false;
        int y = 0;
        for (int i = 0; i < maxChoosableInteger; i++) y += 1 << i;
        f = new Boolean[y+1];
        return dfs(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger+1]);
    }

}
