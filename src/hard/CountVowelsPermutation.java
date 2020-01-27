package hard;

/*
    Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

    Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
    Each vowel 'a' may only be followed by an 'e'.
    Each vowel 'e' may only be followed by an 'a' or an 'i'.
    Each vowel 'i' may not be followed by another 'i'.
    Each vowel 'o' may only be followed by an 'i' or a 'u'.
    Each vowel 'u' may only be followed by an 'a'.

    Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class CountVowelsPermutation {

    public static void main(String... args) {

        CountVowelsPermutation countVowelsPermutation = new CountVowelsPermutation();
        System.out.println(countVowelsPermutation.countVowelPermutation(5));
    }

    public int countVowelPermutation(int n) {

        int[][] f = new int[2][5];
        int result = 0, p = 1000000007, x = 0;
        for (int i = 0; i < 5; i++) f[0][i] = 1;

        for (int i = 1; i < n; i++) {

            int y = (x = i & 1) ^ 1;
            f[x][0] = ((f[y][1] + f[y][2]) % p + f[y][4]) % p;
            f[x][1] = (f[y][0] + f[y][2]) % p;
            f[x][2] = (f[y][1] + f[y][3]) % p;
            f[x][3] = f[y][2];
            f[x][4] = (f[y][2] + f[y][3]) % p;
        }

        for (int i = 0; i < 5; i++) result = (result + f[x][i]) % p;
        return result;
    }

}
