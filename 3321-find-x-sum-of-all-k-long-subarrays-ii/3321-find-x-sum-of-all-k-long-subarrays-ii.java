import java.util.*;

class Solution {

    class Pair {
        int freq;
        int val;

        Pair(int f, int v) {
            freq = f;
            val = v;
        }
    }

    TreeSet<Pair> top = new TreeSet<>((a, b) -> {
        if (a.freq != b.freq) return a.freq - b.freq;
        if (a.val != b.val) return a.val - b.val;
        return 0;
    });

    TreeSet<Pair> rest = new TreeSet<>((a, b) -> {
        if (a.freq != b.freq) return a.freq - b.freq;
        if (a.val != b.val) return a.val - b.val;
        return 0;
    });

    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Pair> where = new HashMap<>();

    long sum = 0;
    int x;

    private void erase(int val) {
        Pair p = where.get(val);
        if (p == null) return;

        if (top.remove(p)) {
            sum -= 1L * p.freq * p.val;
        } else {
            rest.remove(p);
        }
    }

    private void insert(int val) {
        int f = freq.get(val);
        if (f == 0) {
            where.remove(val);
            return;
        }

        Pair p = new Pair(f, val);
        where.put(val, p);

        if (top.isEmpty()) {
            top.add(p);
            sum += 1L * f * val;
        } else {
            Pair smallestTop = top.first();
            if (top.size() < x) {
                top.add(p);
                sum += 1L * f * val;
            } else if (compare(p, smallestTop) > 0) {
                top.pollFirst();
                sum -= 1L * smallestTop.freq * smallestTop.val;
                rest.add(smallestTop);

                top.add(p);
                sum += 1L * f * val;
            } else {
                rest.add(p);
            }
        }
        balance();
    }

    private int compare(Pair a, Pair b) {
        if (a.freq != b.freq)
            return Integer.compare(a.freq, b.freq);
        return Integer.compare(a.val, b.val);
    }

    private void balance() {

        while (top.size() < x && !rest.isEmpty()) {
            Pair p = rest.pollLast();
            top.add(p);
            sum += 1L * p.freq * p.val;
        }

        while (top.size() > x) {
            Pair p = top.pollFirst();
            sum -= 1L * p.freq * p.val;
            rest.add(p);
        }

        while (!top.isEmpty() && !rest.isEmpty()
                && compare(rest.last(), top.first()) > 0) {

            Pair a = top.pollFirst();
            Pair b = rest.pollLast();

            sum -= 1L * a.freq * a.val;
            sum += 1L * b.freq * b.val;

            top.add(b);
            rest.add(a);
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        this.x = x;

        int n = nums.length;
        long[] ans = new long[n - k + 1];

        for (int i = 0; i < k; i++) {
            int old = freq.getOrDefault(nums[i], 0);
            erase(nums[i]);
            freq.put(nums[i], old + 1);
            insert(nums[i]);
        }

        ans[0] = sum;

        for (int i = k; i < n; i++) {

            int out = nums[i - k];
            erase(out);
            freq.put(out, freq.get(out) - 1);
            insert(out);

            int in = nums[i];
            erase(in);
            freq.put(in, freq.getOrDefault(in, 0) + 1);
            insert(in);

            ans[i - k + 1] = sum;
        }

        return ans;
    }
}