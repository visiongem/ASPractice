package com.pyn.algorithm.array

object LeetcodeManger {

    /**
     * 同构字符串
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    fun isIsomorphic(s: String, t: String): Boolean {
        return true
    }

    /**
     * Missing element
     * 有序数组中的缺失元素
     * @param nums
     * @param k
     * @return
     * 现有一个按升序排列的整数数组 nums，其中每个数字都不相同
     * 给你一个整数k,请你找出并返回从数组最左边开始的第k个缺失数字
     */
    fun missingElement(nums: IntArray, k: Int): Int {

        var k1 = k
        for (index in 1 until nums.size) {
            var temp = nums[index] - nums[index - 1] - 1
            if (temp == 0) {
                // 表示两个数中间没有缺失元素
                continue
            }
            // 如果要找的整数k1>缺失元素，则在下面的循环中
            if (k1 > temp) {
                k1 -= temp
                continue
            } else {
                return nums[index - 1] + k1
            }
        }

        return nums[nums.size-1]+k1
    }
}