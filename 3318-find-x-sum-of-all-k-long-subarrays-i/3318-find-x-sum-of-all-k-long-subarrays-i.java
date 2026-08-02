import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            
            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0;
            int cnt = 0;
            for (int[] p : list) {
                if (cnt == x) break;
                sum += p[0] * p[1];
                cnt++;
            }

            ans[i] = sum;
        }

        return ans;
    }
}