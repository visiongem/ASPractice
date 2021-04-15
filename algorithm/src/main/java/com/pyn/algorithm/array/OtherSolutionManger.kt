package com.pyn.algorithm.array

import java.util.*

/**
 * 其他
 */
object OtherSolutionManger {

    /**
     * 位1的个数
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     */
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        /*var result = 0
        var nStr = Integer.toBinaryString(n)
        for (element in nStr) {
            if (element == '1') {
                result++
            }
        }
        return result*/
        return Integer.bitCount(n)
    }

    /**
     * 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离
     */
    fun hammingDistance(x: Int, y: Int): Int {
        return Integer.bitCount(x.xor(y))
    }

    /**
     * 颠倒二进制位
     * 颠倒给定的 32 位无符号整数的二进制位。
     */
    fun reverseBits(n: Int): Int {
        return Integer.reverse(n)
    }

    /**
     * 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     */
    fun generate(numRows: Int): List<List<Int>> {

        var result: MutableList<MutableList<Int>> = mutableListOf()

        for (i in 0 until numRows) {
            var row: MutableList<Int> = mutableListOf()

            for (j in 0..i) {
                if (j == 0 || j == i) {
                    row.add(1)
                } else {
                    row.add(result[i - 1][j - 1] + result[i - 1][j])
                }
            }
            result.add(row)
        }

        return result
    }

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    fun isValid(s: String): Boolean {

        if (s.length % 2 != 0) {
            return false
        }

        var pairs = mutableMapOf<Char, Char>()
        pairs[')'] = '('
        pairs[']'] = '['
        pairs['}'] = '{'

        var stack: Deque<Char> = LinkedList()
        for (i in s.indices) {
            var ch = s[i]
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs[ch]) {
                    return false
                }
                stack.pop()
            } else {
                stack.push(ch)
            }

        }

        return stack.isEmpty()
    }

    /**
     * 缺失数字
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     */
    fun missingNumber(nums: IntArray): Int {

        /*nums.sort()

        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size != nums[nums.size - 1]) {
            return nums.size
        }
        if (nums[0] != 0) {
            return 0
        }

        for (i in nums.indices) {
            if (i == nums[i]) {
                continue
            } else {
                return i
            }
        }
        return 0*/

        // a^a=0；自己和自己异或等于0
        // a^0=a；任何数字和0异或还等于他自己
        // a^b^c=a^c^b；异或运算具有交换律
        // 遍历把所有的数字都异或一遍，即可得到答案
        var xor = 0
        for (i in nums.indices) {
            xor = i.xor(nums[i]).xor(xor)
        }
        return xor.xor(nums.size)
    }
}