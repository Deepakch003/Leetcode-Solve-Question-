class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int ans = 0;
        int prefix = 0;

        for (int x : nums) {
            if (x == 0) {
                int left = prefix;
                int right = total - prefix;

                if (left == right) {
                    ans += 2;
                } else if (Math.abs(left - right) == 1) {
                    ans += 1;
                }
            } else {
                prefix += x;
            }
        }

        return ans;
    }
}