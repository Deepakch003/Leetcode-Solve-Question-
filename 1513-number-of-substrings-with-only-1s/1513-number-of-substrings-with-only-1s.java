class Solution {
    public int numSub(String s) {
        long ans = 0;
        long cnt = 0;
        int MOD = 1_000_000_007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
                ans = (ans + cnt) % MOD;
            } else {
                cnt = 0;
            }
        }

        return (int) ans;
    }
}