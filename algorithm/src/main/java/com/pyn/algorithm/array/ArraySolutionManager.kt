package com.pyn.algorithm.array

import android.util.Log
import kotlin.math.pow

object ArraySolutionManager {

    /**
     * 1. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    fun removeDuplicates(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }

        var length = 0
        for (index in nums.indices) {

            if (nums[index] != nums[length]) {
                length++
                nums[length] = nums[index]
            }
        }
        return length + 1
    }

    /**
     * 贪心算法
     * 2. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        var ans = 0;
        var n = prices.size
        for (i in 1 until n) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans
    }

    /**
     * 3. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */
    fun rotate(nums: IntArray, k: Int): Unit {

        val tempArr = IntArray(nums.size)
        for (i in nums.indices) {
            tempArr[(i + k) % nums.size] = nums[i];
        }
        for (i in tempArr.indices) {
            nums[i] = tempArr[i]
        }
        System.arraycopy(tempArr, 0, nums, 0, nums.size)

        /* val arrSize = nums.size
         val n = k % arrSize
         nums.reverse(0, arrSize - 1)
         nums.reverse(0, n - 1)
         nums.reverse(n, arrSize - 1)*/

        for (i in nums.indices) {
            Log.d("rotate", nums[i].toString())
        }
    }

    /**
     * 4. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     */
    fun containsDuplicate(nums: IntArray): Boolean {

        if (nums.isEmpty()) {
            return false
        }
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    return true
                }
            }
        }
        return false
    }

}