package medium;

/*
    For the purposes of this question, we will consider that a falling domino
    expends no additional force to a falling or already fallen domino.

    Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left;
    S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

    Return a string representing the final state.
 */
public class PushDominoes {

    public static void main(String... args) {

        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes("..R.."));
    }

    public String pushDominoes(String dominoes) {

        StringBuilder sb = new StringBuilder();
        char[] t = dominoes.toCharArray();
        boolean flag = false;
        int count = 0;

        for (char c : t)
            if (c == '.') count++;
            else {
                if (c == 'R') {
                    char ch = flag ? 'R' : '.';
                    for (int i = 0; i < count; i++) sb.append(ch);
                    flag = true;
                } else {
                    if (!flag) for (int i = 0; i < count; i++) sb.append('L');
                    else {
                        int n = count >> 1;
                        for (int i = 0; i < n; i++) sb.append('R');
                        if ((count & 1) == 1) sb.append('.');
                        for (int i = 0; i < n; i++) sb.append('L');
                    }

                    flag = false;
                }

                sb.append(c);
                count = 0;
            }

        if (count > 0) {
            char ch = flag ? 'R' : '.';
            while (--count >= 0) sb.append(ch);
        }

        return sb.toString();
    }

}
