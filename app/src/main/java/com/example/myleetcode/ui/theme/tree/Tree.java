package com.example.myleetcode.ui.theme.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

// 非递归二叉树遍历

//    前序遍历
    public List<Integer> first(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return result;
    }

//    中序遍历
    public List<Integer> mid(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }


//    后序遍历
    public List<Integer> last(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || pre == root.right) {
                result.add(root.val);
                pre = root;
                root = null;
            } else {
                pre = root;
                root = root.right;
            }
        }
        return result;
    }



    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}



