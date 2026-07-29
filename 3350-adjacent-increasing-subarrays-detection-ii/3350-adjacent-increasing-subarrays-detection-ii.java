class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int prev = 0;
        int cur = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cur++;
            } else {
                prev = cur;
                cur = 1;
            }

            ans = Math.max(ans, cur / 2);
            ans = Math.max(ans, Math.min(prev, cur));
        }

        return ans;
    }
}