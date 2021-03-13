package com.pyn.algorithm.array

import java.lang.Math.*
import java.util.*
import kotlin.math.sqrt

/**
 * 鹅厂是一家能让你拥有多元化职业发展的平台。尊重个性、轻松自在的工作环境、有趣的互联网工作。
 */
object GooseManger {

    /**
     * 【动态规划】
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */
    fun climbStairs(n: Int): Int {

        // f(x) 表示爬到第 xx 级台阶的方案数
        // f(x) = f(x-1)+f(x-2)
        // f(0)=1  f(1)=1  f(2)=2  f(3)=3  f(4)=5
        // 滚动数组思想
        var p = 0
        var q = 0
        var r = 1
        for (i in 1..n) {
            p = q
            q = r
            r = p + q
        }
        return r
    }

    /**
     * Nim 游戏
     * 你和你的朋友，两个人一起玩 Nim 游戏：
     * 桌子上有一堆石头。
     * 你们轮流进行自己的回合，你作为先手。
     * 每一回合，轮到的人拿掉 1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。
     * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
     */
    tailrec fun canWinNim(n: Int): Boolean {

        // 通过数学观察
        /*return (n % 4 != 0);*/

        if (n == 4) {
            return false
        }

        if (n < 4) {
            return true
        } else {
            return canWinNim(n - 4)
        }
    }

    /**
     * 2的幂
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     */
    fun isPowerOfTwo(n: Int): Boolean {

        /*if (n == 1) {
            return true
        }

        if (n % 2 != 0) {
            return false
        } else {
            return isPowerOfTwo(n / 2)
        }*/
        var n_ = n
        if (n_ == 0) {
            return false
        }
        while (n_ % 2 == 0) {
            n_ /= 2
        }
        return n_ == 1
    }

    /**
     * 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    fun maxProfit(prices: IntArray): Int {

        if (prices.isEmpty()) {
            return 0
        }

        var ans = 0
        var tempIndex = 0
        for (index in 1 until prices.size) {
            if (prices[index] > prices[tempIndex]) {
                ans = Math.max(ans, prices[index] - prices[tempIndex])
            } else {
                tempIndex = index
            }
        }
        return ans
    }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    /**
     * 反转链表
     * 反转一个单链表。
     */
    fun reverseList(head: ListNode?): ListNode? {

        if (head == null || head.next == null) {
            return head;
        }

        var newHead = reverseList(head.next)
        head?.next?.next = head
        head.next = null
        return newHead
    }

    /**
     * 多数元素
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     */
    fun majorityElement(nums: IntArray): Int {

        // 哈希表法
        /*var n = nums.size/2
        var result : HashMap<Int, Int> = HashMap()
        var res:Int = nums[0]
        for (index in nums.indices){
            if (result.containsKey(nums[index])){
                result.put(nums[index], result.get(nums[index])!!+1)
                if (result.get(nums[index])!!>n){
                    res = nums[index]
                }
            }else {
                result.put(nums[index], 1)
            }
        }
        return res*/

        // 排序法 排序后，下标为n/2的数一定是众数
        /*Arrays.sort(nums);
        return nums[nums.size / 2];*/

        // 摩尔投票法，遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
        var count = 0
        var result = -1
        for (index in nums.indices) {
            if (count == 0) result = nums[index];
            if (nums[index] == result) ++count;
            else --count;
        }
        return result
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null //指向下一个存储节点的next指针
}