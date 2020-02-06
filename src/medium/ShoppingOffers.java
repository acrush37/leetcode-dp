package medium;

import java.util.*;

/*
    You are given the each item's price, a set of special offers, and the number we need to buy for each item.

    The job is to output the lowest price you have to pay for exactly certain items as given,
    where you could make optimal use of the special offers.

    Each special offer is represented in the form of an array, the last number represents the price you need to pay
    for this special offer, other numbers represents how many specific items you could get if you buy this offer.
 */
public class ShoppingOffers {

    private int n;

    private List<Integer> p;

    private List<List<Integer>> t;

    private Map<String, Integer> f = new HashMap<>();

    public static void main(String... args) {

        List<Integer> price = Arrays.asList(2, 3, 4);
        List<Integer> needs = Arrays.asList(1, 2, 1);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1, 1, 0, 4));
        special.add(Arrays.asList(2, 2, 1, 9));
        ShoppingOffers shoppingOffers = new ShoppingOffers();
        System.out.println(shoppingOffers.shoppingOffers(price, special, needs));
    }

    private int dfs(int[] a) {

        boolean flag = true;

        for (int i = 0; i < n; i++)
            if (a[i] != 0) {
                flag = false;
                break;
            }

        if (flag) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('|').append(a[i]);
        String s = sb.toString();
        Integer x = f.get(s);
        if (x != null) return x;
        x = 0;
        for (int i = 0; i < n; i++) x += a[i] * p.get(i);

        for (List<Integer> list : t) {

            flag = false;

            for (int i = 0; i < n; i++)
                if (a[i] < list.get(i)) {
                    flag = true;
                    break;
                }

            if (flag) continue;
            for (int i = 0; i < n; i++) a[i] -= list.get(i);
            x = Math.min(x, list.get(n) + dfs(a));
            for (int i = 0; i < n; i++) a[i] += list.get(i);
        }

        f.put(s, x);
        return x;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        p = price;
        t = special;
        n = price.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = needs.get(i);
        return dfs(a);
    }

}
