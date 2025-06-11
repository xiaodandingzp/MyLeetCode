package com.example.myleetcode.ui.theme.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeTest {

//    中序遍历-非递归 左根右
    List<Integer> mid(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.getLeft();
            }
            root = stack.pop();
            result.add(root.getVal());
            root = root.getRight();
        }
        return result;
    }

    //    前序遍历-非递归 根左右
    List<Integer> first(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.getVal());
            if (root.getRight() != null) stack.push(root.getRight());
            if (root.getLeft() != null) stack.push(root.getLeft());
        }
        return result;
    }

    //    后序遍历-非递归 根左右
    public List<Integer> last(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            if (root.getRight() == null || pre == root.getRight()) {
                result.add(root.getVal());
                pre = root;
                root = null;
            } else  {
                pre = root;
                root = root.getRight();
            }
        }
    }
}
