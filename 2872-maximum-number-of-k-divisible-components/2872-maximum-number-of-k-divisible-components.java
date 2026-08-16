class Solution {
    int count = 0;
    long k;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;

        
        java.util.ArrayList<Integer>[] graph = new java.util.ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(0, -1, graph, values);

        return count;
    }

    long dfs(int node, int parent,
             java.util.ArrayList<Integer>[] graph,
             int[] values) {

        long sum = values[node];

        for (int next : graph[node]) {

            if (next == parent) {
                continue;
            }

            sum += dfs(next, node, graph, values);
        }

        
        if (sum % k == 0) {
            count++;
            return 0;
        }

        return sum;
    }
}