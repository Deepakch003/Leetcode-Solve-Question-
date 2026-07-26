import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        
        HashMap<Integer, Integer> lastRain = new HashMap<>();

    
        TreeSet<Integer> sunnyDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                sunnyDays.add(i);
                ans[i] = 1;
            } else {
                ans[i] = -1;
                int lake = rains[i];

                if (lastRain.containsKey(lake)) {
                    
                    Integer dryDay = sunnyDays.higher(lastRain.get(lake));

                    if (dryDay == null) {
                        return new int[0];
                    }

                    ans[dryDay] = lake;
                    sunnyDays.remove(dryDay);
                }

                lastRain.put(lake, i);
            }
        }

        return ans;
    }
}