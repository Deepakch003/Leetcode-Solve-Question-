import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        String ans = s;

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }

        
            char[] arr = cur.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] = (char) (((arr[i] - '0' + a) % 10) + '0');
            }
            String add = new String(arr);

            if (visited.add(add)) {
                queue.offer(add);
            }

            
            String rotate = cur.substring(cur.length() - b) +
                            cur.substring(0, cur.length() - b);

            if (visited.add(rotate)) {
                queue.offer(rotate);
            }
        }

        return ans;
    }
}