class Solution {
    public int findSubstringInWraproundString(String p) {

        int[] dp = new int[26];
        int len = 0;

        for (int i = 0; i < p.length(); i++) {

            if (i > 0 &&
               (p.charAt(i) - p.charAt(i - 1) == 1 ||
               (p.charAt(i - 1) == 'z' && p.charAt(i) == 'a'))) {
                len++;
            } else {
                len = 1;
            }

            int idx = p.charAt(i) - 'a';
            dp[idx] = Math.max(dp[idx], len);
        }

        int ans = 0;
        for (int x : dp)
            ans += x;

        return ans;
    }
}