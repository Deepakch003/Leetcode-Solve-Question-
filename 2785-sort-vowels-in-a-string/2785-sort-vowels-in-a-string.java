import java.util.*;

class Solution {
    public String sortVowels(String s) {

        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a','e','i','o','u',
                'A','E','I','O','U'));

        List<Character> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                list.add(ch);
            }
        }

        Collections.sort(list);

        char[] ans = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < ans.length; i++) {
            if (vowels.contains(ans[i])) {
                ans[i] = list.get(idx++);
            }
        }

        return new String(ans);
    }
}