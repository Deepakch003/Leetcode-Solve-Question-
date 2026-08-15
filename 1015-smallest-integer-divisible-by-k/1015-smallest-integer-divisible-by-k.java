class Solution {
    public int smallestRepunitDivByK(int k) {

        // Numbers ending in 0 or 5 can never be divisible
        // by k if they consist only of 1s
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int rem = 0;

        for (int len = 1; len <= k; len++) {

            rem = (rem * 10 + 1) % k;

            if (rem == 0) {
                return len;
            }
        }

        return -1;
    }
}