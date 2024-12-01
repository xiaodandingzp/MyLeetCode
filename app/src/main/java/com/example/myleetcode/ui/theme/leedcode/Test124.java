package com.example.myleetcode.ui.theme.leedcode;

public class Test124 {
    static int result = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumHelp(root);
        return result;
    }

    public static int maxPathSumHelp(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(maxPathSumHelp(root.left), 0);
        int rightMax = Math.max(maxPathSumHelp(root.right), 0);

        result = Math.max(result, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }



    public class TreeNode {
        int val;
        TreeNode left;
     TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
