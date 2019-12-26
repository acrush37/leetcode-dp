package hard;

import java.util.Arrays;
import java.util.Comparator;

/*
    We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

    You're given the startTime , endTime and profit arrays, you need to output the maximum profit
    you can take such that there are no 2 jobs in the subset with overlapping time range.
 */
public class MaximumProfitInJobScheduling {

    public static void main(String... args) {

        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        MaximumProfitInJobScheduling maximumProfitInJobScheduling = new MaximumProfitInJobScheduling();
        System.out.println(maximumProfitInJobScheduling.jobScheduling(startTime, endTime, profit));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        int[][] t = new int[n][3];
        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            t[i][0] = startTime[i];
            t[i][1] = endTime[i];
            t[i][2] = profit[i];
        }

        Arrays.sort(t, Comparator.comparingInt(x -> x[1]));
        f[0] = t[0][2];

        for (int i = 1; i < n; i++) {

            for (int j = i-1; j >= 0; j--)
                if (t[j][1] <= t[i][0]) {
                    f[i] = f[j];
                    break;
                }

            f[i] = Math.max(f[i-1], f[i] + t[i][2]);
        }

        return f[n-1];
    }

}
