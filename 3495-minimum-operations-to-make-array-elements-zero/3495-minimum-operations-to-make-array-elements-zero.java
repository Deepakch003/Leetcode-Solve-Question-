class Solution {

    public long minOperations(int[][] queries) {
        long ans = 0;

        for (int[] q : queries) {
            long total = prefix(q[1]) - prefix(q[0] - 1);
            ans += (total + 1) / 2;
        }

        return ans;
    }

    private long prefix(long x) {
        if (x <= 0) return 0;

        long res = 0;
        long start = 1;
        int ops = 1;

        while (start <= x) {
            long end = Math.min(start * 4 - 1, x);
            res += (end - start + 1) * ops;
            start *= 4;
            ops++;
        }

        return res;
    }
}