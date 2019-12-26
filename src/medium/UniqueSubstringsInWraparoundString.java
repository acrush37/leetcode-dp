package medium;

/*
    Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
    so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

    Now we have another string p. Your job is to find out how many unique non-empty
    substrings of p are present in s. In particular, your input is the string p and
    you need to output the number of different non-empty substrings of p in the string s.
 */
public class UniqueSubstringsInWraparoundString {

    public static void main(String... args) {

        UniqueSubstringsInWraparoundString uniqueSubstringsInWraparoundString = new UniqueSubstringsInWraparoundString();
        System.out.println(uniqueSubstringsInWraparoundString.findSubstringInWraproundString("zab"));
    }

    public int findSubstringInWraproundString(String p) {

        int result = 0, n = p.length();
        char[] c = p.toCharArray();
        boolean[][] t = new boolean[26][n];

        for (int i = 0; i < n; i++) {

            int x = c[i]-97;
            t[x][0] = true;

            for (int j = i-1; j >= 0; j--)
                if ((c[j] + 1) % 26 != c[j+1] % 26) break;
                else t[x][i-j] = true;
        }

        for (int i = 0; i < 26; i++)
            for (int j = 0; j < n; j++)
                if (t[i][j]) result++;

        return result;
    }

}
