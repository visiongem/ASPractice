package com.pyn.algorithm.array

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
}