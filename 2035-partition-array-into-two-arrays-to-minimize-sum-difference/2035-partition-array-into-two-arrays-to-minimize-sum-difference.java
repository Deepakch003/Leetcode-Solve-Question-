import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<Integer>[] leftSum = new ArrayList[n + 1];
        List<Integer>[] rightSum = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSum[i] = new ArrayList<>();
            rightSum[i] = new ArrayList<>();
        }

        int total = 0;
        for (int x : nums) total += x;

        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += left[i];
                    bits++;
                }
            }
            leftSum[bits].add(sum);
        }

        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += right[i];
                    bits++;
                }
            }
            rightSum[bits].add(sum);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSum[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> L = leftSum[k];
            List<Integer> R = rightSum[n - k];

            for (int s1 : L) {
                int target = total / 2 - s1;
                int idx = Collections.binarySearch(R, target);

                if (idx < 0) idx = -idx - 1;

                if (idx < R.size()) {
                    int selected = s1 + R.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * selected));
                }

                if (idx > 0) {
                    int selected = s1 + R.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * selected));
                }
            }
        }

        return ans;
    }
}