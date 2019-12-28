package hard;

/*
    N couples sit in 2N seats arranged in a row and want to hold hands.
    We want to know the minimum number of swaps so that every couple is sitting side by side.
    A swap consists of choosing any two people, then they stand up and switch seats.

    The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the
    first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 */
public class CouplesHoldingHands {

    public static void main(String... args) {

        int[] row = {0, 4, 6, 5, 3, 7, 1, 2};
        CouplesHoldingHands couplesHoldingHands = new CouplesHoldingHands();
        System.out.println(couplesHoldingHands.minSwapsCouples(row));
    }

    public int minSwapsCouples(int[] row) {

        int result = 0, n = row.length;

        for (int i = 0; i < n; i += 2) {

            int x = Math.min(row[i], row[i+1]);
            int y = Math.max(row[i], row[i+1]);
            if (x == y-1 && (x & 1) == 0) continue;
            x = (x & 1) == 0 ? x+1 : x-1;
            result++;

            for (int j = i+2; j < n; j++)
                if (row[j] == x) {
                    row[j] = y;
                    break;
                }
        }

        return result;
    }

}
