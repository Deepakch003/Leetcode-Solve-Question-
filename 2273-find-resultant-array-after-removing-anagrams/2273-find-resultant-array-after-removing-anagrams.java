class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i - 1], words[i])) {
                ans.add(words[i]);
            }
        }

        return ans;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x, y);
    }
}