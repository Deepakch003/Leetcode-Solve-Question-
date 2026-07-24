class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = 0;
        int ans = 0;

        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                ans = f;
            } else if (f == maxFreq) {
                ans += f;
            }
        }

        return ans;
    }
}