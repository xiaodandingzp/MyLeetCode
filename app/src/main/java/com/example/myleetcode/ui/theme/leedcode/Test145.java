package com.example.myleetcode.ui.theme.leedcode;


// 145. 二叉树的后序遍历


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
//        postorderTraversalHelp(root, result);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                result.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    private void postorderTraversalHelp(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderTraversalHelp(root.left, result);
        postorderTraversalHelp(root.right, result);
        result.add(root.val);
    }
}
