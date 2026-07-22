import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        HashSet<Character> broken = new HashSet<>();

        for (char ch : brokenLetters.toCharArray()) {
            broken.add(ch);
        }

        int count = 0;

        String[] words = text.split(" ");

        for (String word : words) {
            boolean ok = true;

            for (char ch : word.toCharArray()) {
                if (broken.contains(ch)) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                count++;
            }
        }

        return count;
    }
}