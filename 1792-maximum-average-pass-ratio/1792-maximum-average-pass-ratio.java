class Solution {

    class Node {
        int pass, total;
        double gain;

        Node(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.gain = calcGain(pass, total);
        }
    }

    private double calcGain(int p, int t) {
        return (double) (p + 1) / (t + 1) - (double) p / t;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain, a.gain)
        );

        for (int[] c : classes) {
            pq.offer(new Node(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            Node cur = pq.poll();
            cur.pass++;
            cur.total++;
            cur.gain = calcGain(cur.pass, cur.total);
            pq.offer(cur);
        }

        double ans = 0.0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            ans += (double) cur.pass / cur.total;
        }

        return ans / classes.length;
    }
}