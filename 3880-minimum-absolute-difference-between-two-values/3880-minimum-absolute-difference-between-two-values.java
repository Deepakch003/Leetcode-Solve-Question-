class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int lastOne = -1;
        int lastTwo = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                lastOne = i;
                if (lastTwo != -1) {
                    ans = Math.min(ans, i - lastTwo);
                }
            }

            if (nums[i] == 2) {
                lastTwo = i;
                if (lastOne != -1) {
                    ans = Math.min(ans, i - lastOne);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}