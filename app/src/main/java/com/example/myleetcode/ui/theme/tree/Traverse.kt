package com.example.myleetcode.ui.theme.tree



object Traverse {

//    中序遍历
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        inorderTraversal(root, result)
        return result
    }

    private fun inorderTraversal(root: TreeNode?, result: ArrayList<Int>) {
        if (root == null) return
        inorderTraversal(root.left, result)
        result.add(root.`val`)
        inorderTraversal(root.right, result)
    }


//          前序遍历
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        preorderTraversal(root, result)
        return result
    }

    private fun preorderTraversal(root: TreeNode?, result: ArrayList<Int>) {
        if (root == null) return
        result.add(root.`val`)
        preorderTraversal(root.left, result)
        preorderTraversal(root.right, result)
    }


//    N叉树的前序遍历
    fun preorder(root: Node?): List<Int> {
        val result = ArrayList<Int>()
        preorder(root, result)
        return result
    }

    private fun preorder(root: Node?, result: ArrayList<Int>) {
        if (root == null) return
        result.add(root.`val`)
        root.children?.forEach {
            preorder(it, result)
        }
    }


//    在每个树行中寻找最大值
    fun largestValues(root: TreeNode?): List<Int> {
        val map = HashMap<Int, Int>()
        largestValues(root, 0, map)
        return map.values.toList()
    }

    private fun largestValues(root: TreeNode?, index: Int, map: HashMap<Int, Int>) {
        if (root == null) return
        val curMax = map[index] ?: Int.MIN_VALUE
        if (root.`val` >= curMax) map[index] = root.`val`
        largestValues(root.left, index + 1, map)
        largestValues(root.right, index + 1, map)
    }

//对称二叉树
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return false
        return isSymmetric(root.left, root.right)
    }

    private fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        if (left.`val` != right.`val`) return false
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
    }

//    层序遍历
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val que = ArrayDeque<TreeNode>()
        if (root == null) return result
        que.add(root)
        while (!que.isEmpty()) {
            val temp = ArrayList<Int>()
            val size = que.size
            for (i in 0 until size) {
                val node = que.removeFirst()
                temp.add(node.`val`)
                if (node.left != null) que.addLast(node.left!!)
                if (node.right != null) que.addLast(node.right!!)
            }
            result.add(temp)
        }
        return result
    }
}