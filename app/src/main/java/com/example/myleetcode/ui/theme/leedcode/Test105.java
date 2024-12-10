package com.example.myleetcode.ui.theme.leedcode;


//  105. 从前序与中序遍历序列构造二叉树
 class TreeNode {
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
public class Test105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelp(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode buildTreeHelp(int[] preorder, int[] inorder, int preStar, int preEnd, int inoStar, int inoEnd) {
        if (preStar > preEnd || inoStar > inoEnd) return null;
        int rootVal = preorder[preStar];
        int count = 0;
        for (int i = inoStar; i <= inoEnd; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            count++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelp(preorder, inorder, preStar + 1, preStar + count, inoStar, inoStar + count);
        root.right = buildTreeHelp(preorder, inorder, preStar + count + 1, preEnd, inoStar + count + 1, inoEnd);
        return root;
    }
}
