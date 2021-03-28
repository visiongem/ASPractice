package com.pyn.algorithm.array

/**
 * 链表 简单算法
 */
object ListSolutionManager {

    /**
     * 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     * 链表至少包含两个节点
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     */
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`!!
        node?.next = node?.next?.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * 删除链表的倒数第N个节点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head
        // fast移动n步
        for (index in 0 until n) {
            fast = fast?.next
        }
        // 如果fast为空，表示删除的事头结点
        if (fast == null){
            return head?.next
        }

        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
        // 这里最终slow不是倒数第n个节点，他是倒数第n+1个节点
        // 他的下一个结点是倒数第n个节点，所以删除的事他的下一个结点
        slow?.next = slow?.next?.next
        return head
    }

    /**
     * 反转一个单链表。
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    fun reverseList(head: ListNode?): ListNode? {

    }

    /**
     * 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    }

    /**
     * 回文链表
     * 请判断一个链表是否为回文链表。
     */
    fun isPalindrome(head: ListNode?): Boolean {

    }

    /**
     * 环形链表
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     */
    fun hasCycle(head: ListNode?): Boolean {

    }
}
