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

    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root==null || (root.left == null && root.right == null)) {
            return 0;
        }

        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    public void dfs(TreeNode root, boolean cameFromLeft, int length) {
        if (root == null) {
            return;
        }

        max = Math.max(max, length);
        if (cameFromLeft) {
            dfs(root.left, true, 1);
            dfs(root.right, false, length+1);   
        } else {
            dfs(root.left, true, length+1);
            dfs(root.right, false, 1);   
        }
    }
}