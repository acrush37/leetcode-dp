package hard;

/*
    Given a string S, count the number of distinct, non-empty subsequences of S .

    Since the result may be large, return the answer modulo 10^9 + 7.
 */
public class DistinctSubsequencesII {

    public static void main(String... args) {

        DistinctSubsequencesII distinctSubsequencesII = new DistinctSubsequencesII();
        System.out.println(distinctSubsequencesII.distinctSubseqII("aba"));
    }

    public int distinctSubseqII(String S) {

        int result = 0, p = 1000000007;
        int[] f = new int[123];

        for (char c : S.toCharArray()) {

            int t = result;
            result = ((t << 1) - f[c] + 1) % p;
            result = (result + p) % p;
            f[c] = t + 1;
        }

        return result;
    }

}
