package hard;

/*
    Given a positive integer n, return the number of all possible attendance records with length n,
    which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

    A student attendance record is a string that only contains the following three characters:
    'A' : Absent. 'L' : Late. 'P' : Present.

    A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 */
public class StudentAttendanceRecordII {

    public static void main(String... args) {

        StudentAttendanceRecordII studentAttendanceRecordII = new StudentAttendanceRecordII();
        System.out.println(studentAttendanceRecordII.checkRecord(5));
    }

    public int checkRecord(int n) {

        if (n == 1) return 3;
        if (n == 2) return 8;
        int mod = 1000000007;
        int[] a = new int[n];
        int[] l = new int[n];
        int[] p = new int[n];
        int[] x = new int[n];
        int[] y = new int[n];
        p[0] = l[0] = a[0] = 1;
        x[1] = y[1] = a[1] = 2;
        p[1] = l[1] = 3;
        x[0] = y[0] = 1;

        for (int i = 2; i < n; i++) {

            y[i] = (x[i-1] + x[i-2]) % mod;
            a[i] = x[i] = (x[i-1] + y[i-1]) % mod;
            p[i] = ((p[i-1] + l[i-1]) % mod + a[i-1]) % mod;
            l[i] = ((p[i-1] + a[i-1]) % mod + (p[i-2] + a[i-2]) % mod) % mod;
        }

        return ((a[n-1] + l[n-1]) % mod + p[n-1]) % mod;
    }

}
