import java.util.Arrays;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 0;
        int prev = Integer.MIN_VALUE;

        for (int x : nums) {
            int candidate = Math.max(x - k, prev + 1);

            if (candidate <= x + k) {
                ans++;
                prev = candidate;
            }
        }

        return ans;
    }
}