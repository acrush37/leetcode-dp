package hard;

import java.util.Arrays;

/*
    You have a number of envelopes with widths and heights given as a pair of integers (w, h).

    One envelope can fit into another if and only if both the width and height of one envelope
    is greater than the width and height of the other envelope.

    What is the maximum number of envelopes can you Russian doll? (put one inside other)
 */
public class RussianDollEnvelopes {

    public static void main(String... args) {

        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        System.out.println(russianDollEnvelopes.maxEnvelopes(envelopes));
    }

    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        if (n <= 1) return n;
        Arrays.sort(envelopes, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int[] f = new int[n];
        int result = f[0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++)
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    f[i] = Math.max(f[i], f[j]);

            result = Math.max(result, ++f[i]);
        }

        return result;
    }

}
