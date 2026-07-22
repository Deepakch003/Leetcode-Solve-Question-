import java.util.*;

class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {

        HashSet<String> exact = new HashSet<>();
        HashMap<String, String> lowerMap = new HashMap<>();
        HashMap<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            lowerMap.putIfAbsent(lower, word);

            String pattern = normalize(lower);
            vowelMap.putIfAbsent(pattern, word);
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exact.contains(query)) {
                ans[i] = query;
                continue;
            }

            String lower = query.toLowerCase();

            if (lowerMap.containsKey(lower)) {
                ans[i] = lowerMap.get(lower);
                continue;
            }

            String pattern = normalize(lower);

            if (vowelMap.containsKey(pattern)) {
                ans[i] = vowelMap.get(pattern);
            } else {
                ans[i] = "";
            }
        }

        return ans;
    }

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (isVowel(ch))
                sb.append('*');
            else
                sb.append(ch);
        }

        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u';
    }
}