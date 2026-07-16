class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] left = new int[m][n];

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0)
                    continue;

                int width = left[i][j];

                for (int k = i; k >= 0 && width > 0; k--) {
                    width = Math.min(width, left[k][j]);
                    ans += width;
                }
            }
        }

        return ans;
    }
}