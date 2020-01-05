package hard;

import java.util.*;

/*
    We are given N different types of stickers. Each sticker has a lowercase English word on it.

    You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.

    You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

    What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
 */
public class StickersToSpellWord {

    private int[] f = new int[32768];

    private Map<Character, Integer> m = new HashMap<>();

    public static void main(String... args) {

        String target = "thosecontinent";
        String[] stickers = {"all","chord","doctor","dance","drive","ready","phrase","skill","dress","select","if","develop","space","broad","lone","was","fight","how","window","place","has","plural","star","complete","though","rub","practice","here","nation","dark","job","observe","key","hole","short","last","neck","oh","science","industry","work","gun","rule","magnet","stead","many","push","tall","soft","road"};
        StickersToSpellWord stickersToSpellWord = new StickersToSpellWord();
        System.out.println(stickersToSpellWord.minStickers(stickers, target));
    }

    private int dfs(int n, int[] b, Map<Character, Integer> t, Map<Character, Integer>[] a) {

        int s = 0;
        boolean flag = true;
        Set<Character> set = t.keySet();

        for (Character c : set) {

            int x = t.get(c);
            if (x > 0) flag = false;
            int y = m.get(c);
            for (int i = 0; i < x; i++) s += 1 << (y+i);
        }

        if (flag) return 0;
        if (f[s] != 0) return f[s];
        f[s] = 15;

        for (int i = 0; i < n; i++)
            if (b[i] != 0) {

                b[i]--;
                for (Character c : set) t.put(c, t.get(c) - a[i].getOrDefault(c, 0));
                f[s] = Math.min(f[s], 1 + dfs(n, b, t, a));
                for (Character c : set) t.put(c, t.get(c) + a[i].getOrDefault(c, 0));
                b[i]++;
            }

        return f[s];
    }

    public int minStickers(String[] stickers, String target) {

        int n = stickers.length;
        int[] b = new int[n];
        Map<Character, Integer>[] a = new Map[n];
        Map<Character, Integer> t = new HashMap<>();
        char[] ch = target.toCharArray();
        for (char c : ch) t.put(c, t.getOrDefault(c, 0) + 1);

        for (int i = 0; i < n; i++) {

            a[i] = new HashMap<>();
            ch = stickers[i].toCharArray();

            for (char c : ch)
                if (t.containsKey(c))
                    a[i].put(c, a[i].getOrDefault(c, 0) + 1);
        }

        int count = 0;
        Set<Character> set = t.keySet();

        for (char c : set) {

            int x = 0, y = 0;

            for (int i = 0; i < n; i++)
                if (a[i].containsKey(c)) {
                    x++;
                    y = i;
                }

            if (x == 0) return -1;

            if (x == 1) {

                int z = (int) Math.ceil(t.get(c) * 1.0 / a[y].get(c));
                count += z;
                for (Character d : set) t.put(d, t.get(d) - z * a[y].getOrDefault(d, 0));
            }
        }

        Set<Character> set1 = new HashSet<>();
        set1.addAll(set);
        for (char c : set1) if (t.get(c) <= 0) t.remove(c);
        int x = 0;

        for (char c : set) {
            m.put(c, x);
            x += t.get(c);
        }

        for (char c : set)
            for (int j = 0; j < n; j++) {
                Integer k = a[j].get(c);
                if (k != null) b[j] = Math.max(b[j], (int) Math.ceil(t.get(c) * 1.0 / k));
            }

        return count + dfs(n, b, t, a);
    }

}
