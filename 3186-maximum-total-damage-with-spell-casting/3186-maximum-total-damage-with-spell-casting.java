class Solution {
    private long[] dp;
    private int[] values;
    private long[] gain;
    private int n;

    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int x : power) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        n = map.size();
        values = new int[n];
        gain = new long[n];

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            values[idx] = entry.getKey();
            gain[idx] = 1L * entry.getKey() * entry.getValue();
            idx++;
        }

        dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(0);
    }

    private long solve(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        long skip = solve(i + 1);

        int next = upperBound(values[i] + 2);
        long take = gain[i] + solve(next);

        return dp[i] = Math.max(skip, take);
    }

    private int upperBound(int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (values[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}