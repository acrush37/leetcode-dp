package hard;

/*
    A frog is crossing a river. The river is divided into x units and at each unit there may
    or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

    Given a list of stones' positions (in units) in sorted ascending order, determine
    if the frog is able to cross the river by landing on the last stone. Initially,
    the frog is on the first stone and assume the first jump must be 1 unit.

    If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
    Note that the frog can only jump in the forward direction.
 */
public class FrogJump {

    public static void main(String... args) {

        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.canCross(stones));
    }

    private boolean dfs(int p, int k, int[] s) {

        if (p == s.length-1) return true;

        for (int i = s.length-1; i > p; i--) {

            int x = s[i] - s[p];
            if (x < k-1 || x > k+1) continue;
            if (dfs(i, x, s)) return true;
        }

        return false;
    }

    public boolean canCross(int[] stones) {

        for (int i = 1; i < stones.length; i++)
            if (stones[i] - stones[i-1] > i)
                return false;

        return dfs(0, 0, stones);
    }

}
