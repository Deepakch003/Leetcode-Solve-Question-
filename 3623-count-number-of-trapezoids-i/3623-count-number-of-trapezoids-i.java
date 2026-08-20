import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {

        final long MOD = 1_000_000_007L;

        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] point : points) {
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        long ans = 0;
        long previousPairs = 0;

        for (int count : map.values()) {

            
            
            long pairs = (long) count * (count - 1) / 2;

        
            ans = (ans + pairs * previousPairs) % MOD;

            previousPairs += pairs;
        }

        return (int) ans;
    }
}