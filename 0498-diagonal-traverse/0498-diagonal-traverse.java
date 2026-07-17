class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int idx = 0;

        for (int d = 0; d < m + n - 1; d++) {

            ArrayList<Integer> temp = new ArrayList<>();

            int row = (d < n) ? 0 : d - n + 1;
            int col = (d < n) ? d : n - 1;

            while (row < m && col >= 0) {
                temp.add(mat[row][col]);
                row++;
                col--;
            }

            if (d % 2 == 0) {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    ans[idx++] = temp.get(i);
                }
            } else {
                for (int x : temp) {
                    ans[idx++] = x;
                }
            }
        }

        return ans;
    }
}