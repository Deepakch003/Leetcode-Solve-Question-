class Solution {

    private String s;
    private int k;
    private HashMap<Long, Integer> memo = new HashMap<>();

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        return dfs(0, 0, 0) + 1;
    }

    private int dfs(int idx, int mask, int changed) {
        if (idx == s.length()) return 0;

        long key = (((long) idx) << 27) | (((long) mask) << 1) | changed;
        if (memo.containsKey(key)) return memo.get(key);

        int ans = 0;

        
        int bit = 1 << (s.charAt(idx) - 'a');
        int newMask = mask | bit;

        if (Integer.bitCount(newMask) <= k) {
            ans = dfs(idx + 1, newMask, changed);
        } else {
            ans = 1 + dfs(idx + 1, bit, changed);
        }

    
        if (changed == 0) {
            for (int c = 0; c < 26; c++) {
                bit = 1 << c;
                newMask = mask | bit;

                if (Integer.bitCount(newMask) <= k) {
                    ans = Math.max(ans, dfs(idx + 1, newMask, 1));
                } else {
                    ans = Math.max(ans, 1 + dfs(idx + 1, bit, 1));
                }
            }
        }

        memo.put(key, ans);
        return ans;
    }
}