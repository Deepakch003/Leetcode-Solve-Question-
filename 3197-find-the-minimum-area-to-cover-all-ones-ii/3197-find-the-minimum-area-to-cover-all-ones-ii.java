class Solution {
    private int[][] grid;
    private int m, n;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int ans = Integer.MAX_VALUE;

        
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                ans = Math.min(ans,
                        area(0, 0, i, n - 1)
                                + area(i + 1, 0, j, n - 1)
                                + area(j + 1, 0, m - 1, n - 1));
            }
        }

    
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                ans = Math.min(ans,
                        area(0, 0, m - 1, i)
                                + area(0, i + 1, m - 1, j)
                                + area(0, j + 1, m - 1, n - 1));
            }
        }

        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {

                
                ans = Math.min(ans,
                        area(0, 0, i, j)
                                + area(0, j + 1, i, n - 1)
                                + area(i + 1, 0, m - 1, n - 1));

                
                ans = Math.min(ans,
                        area(0, 0, i, n - 1)
                                + area(i + 1, 0, m - 1, j)
                                + area(i + 1, j + 1, m - 1, n - 1));
            }
        }

    
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m - 1; i++) {

            
                ans = Math.min(ans,
                        area(0, 0, i, j)
                                + area(i + 1, 0, m - 1, j)
                                + area(0, j + 1, m - 1, n - 1));

                
                ans = Math.min(ans,
                        area(0, 0, m - 1, j)
                                + area(0, j + 1, i, n - 1)
                                + area(i + 1, j + 1, m - 1, n - 1));
            }
        }

        return ans;
    }

    private int area(int r1, int c1, int r2, int c2) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = -1;
        int right = -1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        
        if (bottom == -1) return 0;

        return (bottom - top + 1) * (right - left + 1);
    }
}