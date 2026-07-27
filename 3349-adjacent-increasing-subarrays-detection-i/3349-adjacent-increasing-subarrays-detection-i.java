class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        int n = nums.size();
        int i = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n && nums.get(j) > nums.get(j - 1)) {
                j++;
            }

            int len = j - i;

            if (len / 2 >= k) return true;
            if (Math.min(prev, len) >= k) return true;

            prev = len;
            i = j;
        }

        return false;
    }
}