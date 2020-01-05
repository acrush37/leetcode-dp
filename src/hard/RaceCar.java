package hard;

import java.util.*;

/*
    Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
    Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).

    When you get an instruction "A", your car does the following: position += speed, speed *= 2.
    When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 ,
    otherwise speed = 1.  (Your position stays the same.)

    For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
    Now for some target position, say the length of the shortest sequence of instructions to get there.
 */
public class RaceCar {

    public static void main(String... args) {

        RaceCar raceCar = new RaceCar();
        System.out.println(raceCar.racecar(931));
    }

    public int racecar(int target) {

        Set<String> t = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1, 0});

        while (!q.isEmpty()) {

            int[] x = q.poll();

            if (x[0] < target || x[1] < 0) {

                int a = x[0] + x[1];
                if (a == target) return 1 + x[2];
                int b = x[1] << 1;
                String s = a + "|" + b;

                if (!t.contains(s)) {
                    t.add(s);
                    q.offer(new int[]{a, b, 1 + x[2]});
                }
            }

            if (x[0] >= -30) {

                int b = x[1] > 0 ? -1 : 1;
                String s = x[0] + "|" + b;

                if (!t.contains(s)) {
                    t.add(s);
                    q.offer(new int[]{x[0], b, 1 + x[2]});
                }
            }
        }

        return 0;
    }

}
