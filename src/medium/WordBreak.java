package medium;

import java.util.Arrays;
import java.util.List;

/*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak {

    public static void main(String... args) {

        List<String> wordDict1 = Arrays.asList("leet", "code");
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", wordDict1));
        System.out.println(wordBreak.wordBreak("applepenapple", wordDict2));
        System.out.println(wordBreak.wordBreak("catsandog", wordDict3));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] f = new boolean[n+1];
        f[0] = true;
        int p;

        for (int i = 1; i <= n; i++)
            for (String word : wordDict)
                if (f[i]) break;
                else {
                    p = i - word.length();
                    if (p < 0) continue;
                    if (f[p]) f[i] = word.equals(s.substring(p, i));
                }

        return f[n];
    }

}
