package com.pyn.algorithm.array

object StringSolutionManager {

    /**
     * 1 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     */
    fun reverseString(s: CharArray): Unit {
        /*s.reverse()*/
        // 循环数组大小一半次数，第一个和最后一个交换，第二个和倒数第二个交换
        for (index in 0 until s.size / 2) {
            var temp = s[index]
            s[index] = s[s.size - index - 1]
            s[s.size - index - 1] = temp
        }
    }

    /**
     * 2 整数反转
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     */
    fun reverse(x: Int): Int {

        var y = x.toString()
        return if (x >= 0) {
            try {
                y.reversed().toInt()
            } catch (e: java.lang.NumberFormatException) {
                0
            }
        } else {
            try {
                "-${y.substring(1).reversed()}".toInt()
            } catch (e: java.lang.NumberFormatException) {
                0
            }
        }
    }
}