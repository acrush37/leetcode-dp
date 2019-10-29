package medium;

/*
    In a country popular for train travel, you have planned some train travelling one year in advance.
    The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

    Train tickets are sold in 3 different ways:

        a 1-day pass is sold for costs[0] dollars;
        a 7-day pass is sold for costs[1] dollars;
        a 30-day pass is sold for costs[2] dollars.

    The passes allow that many days of consecutive travel.
    For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

    Return the minimum number of dollars you need to travel every day in the given list of days.
 */

public class MinimumCostForTickets {

    public static void main(String... args) {

        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8,9,10,30,31};
        int[] costs1 = {2, 7, 15};
        int[] costs2 = {2, 7, 15};
        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
        System.out.println(minimumCostForTickets.mincostTickets(days1, costs1));
        System.out.println(minimumCostForTickets.mincostTickets(days2, costs2));
    }

    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int[] f = new int[n+1];
        f[1] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = 2; i <= n; i++) {

            f[i] = f[i-1] + f[1];

            for (int j = i-1; j >= 1; j--)
                if (days[i-1] - days[j-1] >= 30) break;
                else {
                    int diff = days[i-1] - days[j-1];
                    if (diff < 30) f[i] = Math.min(f[i], f[j-1] + costs[2]);
                    if (diff < 7) f[i] = Math.min(f[i], f[j-1] + costs[1]);
                }
        }

        return f[n];
    }

}
