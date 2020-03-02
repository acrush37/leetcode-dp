package hard;

import java.util.*;

/*
    Given a m * n matrix seats  that represent seats distributions in a classroom.
    If a seat is broken, it is denoted by '#' character otherwise it is denoted by a '.' character.

    Students can see the answers of those sitting next to the left, right, upper left and upper
    right, but he cannot see the answers of the student sitting directly in front or behind him.

    Return the maximum number of students that can take the exam together without any cheating being possible..
 */
public class MaximumStudentsTakingExam {

    private Set<Integer>[] t;

    private Map<String, Integer> f = new HashMap<>();

    public static void main(String... args) {

        char[][] seats = {{'#', '.', '.', '.', '#'}, {'.', '#', '.', '#', '.'},
                {'.', '.', '#', '.', '.'}, {'.', '#', '.', '#', '.'}, {'#', '.', '.', '.', '#'}};
        MaximumStudentsTakingExam maximumStudentsTakingExam = new MaximumStudentsTakingExam();
        System.out.println(maximumStudentsTakingExam.maxStudents(seats));
    }

    private int dfs(int n, String s) {

        Integer x = f.get(s);
        if (x != null) return x;
        char[] c = s.toCharArray();
        x = 0;

        for (int i = 0; i < n; i++)
            if (c[i] == '.') {

            c[i] = '#';
            x = Math.max(x, dfs(n, new String(c)));
            for (int j : t[i]) if (c[j] == '.') c[j] = '#';
            x = Math.max(x, 1 + dfs(n, new String(c)));
        }

        f.put(s, x);
        return x;
    }

    public int maxStudents(char[][] seats) {

        List<int[]> a = new ArrayList<>();
        int m = seats.length, n = seats[0].length;

        for (int i = 0; i < m ;i++)
            for (int j = 0; j < n; j++)
                if (seats[i][j] == '.')
                    a.add(new int[]{i, j});

        if ((n = a.size()) <= 1) return n;
        t = new Set[n];
        String s = "";

        for (int i = 0; i < n; i++) {

            s += '.';
            t[i] = new HashSet<>();
            int x = a.get(i)[0], y = a.get(i)[1];

            for (int j = 0; j < n; j++) {
                int u = a.get(j)[0], v = a.get(j)[1];
                if ((u == x || u == x+1) && (v == y-1 || v == y+1)) t[i].add(j);
            }
        }

        return dfs(n, s);
    }

}
