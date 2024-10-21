package com.example.myleetcode.ui.theme.leedcode;

import com.example.myleetcode.ui.theme.tree.TreeNode;

public class Test101 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int countLeft = count(root.getLeft());
        int countRight = count(root.getRight());
        if (Math.abs(countLeft - countRight) > 1) return false;
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        int countLeft = count(root.getLeft());
        int countRight = count(root.getRight());
        return Math.max(countLeft, countRight) + 1;
    }
}
