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
        }else{
            return canWinNim(n - 4)
        }
    }
}