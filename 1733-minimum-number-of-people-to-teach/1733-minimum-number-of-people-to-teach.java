import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        List<Set<Integer>> know = new ArrayList<>();

        for (int[] lang : languages) {
            Set<Integer> set = new HashSet<>();
            for (int x : lang) {
                set.add(x);
            }
            know.add(set);
        }

        Set<Integer> affected = new HashSet<>();

        
        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;

            boolean common = false;
            for (int lang : know.get(u)) {
                if (know.get(v).contains(lang)) {
                    common = true;
                    break;
                }
            }

            if (!common) {
                affected.add(u);
                affected.add(v);
            }
        }

        int ans = Integer.MAX_VALUE;

        
        for (int lang = 1; lang <= n; lang++) {
            int teach = 0;

            for (int user : affected) {
                if (!know.get(user).contains(lang)) {
                    teach++;
                }
            }

            ans = Math.min(ans, teach);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}