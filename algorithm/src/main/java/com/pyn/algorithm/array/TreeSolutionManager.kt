package com.pyn.algorithm.array

import java.util.*

/**
 * 树
 * 树比链表稍微复杂，因为链表是线性数据结构，而树不是。 树的问题可以由 广度优先搜索 或 深度优先搜索 解决。
 */
object TreeSolutionManager {

    /**
     * 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     */
    fun maxDepth(root: TreeNode?): Int {
        // 递归
        /*return if (root == null) {
            0
        } else {
            var leftHeight = maxDepth(root.left)
            var rightHeight = maxDepth(root.right)
            Math.max(leftHeight, rightHeight) + 1
        }*/
        // 广度优先搜索
        if (root == null) {
            return 0
        }
        var queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.offer(root)
        var ans = 0
        while (!queue.isEmpty()) {
            var size = queue.size
            while (size > 0) {
                var node = queue.poll()
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
                size--
            }
            ans++
        }
        return ans
    }

    /**
     * 验证二叉搜索树
     *
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    fun isValidBST(root: TreeNode?): Boolean {

    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}