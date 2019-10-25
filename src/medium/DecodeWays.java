package medium;

/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

    Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */

import java.util.Arrays;
import java.util.List;


public class DecodeWays {

    private static List<String> set = Arrays.asList("10", "11", "12", "13", "14", "15", "16","17",
                                            "18", "19", "20", "21", "22", "23", "24", "25", "26");

    public static void main(String... args) {

        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("12"));
        System.out.println(decodeWays.numDecodings("226"));
    }

    public int numDecodings(String s) {

        int n = s.length();
        if (s.charAt(0) == '0') return 0;
        if (n == 1) return 1;
        char[] a = s.toCharArray();
        int[] f = new int[n+1];
        f[0]  = f[1] = 1;

        for (int i = 2; i <= n; i++)
            f[i] += (a[i-1] == '0' ? 0 : f[i-1]) + (set.contains(a[i-2] + "" + a[i-1]) ? f[i-2] : 0);

        return f[n];
    }

}
