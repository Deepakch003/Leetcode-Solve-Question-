import java.util.*;

class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            ans.add(nums[i]);
            k--;
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}