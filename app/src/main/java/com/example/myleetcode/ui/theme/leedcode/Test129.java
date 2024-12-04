package com.example.myleetcode.ui.theme.leedcode;

import java.util.Stack;

public class Test129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left == null && temp.right == null) {
                result += temp.val;
                continue;
            }
            if (temp.left != null) {
                temp.left.val = temp.left.val + temp.val * 10;
                stack.push(temp.left);
            }
            if (temp.right != null) {
                temp.right.val = temp.right.val + temp.val * 10;
                stack.push(temp.right);
            }
        }
        return result;
    }

    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        return dsf(root, 0);
    }

    private int dsf(TreeNode root, int preSum) {
        if (root == null) return 0;
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dsf(root.left, sum) + dsf(root.right, sum);
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
