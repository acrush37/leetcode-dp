package medium;

import java.util.Arrays;

/*
    You are given a series of video clips from a sporting event that lasted T seconds.
    These video clips can be overlapping with each other and have varied lengths.

    Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].
    We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].

    Return the minimum number of clips needed so that we can cut the clips into segments
    that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.
 */
public class VideoStitching {

    public static void main(String... args) {

        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        VideoStitching videoStitching = new VideoStitching();
        System.out.println(videoStitching.videoStitching(clips, 10));
    }

    public int videoStitching(int[][] clips, int T) {

        int p = 0, k = 0, result = 0, n = clips.length;
        Arrays.sort(clips, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        while (true) {

            int j = 0, max = k;

            for (int i = p; i < n; i++)
                if (clips[i][0] > k) break;
                else if (clips[i][1] > max) max = clips[j = i][1];

            if (max == k) return -1;
            result++;
            if ((k = max) >= T) return result;
            p = j+1;
        }
    }

}
