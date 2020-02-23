package hard;

/*
    Given n orders, each order consist in pickup and delivery services.

    Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).

    Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class CountAllValidPickupAndDeliveryOptions {

    public static void main(String... args) {

        CountAllValidPickupAndDeliveryOptions countAllValidPickupAndDeliveryOptions = new CountAllValidPickupAndDeliveryOptions();
        System.out.println(countAllValidPickupAndDeliveryOptions.countOrders(3));
    }

    public int countOrders(int n) {

        long s = 1;
        int p = 1000000007;
        for (int i = 2; i <= n; i++) s = (i * ((i << 1) - 1) * s) % p;
        return (int) s;
    }

}
