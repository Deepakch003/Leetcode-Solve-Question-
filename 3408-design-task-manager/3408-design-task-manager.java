import java.util.*;

class TaskManager {

    private Map<Integer, int[]> map;
    private TreeSet<int[]> set;

    public TaskManager(List<List<Integer>> tasks) {

        map = new HashMap<>();

        set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];     
            }
            return b[1] - a[1];         
        });

        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{userId, priority});
        set.add(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {

        int[] info = map.get(taskId);
        int userId = info[0];
        int oldPriority = info[1];

        set.remove(new int[]{oldPriority, taskId});

        set.add(new int[]{newPriority, taskId});
        map.put(taskId, new int[]{userId, newPriority});
    }

    public void rmv(int taskId) {

        int[] info = map.remove(taskId);
        int priority = info[1];

        set.remove(new int[]{priority, taskId});
    }

    public int execTop() {

        if (set.isEmpty()) {
            return -1;
        }

        int[] top = set.pollFirst();

        int priority = top[0];
        int taskId = top[1];

        int[] info = map.remove(taskId);

        return info[0];
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId, taskId, priority);
 * obj.edit(taskId, newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */