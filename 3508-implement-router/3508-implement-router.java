import java.util.*;

class Router {

    private int limit;
    private HashSet<Long> vis;
    private ArrayDeque<int[]> queue;
    private HashMap<Integer, List<Integer>> timeMap;
    private HashMap<Integer, Integer> idx;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        vis = new HashSet<>();
        queue = new ArrayDeque<>();
        timeMap = new HashMap<>();
        idx = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {

        long key = hash(source, destination, timestamp);

        if (vis.contains(key))
            return false;

        if (queue.size() == limit)
            forwardPacket();

        vis.add(key);
        queue.offer(new int[]{source, destination, timestamp});

        timeMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {

        if (queue.isEmpty())
            return new int[0];

        int[] packet = queue.poll();

        int source = packet[0];
        int destination = packet[1];
        int timestamp = packet[2];

        vis.remove(hash(source, destination, timestamp));

        idx.put(destination, idx.getOrDefault(destination, 0) + 1);

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {

        List<Integer> list = timeMap.getOrDefault(destination, Collections.emptyList());

        int start = idx.getOrDefault(destination, 0);

        int left = lowerBound(list, startTime, start);
        int right = lowerBound(list, endTime + 1, start);

        return right - left;
    }

    private int lowerBound(List<Integer> list, int target, int from) {

        int l = from;
        int r = list.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    private long hash(int source, int destination, int timestamp) {
        return ((long) source << 46) | ((long) destination << 29) | timestamp;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */