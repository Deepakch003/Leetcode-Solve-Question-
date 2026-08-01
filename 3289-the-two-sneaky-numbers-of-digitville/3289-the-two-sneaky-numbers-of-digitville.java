class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[100];
        int[] ans = new int[2];
        int idx = 0;

        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 2) {
                ans[idx++] = num;
            }
        }

        return ans;
    }
}