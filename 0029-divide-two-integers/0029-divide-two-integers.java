class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend < 0) ^ (divisor < 0);

        /*
         * Wider positive magnitudes safely handle
         * Integer.MIN_VALUE and the required shifts.
         */
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        long quotient = 0;

        /*
         * Process larger powers of two first so the
         * quotient is built from its most significant bits.
         */
        for (int shift = 31; shift >= 0; shift--) {
            long chunk = divisorAbs << shift;

            if (chunk <= dividendAbs) {
                dividendAbs -= chunk;

                /*
                 * The accepted chunk represents divisor * 2^shift,
                 * so add that power of two to the quotient.
                 */
                quotient += 1L << shift;
            }
        }

        long result = negative ? -quotient : quotient;

        // Integer.MIN_VALUE / -1 exceeds Integer.MAX_VALUE.
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}

