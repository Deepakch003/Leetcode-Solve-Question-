class Solution {
    List<Integer> nums = new ArrayList<>();

    public int nextBeautifulNumber(int n) {
        generate(new int[10], 0);

        Collections.sort(nums);

        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) <= n)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums.get(left);
    }

    private void generate(int[] cnt, int num) {
        if (num > 1224444)
            return;

        if (num > 0 && isBalanced(cnt))
            nums.add(num);

        for (int d = 1; d <= 7; d++) {
            if (cnt[d] < d) {
                cnt[d]++;
                generate(cnt, num * 10 + d);
                cnt[d]--;
            }
        }
    }

    private boolean isBalanced(int[] cnt) {
        for (int d = 1; d <= 7; d++) {
            if (cnt[d] != 0 && cnt[d] != d)
                return false;
        }
        return true;
    }
}