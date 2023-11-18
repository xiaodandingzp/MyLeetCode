package com.example.myleetcode.ui.theme.tree


/**
 * 不管找什么，都要遍历树，可以是遍历整颗树或者遍历树的一条边。
 * 遍历树的方式：前序遍历，中序遍历，后序遍历
 * 前序遍历：根左右
 * 中序遍历：左根右
 * 后序遍历：左右根
 *
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}