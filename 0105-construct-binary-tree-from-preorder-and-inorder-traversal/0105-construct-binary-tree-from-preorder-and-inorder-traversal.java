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

    int preOrderIndex = 0;
    HashMap<Integer, Integer> inOrderHashMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderHashMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inOrderRootIndex = inOrderHashMap.get(rootValue);

        root.left = build(preOrder, inOrderStart, inOrderRootIndex-1);
        root.right = build(preOrder, inOrderRootIndex+1, inOrderEnd);

        return root;
    }
}