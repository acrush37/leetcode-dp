package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a positive integer n, find the number of non-negative integers less than or equal to n,
    whose binary representations do NOT contain consecutive ones.
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {

    private Map<Integer, Integer> f = new HashMap<>();

    public static void main(String... args) {

        NonNegativeIntegersWithoutConsecutiveOnes nonNegativeIntegersWithoutConsecutiveOnes = new NonNegativeIntegersWithoutConsecutiveOnes();
        System.out.println(nonNegativeIntegersWithoutConsecutiveOnes.findIntegers(134));
    }

    private int dfs(List<Integer> a) {

        if (a.isEmpty()) return 1;
        int n = a.size();
        if (n == 1) return 1 << a.get(0);
        int s = 0;

        for (int i = 0; i < n; i++)
            if (a.get(n-i-1) == 1)
                s += 1 << i;

        if (f.containsKey(s)) return f.get(s);

        if (a.get(0) == 0) {
            int y = dfs(a.subList(1, n));
            f.put(s, y);
            return y;
        }

        List<Integer> b = new ArrayList<>();
        for (int i = 1; i < n; i++) b.add(1);
        int y = a.get(1) == 0 ? dfs(b) + dfs(a.subList(2, n)) : dfs(b) + dfs(b.subList(1, b.size()));
        f.put(s, y);
        return y;
    }

    public int findIntegers(int num) {

        if (num <= 1) return num + 1;
        List<Integer> t = new ArrayList<>();

        while (num != 0) {
            int x = num & 1;
            num >>= 1;
            t.add(0, x);
        }

        return dfs(t);
    }

}
