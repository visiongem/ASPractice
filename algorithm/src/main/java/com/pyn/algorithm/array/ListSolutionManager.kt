package com.pyn.algorithm.array

import java.util.*
import kotlin.collections.HashSet

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
        if (fast == null) {
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
        // 递归
        /*if (head?.next == null) {
            return head
        }

        var newHead = reverseList(head.next)
        head?.next?.next = head
        head.next = null
        return newHead*/
        // 使用栈解决
        /*var stack: Stack<ListNode> = Stack()
        var head = head
        // 把链表放入栈中
        while (head != null) {
            stack.push(head)
            head = head.next
        }
        if (stack.isEmpty()) {
            return null
        }
        var node = stack.pop()
        var dummy = node
        // 栈中的节点全部出栈，然后重新连接成一个新的链表
        while (!stack.isEmpty()) {
            var tempNode = stack.pop()
            node.next = tempNode
            node = node.next
        }
        node.next = null
        return dummy*/

        // 双链表求解
        var newHead: ListNode? = null
        var head = head
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            var temp: ListNode? = head?.next
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead
            newHead = head
            head = temp
        }
        return newHead
    }

    /**
     * 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null) {
            return l2
        }

        if (l2 == null) {
            return l1
        }

        var temp: ListNode = ListNode(0)
        var l1 = l1
        var l2 = l2
        var result = temp

        while (l1 != null && l2 != null) {

            if (l1.`val` <= l2.`val`) {
                temp.next = l1
                l1 = l1.next
            } else {
                temp.next = l2
                l2 = l2.next
            }
            temp = temp.next!!
        }
        temp.next = l1 ?: l2
        return result.next
    }

    /**
     * 回文链表
     * 请判断一个链表是否为回文链表。
     */
    fun isPalindrome(head: ListNode?): Boolean {

        var stackList: Stack<Int> = Stack()
        var head = head
        var head2 = head
        while (head != null) {
            stackList.push(head.`val`)
            head = head.next
        }

        while (head2 != null) {
            if (head2.`val` != stackList.pop()) {
                return false
            } else {
                head2 = head2.next
            }
        }
        return true
    }

    /**
     * 环形链表
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     */
    fun hasCycle(head: ListNode?): Boolean {
        // 存放到集合中
        /*var set = HashSet<ListNode>()
        var head = head
        while (head != null) {
            if (set.contains(head)) {
                return true
            }
            set.add(head)
            head = head.next
        }
        return false*/

        // 快慢指针解决
        if (head ==null){
            return false
        }
        var slow = head
        var fast = head
        while (fast!=null && fast.next!=null){
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast){
                return true
            }
        }
        return false
    }
}
