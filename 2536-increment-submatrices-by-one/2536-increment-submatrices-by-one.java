class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n + 1];

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1];
            int r2 = q[2], c2 = q[3];

            for (int r = r1; r <= r2; r++) {
                diff[r][c1]++;
                if (c2 + 1 < n) {
                    diff[r][c2 + 1]--;
                }
            }
        }

        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += diff[i][j];
                ans[i][j] = sum;
            }
        }

        return ans;
    }
}