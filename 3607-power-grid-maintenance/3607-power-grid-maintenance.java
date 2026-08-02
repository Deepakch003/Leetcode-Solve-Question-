import java.util.*;

class Solution {

    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;

            if (size[pa] < size[pb]) {
                int t = pa;
                pa = pb;
                pb = t;
            }

            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        DSU dsu = new DSU(c);

        for (int[] e : connections)
            dsu.union(e[0], e[1]);

        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);
            TreeSet<Integer> set = map.get(root);

            if (type == 1) {
                if (set.contains(x))
                    ans.add(x);
                else if (set.isEmpty())
                    ans.add(-1);
                else
                    ans.add(set.first());
            } else {
                set.remove(x);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);

        return res;
    }
}