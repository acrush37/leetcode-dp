package hard;

/*
    A car travels from a starting position to a destination which is target miles east of the starting position.

    Along the way, there are gas stations.  Each station[i] represents a gas station that is
    station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
    It uses 1 liter of gas per 1 mile that it drives.

    When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
    If it cannot reach the destination, return -1.
 */
public class MinimumNumberOfRefuelingStops {

    public static void main(String... args) {

        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        MinimumNumberOfRefuelingStops minimumNumberOfRefuelingStops = new MinimumNumberOfRefuelingStops();
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(100, 10, stations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int n = stations.length;
        long[] f = new long[n+1];
        f[0] = startFuel;

        for (int i = 0; i < n; i++)
            for (int j = i; j >= 0; j--)
                if (f[j] >= stations[i][0])
                    f[j+1] = Math.max(f[j+1], f[j] + Long.valueOf(stations[i][1]));

        for (int i = 0; i <= n; i++) if (f[i] >= target) return i;
        return -1;
    }

}
