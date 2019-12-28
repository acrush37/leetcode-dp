package hard;

/*
    Given a list of words, list of  single letters (might be repeating) and score of every character.

    Return the maximum score of any valid set of words formed by using the given letters
    (words[i] cannot be used two or more times).

    It is not necessary to use all characters in letters and each letter can only be used once.
    Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 */
public class MaximumScoreWordsFormedByLetters {

    public static void main(String... args) {

        String[] words = {"xxxz", "ax", "bx", "cx"};
        char[] letters = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
        int[] score = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};
        MaximumScoreWordsFormedByLetters maximumScoreWordsFormedByLetters = new MaximumScoreWordsFormedByLetters();
        System.out.println(maximumScoreWordsFormedByLetters.maxScoreWords(words, letters, score));
    }

    private int dfs(int n, int[] t, int[][] w, int[] s) {

        if (n == -1) return 0;
        int[] a = new int[26];
        int p = 0;

        for (int i = 0; i < 26; i++)
            if (w[n][i] > t[i]) return dfs(n-1, t, w, s);
            else {
                p += w[n][i] * s[i];
                a[i] = t[i] - w[n][i];
            }

        return Math.max(dfs(n-1, a, w, s) + p, dfs(n-1, t, w, s));
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int n = words.length;
        int[] t = new int[26];
        int[][] w = new int[n][26];
        for (char c : letters) t[c-97]++;

        for (int i = 0; i < n; i++) {
            char[] ch = words[i].toCharArray();
            for (char c : ch) w[i][c-97]++;
        }

        return dfs(n-1, t, w, score);
    }

}
