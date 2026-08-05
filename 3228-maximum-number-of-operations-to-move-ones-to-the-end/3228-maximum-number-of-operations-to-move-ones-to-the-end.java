class Solution {
    public int maxOperations(String s) {
        int ones = 0;
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                if (i > 0 && s.charAt(i - 1) == '1') {
                    ans += ones;
                }
            }
        }

        return ans;
    }
}