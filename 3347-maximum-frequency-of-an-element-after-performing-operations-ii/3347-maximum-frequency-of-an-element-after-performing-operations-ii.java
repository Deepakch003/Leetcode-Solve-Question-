class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Long, Integer> events = new TreeMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            events.put((long)x - k,
                    events.getOrDefault((long)x - k, 0) + 1);
            events.put((long)x + k + 1,
                    events.getOrDefault((long)x + k + 1, 0) - 1);

            events.putIfAbsent((long)x, events.getOrDefault((long)x, 0));
        }

        int active = 0;
        int ans = 1;

        for (Map.Entry<Long, Integer> entry : events.entrySet()) {
            long pos = entry.getKey();
            active += entry.getValue();

            int same = freq.getOrDefault((int)pos, 0);
            ans = Math.max(ans,
                    Math.min(active, same + numOperations));
        }

        return ans;
    }
}