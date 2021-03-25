package com.pyn.algorithm.array

import java.lang.StringBuilder
import kotlin.collections.HashMap

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

            if (result.containsKey(s[index].toString())) {
                // 如果还找到了这个字母，就都标志位2 不管具体多少个，反正都不符合要返回的了
                result[s[index].toString()] = 2
            } else {
                result.put(s[index].toString(), 1)
            }
        }

        // 循环遍历，当字母出现为1 ，就返回，就是第一个了
        for (j in s.indices) {
            if (result[s[j].toString()] == 1)
                return j
        }

        return -1
    }

    /**
     * 4 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 你可以假设字符串只包含小写字母。
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    fun isAnagram(s: String, t: String): Boolean {
        // 特判，长度不同必定不是
        if (s.length != t.length) {
            return false
        }
        // 两个字符串排序后是否相等
        var schar = s.toCharArray()
        var tchar = t.toCharArray()

        schar.sort()
        tchar.sort()

        return schar.contentEquals(tchar)
    }

    /**
     * 5 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    fun isPalindrome(s: String): Boolean {

        var left = 0
        var right = s.length - 1
        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s[left]))
                left++
            while (left < right && !Character.isLetterOrDigit(s[right]))
                right--

            if (Character.toLowerCase(s[left]) != Character.toLowerCase(s[right]))
                return false
            left++
            right--
        }
        return true
    }

    /**
     * 字符串转换整数 (atoi)
     */
    fun myAtoi(s: String): Int {

        return 0
    }

    /**
     * 实现 strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    fun strStr(haystack: String, needle: String): Int {

        // 如果haystack没有needle 或者 haystack的长度就短于 needle,肯定就没有这个东西了
        if (!haystack.contains(needle) || haystack.length < needle.length) {
            return -1
        }
        // needle为空，就是0开始
        if (needle.isEmpty()) {
            return 0
        }
        // 开个循环去找
        for (index in haystack.indices) {
            if (haystack[index] == needle[0]) {
                if (haystack.substring(index, index + needle.length) == needle) {
                    return index
                }
            }
        }

        return -1
        // 简单就api
        //return haystack.indexOf(needle)
    }

    /**
     * 外观数列
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * 1 <= n <= 30
     */
    fun countAndSay(n: Int): String {
        // 递归出口
        if (n == 1) {
            return "1"
        }
        // 假设我们获得上一次的结果为 s1 = 112213
        var s = countAndSay(n - 1)
        // 定义结果
        var result = StringBuilder();
        // 对s遍历处理获取值
        var local = s[0]
        var count = 0
        for (i in s.indices) {
            // 设定计数器 计算同一个数字出现的次数 count
            if (s[i] == local) {
                count++
            } else {
                // 不符合 记录下
                result.append(count)
                result.append(local)
                count = 1
                local = s[i]
            }
        }
        result.append(count)
        result.append(local)
        return result.toString()

    }


    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    fun longestCommonPrefix(strs: Array<String>): String {

        if (strs.isEmpty()) {
            return ""
        }

        for (i in strs[0].indices) {
            var chars = strs[0][i]
            for (j in 1 until strs.size) {
                if (strs[j].length <= i || strs[j][i] != chars) {
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}
