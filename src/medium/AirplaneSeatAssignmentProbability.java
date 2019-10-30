package medium;

/*
    n passengers board an airplane with exactly n seats.
    The first passenger has lost the ticket and picks a seat randomly. But after that, the rest of passengers will:

    Take their own seat if it is still available,
    Pick other seats randomly when they find their seat occupied
    What is the probability that the n-th person can get his own seat?
 */

public class AirplaneSeatAssignmentProbability {

    public static void main(String... args) {

        AirplaneSeatAssignmentProbability airplaneSeatAssignmentProbability = new AirplaneSeatAssignmentProbability();
        System.out.println(airplaneSeatAssignmentProbability.nthPersonGetsNthSeat(1));
        System.out.println(airplaneSeatAssignmentProbability.nthPersonGetsNthSeat(2));
    }

    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }

}
