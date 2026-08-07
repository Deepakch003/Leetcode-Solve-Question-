class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }

        int ans = 0;

        for (int ch = 0; ch < 26; ch++) {
            if (first[ch] == -1 || first[ch] == last[ch]) {
                continue;
            }

            HashSet<Character> set = new HashSet<>();

            for (int i = first[ch] + 1; i < last[ch]; i++) {
                set.add(s.charAt(i));
            }

            ans += set.size();
        }

        return ans;
    }
}