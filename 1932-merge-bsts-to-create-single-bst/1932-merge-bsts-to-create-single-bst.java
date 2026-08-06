/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    HashMap<Integer, TreeNode> map = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (TreeNode root : trees) {
            map.put(root.val, root);

            freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);

            if (root.left != null)
                freq.put(root.left.val, freq.getOrDefault(root.left.val, 0) + 1);

            if (root.right != null)
                freq.put(root.right.val, freq.getOrDefault(root.right.val, 0) + 1);
        }

        TreeNode root = null;

        for (TreeNode t : trees) {
            if (freq.get(t.val) == 1) {
                root = t;
                break;
            }
        }

        if (root == null)
            return null;

        map.remove(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        return map.isEmpty() ? root : null;
    }

    private boolean dfs(TreeNode node, long low, long high) {

        if (node == null)
            return true;

        if (node.val <= low || node.val >= high)
            return false;

        if (node.left == null && node.right == null && map.containsKey(node.val)) {
            TreeNode merge = map.remove(node.val);
            node.left = merge.left;
            node.right = merge.right;
        }

        return dfs(node.left, low, node.val) &&
               dfs(node.right, node.val, high);
    }
}