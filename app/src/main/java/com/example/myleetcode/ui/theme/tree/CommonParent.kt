package com.example.myleetcode.ui.theme.tree

object CommonParent {

//    查找树的公共祖先
    fun findCommonParent(root: TreeNode?, first: TreeNode, second: TreeNode): TreeNode? {
        if (first == root || second == root || root == null) return root
        val left = findCommonParent(root.left, first, second)
        val right = findCommonParent(root.right, first, second)
        if (left != null && right != null) return root
        if (left != null) return left
        if (right != null) return right
        return null
    }
}