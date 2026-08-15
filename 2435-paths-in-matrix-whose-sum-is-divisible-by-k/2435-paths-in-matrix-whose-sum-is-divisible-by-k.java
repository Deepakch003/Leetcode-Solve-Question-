class Solution {
    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1000000007;

        int[][][] dp = new int[m][n][k];

    
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int val = grid[i][j] % k;

                for (int r = 0; r < k; r++) {

                    int newR = (r + val) % k;

                    
                    if (i > 0) {
                        dp[i][j][newR] =
                            (dp[i][j][newR] + dp[i - 1][j][r])
                            % MOD;
                    }

                    
                    if (j > 0) {
                        dp[i][j][newR] =
                            (dp[i][j][newR] + dp[i][j - 1][r])
                            % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}