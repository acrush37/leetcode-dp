package hard;

/*
    We have a sorted set of digits D, a non-empty subset of {'1','2','3','4','5','6','7','8','9'}.

    Now, we write numbers using these digits, using each digit as many times as we want.
    For example, if D = {'1','3','5'}, we may write numbers such as '13', '551', '1351315'.

    Return the number of positive integers that can be written (using the digits of D) that are less than or equal to N.
 */
public class NumbersAtMostNGivenDigitSet {

    public static void main(String... args) {

        String[] D = {"3", "4", "8"};
        NumbersAtMostNGivenDigitSet numbersAtMostNGivenDigitSet = new NumbersAtMostNGivenDigitSet();
        System.out.println(numbersAtMostNGivenDigitSet.atMostNGivenDigitSet(D, 4));
    }

    public int atMostNGivenDigitSet(String[] D, int N) {

        char[] ch = (N + "").toCharArray();
        int n = ch.length;
        int[] c = new int[n], f = new int[10];
        for (int i = 0; i < n; i++) c[i] = ch[i] - 48;
        for (int i = 0; i < D.length; i++) f[Integer.parseInt(D[i])] = i+1;
        int m = Integer.parseInt(D[D.length-1]);

        if (f[c[0]] == 0)
            for (int i = c[0]-1; i >= 1; i--)
                if (f[i] != 0) {
                    c[0] = i;
                    for (int j = 1; j < n; j++) c[j] = m;
                    break;
                }

        if (f[c[0]] == 0) return 0;

        for (int i = 0; i < D.length-1; i++) {
            int x = Integer.parseInt(D[i]);
            int y = Integer.parseInt(D[i+1]);
            for (int j = x+1; j < y; j++) f[j] = f[x];
        }

        if (n == 1) return f[c[0]];
        c[0] = Math.min(c[0], 1);
        int result = 0, k = 1;
        for (int i = m+1; i <= 9; i++) f[i] = f[m];
        for (int i = 1; i < n; i++) result += c[0] * (k *= D.length);
        k = 1;

        for (int i = 1; i < n; i++) {
            if (f[c[i]] == 0) return result;
            k *= f[c[i]];
        }

        return result + k;
    }

}
