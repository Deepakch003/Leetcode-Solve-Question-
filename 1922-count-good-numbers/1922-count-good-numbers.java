class Solution {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = power(5, evenPositions);
        long oddWays = power(4, oddPositions);

        return (int)((evenWays * oddWays) % MOD);
    }

    public long power(long base, long exponent) {

        long ans = 1;

        while (exponent > 0) {

            
            if (exponent % 2 == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;

            exponent = exponent / 2;
        }

        return ans;
    }
}