class Solution {
    public int maxSumDivThree(int[] nums) {

        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {


            int[] old = dp.clone();

            for (int r = 0; r < 3; r++) {

                if (old[r] == Integer.MIN_VALUE) {
                    
                    continue;
                }

                int newRemainder = (r + num % 3) % 3;

                dp[newRemainder] = Math.max(
                    dp[newRemainder],
                    old[r] + num
                );
            }
        }

        return dp[0];
    }
}