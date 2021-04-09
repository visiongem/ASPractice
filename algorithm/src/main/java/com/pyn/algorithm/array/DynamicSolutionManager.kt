package com.pyn.algorithm.array

/**
 * 动态规划
 */
object DynamicSolutionManager {

    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */
    fun climbStairs(n: Int): Int {

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
     * 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    fun maxProfit(prices: IntArray): Int {

        var result = 0
        var fir = 0
        for(i in prices.indices){
            if (i == 0){
                fir = prices[0]
                continue
            }
            var num = prices[i] - fir
            if (num > 0){
                result = Math.max(result, num)
            }else{
                fir = prices[i]
            }
        }

        return result
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    fun maxSubArray(nums: IntArray): Int {
        return 0
    }

    /**
     * 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗
     * 系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    fun rob(nums: IntArray): Int {
        return 0
    }
}