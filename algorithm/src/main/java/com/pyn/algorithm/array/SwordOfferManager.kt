package com.pyn.algorithm.array

/**
 * 剑指 Offer
 * 图解算法数据结构中的题
 */
object SwordOfferManager {

    /**
     * 剑指 Offer 14- I. 剪绳子 【https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v1026/】
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    fun cuttingRope(n: Int): Int {

        if (n <= 3) {
            return n - 1
        }

        var a = n / 3
        var b = n % 3
        if (b == 0) {
            return Math.pow(3.0, a.toDouble()).toInt()
        }
        if (b == 1) {
            return Math.pow(3.0, (a - 1).toDouble()).toInt() * 4
        }
        return Math.pow(3.0, a.toDouble()).toInt() * 2
    }
}