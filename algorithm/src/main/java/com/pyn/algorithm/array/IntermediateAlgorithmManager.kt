package com.pyn.algorithm.array

import java.util.*

/**
 * 中级算法
 * Intermediate algorithm manager
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/x6vk7r/
 * @constructor Create empty Intermediate algorithm manager
 */
object IntermediateAlgorithmManager {

    /********** 数组和字符串 **********/

    /**
     * Three sum
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return arrayListOf()
        }
        var result: MutableList<MutableList<Int>> = mutableListOf()
        // 排序
        Arrays.sort(nums)
        // 如果第0个都大于0,则没有相加等于0的组合了
        if (nums[0] > 0) {
            return arrayListOf()
        }
        for (index in 0..nums.size - 3) {
            if (index > 0 && nums[index] == nums[index - 1]) continue; // 去掉重复情况
            // 左指针，当前index+1
            var left = index + 1
            // 右指针，最末尾的数开始
            var right = nums.size - 1
            while (left < right) {
                val temp = nums[index] + nums[left] + nums[right]
                if (temp == 0) {
                    val list = arrayListOf(nums[index], nums[left], nums[right])
                    result.add(list)
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--
                    }
                    left++
                    right--
                } else if (temp < 0) {
                    left++
                } else {
                    right--
                }
            }
        }
        return result
    }

    /********** 数组和字符串 **********/

    /********** 链表 **********/

    /********** 链表 **********/
}