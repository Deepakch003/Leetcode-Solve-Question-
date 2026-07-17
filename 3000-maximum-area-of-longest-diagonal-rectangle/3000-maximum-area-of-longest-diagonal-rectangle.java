class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0;
        int ans = 0;

        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];

            int diag = l * l + w * w;
            int area = l * w;

            if (diag > maxDiag) {
                maxDiag = diag;
                ans = area;
            } else if (diag == maxDiag) {
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }
}