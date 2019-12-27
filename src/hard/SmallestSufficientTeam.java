package hard;

import java.util.*;
import java.util.stream.Collectors;

/*
    In a project, you have a list of required skills req_skills, and a list of people.
    The i-th person people[i] contains a list of skills that person has.

    Consider a sufficient team: a set of people such that for every required skill in req_skills, there is
    at least one person in the team who has that skill.  We can represent these teams by the index of each
    person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].

    Return any sufficient team of the smallest possible size, represented by the index of each person.
 */
public class SmallestSufficientTeam {

    public static void main(String... args) {

        String[] req_skills = {"mmcmnwacnhhdd","vza","mrxyc"};
        List<List<String>> people = Arrays.asList(Arrays.asList("mmcmnwacnhhdd"),
                Arrays.asList(), Arrays.asList(), Arrays.asList("vza","mrxyc"));
        SmallestSufficientTeam smallestSufficientTeam = new SmallestSufficientTeam();
        System.out.println(smallestSufficientTeam.smallestSufficientTeam(req_skills, people));
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        int m = 0, n = people.size(), r = req_skills.length;
        Map<String, Integer> g = new HashMap<>();
        for (String x : req_skills) g.put(x, m++);
        List<Integer> t1 = new ArrayList<>();
        Set<Integer>[] f = new Set[n];

        for (int i = 0; i < n; i++) {

            int x = 0, y = -1;

            for (int j = 0; j < n; j++)
                if (!t1.contains(j)) {

                    int z = people.get(j).size();

                    if (z > y) {
                        y = z;
                        x = j;
                    }
                }

            t1.add(x);
        }

        for (int x : t1) {

            List<String> y = people.get(x);

            if (!y.isEmpty()) {
                f[x] = new HashSet<>();
                for (String z : y) f[x].add(g.get(z));
            }
        }

        List<Integer> t = new ArrayList<>();
        t.add(t1.get(0));
        n = t1.size();

        for (int i = 1; i < n; i++) {

            boolean flag = true;
            int x = t1.get(i);
            if (f[x] == null) continue;

            for (int j = 0; j < i; j++) {

                int y = t1.get(j);
                int z = 0;
                for (int a : f[x]) if (f[y].contains(a)) z++;

                if (z == f[x].size()) {
                    flag = false;
                    break;
                }
            }

            if (flag) t.add(x);
        }

        int[] w = new int[n];
        Set<Integer> h = new HashSet<>();
        Queue<Object[]> q = new LinkedList<>();
        for (int i = 0; i < t.size(); i++) w[t.get(i)] = i;
        q.offer(new Object[]{0, new HashSet<>(), new HashSet<>()});

        while (!q.isEmpty()) {

            Object[] o = q.poll();
            int s = (int) o[0];
            Set<Integer> a = (Set<Integer>) o[1];
            Set<Integer> b = (Set<Integer>) o[2];

            for (int x : t)
                if (!a.contains(x)) {

                    int p = s + (1 << w[x]);
                    if (h.contains(p)) continue;
                    Set<Integer> c = new HashSet<>();
                    c.addAll(a);
                    c.add(x);
                    Set<Integer> d = new HashSet<>();
                    d.addAll(b);
                    d.addAll(f[x]);

                    if (d.size() == r) {

                        int k = c.size();
                        int[] result = new int[k];
                        for (int z : c) result[--k] = z;
                        return result;
                    }

                    h.add(p);
                    q.offer(new Object[]{p, c, d});
                }
        }

        return null;
    }

}
