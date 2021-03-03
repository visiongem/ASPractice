package com.pyn.algorithm.array

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
     * 买卖股票的最佳时机 II
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
}