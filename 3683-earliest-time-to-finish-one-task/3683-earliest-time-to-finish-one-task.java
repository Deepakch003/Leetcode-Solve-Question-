class Solution {
    public int earliestTime(int[][] tasks) {
        int ans = Integer.MAX_VALUE;

        for (int[] task : tasks) {
            ans = Math.min(ans, task[0] + task[1]);
        }

        return ans;
    }
}