package hard;

/*
    Given an integer array of digits, return the largest multiple of three that
    can be formed by concatenating some of the given digits in any order.

    Since the answer may not fit in an integer data type, return the answer as a string.
    If there is no answer return an empty string.
 */
public class LargestMultipleOfThree {

    public static void main(String... args) {

        int[] digits = {8, 6, 7, 1, 0};
        LargestMultipleOfThree largestMultipleOfThree = new LargestMultipleOfThree();
        System.out.println(largestMultipleOfThree.largestMultipleOfThree(digits));
    }

    public String largestMultipleOfThree(int[] digits) {

        int s = 0;
        int[] f = new int[10];

        for (int x : digits) {
            s += x;
            f[x]++;
        }

        s %= 3;

        if (s == 1) {

            if (f[1] != 0) f[1]--;
            else if (f[4] != 0) f[4]--;
            else if (f[7] != 0) f[7]--;
            else if (f[2] >= 2) f[2] -= 2;
            else if (f[2] != 0 && f[5] != 0) {
                f[2]--;
                f[5]--;
            } else if (f[5] >= 2) f[5] -= 2;
            else if (f[2] != 0 && f[8] != 0) {
                f[2]--;
                f[8]--;
            } else if (f[5] != 0 && f[8] != 0) {
                f[5]--;
                f[8]--;
            } else if (f[8] >= 2) f[8] -= 2;
            else return "";
        } else if (s == 2) {

            if (f[2] != 0) f[2]--;
            else if (f[5] != 0) f[5]--;
            else if (f[8] != 0) f[8]--;
            else if (f[1] >= 2) f[1] -= 2;
            else if (f[1] != 0 && f[4] != 0) {
                f[1]--;
                f[4]--;
            } else if (f[4] >= 2) f[4] -= 2;
            else if (f[1] != 0 && f[7] != 0) {
                f[1]--;
                f[7]--;
            } else if (f[4] != 0 && f[7] != 0) {
                f[4]--;
                f[7]--;
            } else if (f[7] >= 2) f[7] -= 2;
            else return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 1; i--)
            for (int j = 0; j < f[i]; j++)
                sb.append(i);

        if (sb.length() == 0) return f[0] == 0 ? "" : "0";
        for (int i = 0; i < f[0]; i++) sb.append(0);
        return sb.toString();
    }

}
