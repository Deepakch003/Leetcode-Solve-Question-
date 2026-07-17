class Solution {
    int m, n;
    int[] dirs = {1, 1, -1, -1, 1};
    Integer[][][][] dp;

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Integer[m][n][4][2];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, dfs(grid, i, j, d, 1) + 1);
                    }
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int dir, int turn) {
        if (dp[i][j][dir][turn] != null)
            return dp[i][j][dir][turn];

        int x = i + dirs[dir];
        int y = j + dirs[dir + 1];

        int target = (grid[i][j] == 1) ? 2 : (2 - grid[i][j]);

        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != target) {
            return dp[i][j][dir][turn] = 0;
        }

        int res = dfs(grid, x, y, dir, turn);

        if (turn == 1) {
            res = Math.max(res, dfs(grid, x, y, (dir + 1) % 4, 0));
        }

        return dp[i][j][dir][turn] = res + 1;
    }
}