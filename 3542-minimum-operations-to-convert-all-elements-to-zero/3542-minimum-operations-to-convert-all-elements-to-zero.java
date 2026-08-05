class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int x : nums) {
            while (!stack.isEmpty() && stack.peek() > x) {
                stack.pop();
            }

            if (x == 0) continue;

            if (stack.isEmpty() || stack.peek() < x) {
                stack.push(x);
                ans++;
            }
        }

        return ans;
    }
}