package hard;

/*
    Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 */
public class InterleavingString {

    public static void main(String... args) {

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) return false;
        boolean f[][] = new boolean[s1.length() + 1][s2.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) f[i][0] = f[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for (int i = 1; i <= s2.length(); i++) f[0][i] = f[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);

        for (int i = 1; i <= s1.length(); i++)
            for (int j = 1; j <= s2.length(); j++) {
                char k = s3.charAt(i+j-1);
                f[i][j] = f[i-1][j] && s1.charAt(i-1) == k || f[i][j-1] && s2.charAt(j-1) == k;
            }

        return f[s1.length()][s2.length()];
    }

}
