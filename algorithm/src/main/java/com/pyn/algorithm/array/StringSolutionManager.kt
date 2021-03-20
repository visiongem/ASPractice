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

    /**
     * 3 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 提示：你可以假定该字符串只包含小写字母。
     * s = "leetcode"
     * 返回 0
     * s = "loveleetcode"
     * 返回 2
     */
    fun firstUniqChar(s: String): Int {

        // 用哈希表解决，两边循环
        var result: MutableMap<String, Int> = HashMap<String, Int>()
        for (index in s.indices) {

            if (result.containsKey(s[index].toString())){
                // 如果还找到了这个字母，就都标志位2 不管具体多少个，反正都不符合要返回的了
                result[s[index].toString()] = 2
            }else {
                result.put(s[index].toString(), 1)
            }
        }

        // 循环遍历，当字母出现为1 ，就返回，就是第一个了
        for (j in s.indices){
            if(result[s[j].toString()] == 1)
                return j
        }

        return -1
    }
}