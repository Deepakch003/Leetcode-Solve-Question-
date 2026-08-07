import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[1] == y[1]) {
                return y[0] - x[0];
            }
            return x[1] - y[1];
        });

        int ans = 0;
        int a = -1, b = -1;

        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];

            if (l <= a) {
                continue;
            }

            if (l > b) {
                ans += 2;
                a = r - 1;
                b = r;
            } else {
                ans++;
                a = b;
                b = r;
            }
        }

        return ans;
    }
}