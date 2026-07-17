class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(grid[i][j]);
            }
        }

    
        for (int key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            if (key >= 0)
                list.sort(Collections.reverseOrder()); 
            else
                Collections.sort(list); 
        }

        
        HashMap<Integer, Integer> idx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int k = idx.getOrDefault(key, 0);
                grid[i][j] = map.get(key).get(k);
                idx.put(key, k + 1);
            }
        }

        return grid;
    }
}