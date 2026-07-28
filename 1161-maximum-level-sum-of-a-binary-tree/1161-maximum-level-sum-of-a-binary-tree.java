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
    public int maxLevelSum(TreeNode root) {
        int maxLevelSum = 0;
        int maxSum = Integer.MIN_VALUE;

        if (root == null) {
            return maxLevelSum;
        }

        Deque<TreeNode> qDeque = new ArrayDeque<>();
        qDeque.offer(root);

        int level = 1;
        while (!qDeque.isEmpty()) {
            int sum = 0;
            int size = qDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = qDeque.poll();
                sum+=current.val;
                if (current.left!=null) {
                    qDeque.offer(current.left);
                }

                if (current.right!=null) {
                    qDeque.offer(current.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevelSum = level;
            }
            level++;
        }


        return maxLevelSum;
    }
}