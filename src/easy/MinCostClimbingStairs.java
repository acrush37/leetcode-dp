package easy;

/*
    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
    and you can either start from the step with index 0, or the step with index 1.
 */

public class MinCostClimbingStairs {

    public static void main(String... args) {

        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost1));
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost2));
    }

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] f = new int[n+1];
        f[1] = cost[0];
        for (int i = 2; i <= n; i++) f[i] = Math.min(f[i-1], f[i-2]) + cost[i-1];
        return Math.min(f[n], f[n-1]);
    }

}
