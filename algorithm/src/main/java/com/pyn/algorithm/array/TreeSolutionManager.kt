package com.pyn.algorithm.array

import java.util.*
import kotlin.collections.ArrayList

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
        var root = root
        /*return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)*/
        // 中序遍历
        var stack: Deque<TreeNode> = LinkedList<TreeNode>()
        var inorder: Double = -Double.MAX_VALUE

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            if (root.`val` <= inorder) {
                return false
            }
            inorder = root.`val`.toDouble()
            root = root.right
        }
        return true
    }

    /**
     * 递归的方式
     */
    fun isValidBST(root: TreeNode?, minVal: Long, maxVal: Long): Boolean {
        if (root == null) {
            return true
        }

        if (root.`val` >= maxVal || root.`val` <= minVal) {
            return false
        }

        return isValidBST(root.left, minVal, root.`val`.toLong()) && isValidBST(
            root.right,
            root.`val`.toLong(),
            maxVal
        )
    }

    /**
     * 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isSymmetric(root.left, root.right)
    }

    /**
     * 递归法
     */
    fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }
        if (left == null || right == null || left.`val` != right.`val`) {
            return false
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
    }

    /**
     * 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // 边界判断
        if (root == null) {
            return ArrayList()
        }
        // 队列
        var queue: Queue<TreeNode> = LinkedList()
        var res: MutableList<MutableList<Int>> = ArrayList()
        queue.add(root)
        while (!queue.isEmpty()) {
            var levelNum = queue.size
            var subList: MutableList<Int> = ArrayList<Int>()
            for (i in 0 until levelNum) {
                // 出队
                var node: TreeNode = queue.poll()
                subList.add(node.`val`)
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
            }
            // 把每层的结点存储在res中
            res.add(subList)
        }
        return res
    }

    /**
     * 将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     */
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        // 中序遍历，总是选择中间位置左边的数字作为根节点
        return helper(nums, 0, nums.size - 1)
    }

    fun helper(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }
        // 总是选择中间位置左边的数字作为根结点
        var mid = (left + right) / 2

        var root = TreeNode(nums[mid])
        root.left = helper(nums, left, mid - 1)
        root.right = helper(nums, mid + 1, right)
        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}