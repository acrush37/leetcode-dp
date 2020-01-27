package hard;

/*
    You want to schedule a list of jobs in d days. Jobs are dependent
    (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).

    You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties
    of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.

    Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].

    Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */
public class MinimumDifficultyOfJobSchedule {

    public static void main(String... args) {

        int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
        MinimumDifficultyOfJobSchedule minimumDifficultyOfJobSchedule = new MinimumDifficultyOfJobSchedule();
        System.out.println(minimumDifficultyOfJobSchedule.minDifficulty(jobDifficulty, 2));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        if (n < d) return -1;
        int m = n - d;
        int[][] t = new int[n][n];
        int[][] f = new int[n][2];

        for (int i = 0; i < n; i++) {
            t[i][i] = jobDifficulty[i];
            for (int j = i+1; j < n; j++) t[i][j] = Math.max(t[i][j-1], jobDifficulty[j]);
        }

        for (int i = 0; i < n; i++) f[i][0] = t[0][i];
        int p = 0;

        for (int k = 1; k < d; k++) {

            int q = (p = k & 1) ^ 1;

            for (int i = k; i <= m+k; i++) {
                f[i][p] = Integer.MAX_VALUE;
                for (int j = k-1; j < i; j++) f[i][p] = Math.min(f[i][p], f[j][q] + t[j+1][i]);
            }
        }

        return f[n-1][p];
    }

}
