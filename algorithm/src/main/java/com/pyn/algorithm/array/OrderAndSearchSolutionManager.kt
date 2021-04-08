package com.pyn.algorithm.array

/**
 * 排序和搜索
 * 本章涵盖了在有序结构中的排序和搜索问题。
 */
object OrderAndSearchSolutionManager {

    /**
     * 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        for (i in 0 until n){
            nums1[m+i]=nums2[i]
        }
        nums1.sort()
    }
}
