package com.pyn.algorithm.array

/**
 * 设计问题
 * 这类问题通常要求你实现一个给定的类的接口，并可能涉及使用一种或多种数据结构。 这些问题对于提高数据结构是很好的练习。
 */

/**
 * 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 */
class Solution(nums: IntArray) {

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return IntArray(1)
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        return IntArray(1)
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * var obj = Solution(nums)
     * var param_1 = obj.reset()
     * var param_2 = obj.shuffle()
     */

}

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
class MinStack() {

    /** initialize your data structure here. */
    fun push(x: Int) {
    }

    fun pop() {
    }

    fun top(): Int {
        return 0
    }

    fun getMin(): Int {
        return 0
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */