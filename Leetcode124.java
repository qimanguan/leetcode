class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return max;
    }
    private int maxSum (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = maxSum(node.left);
        int rightMax = maxSum(node.right);
        max = Math.max(max, Math.max(leftMax, 0) + Math.max(rightMax, 0) + node.val);
        return Math.max(0, Math.max(leftMax, rightMax)) + node.val;
    }
}