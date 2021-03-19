package com.pyn.algorithm.array

import android.util.Log

object ArraySolutionManager {

    /**
     * 1. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    fun removeDuplicates(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }

        var length = 0
        for (index in nums.indices) {

            if (nums[index] != nums[length]) {
                length++
                nums[length] = nums[index]
            }
        }
        return length + 1
    }

    /**
     * 贪心算法
     * 2. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        var ans = 0
        var n = prices.size
        for (i in 1 until n) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans
    }

    /**
     * 3. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */
    fun rotate(nums: IntArray, k: Int): Unit {

        val tempArr = IntArray(nums.size)
        for (i in nums.indices) {
            tempArr[(i + k) % nums.size] = nums[i];
        }
        for (i in tempArr.indices) {
            nums[i] = tempArr[i]
        }
        System.arraycopy(tempArr, 0, nums, 0, nums.size)

        /* val arrSize = nums.size
         val n = k % arrSize
         nums.reverse(0, arrSize - 1)
         nums.reverse(0, n - 1)
         nums.reverse(n, arrSize - 1)*/

        for (i in nums.indices) {
            Log.d("rotate", nums[i].toString())
        }
    }

    /**
     * 4. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     */
    fun containsDuplicate(nums: IntArray): Boolean {

        if (nums.isEmpty()) {
            return false
        }
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * 5. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    fun singleNumber(nums: IntArray): Int {
        /*nums.sort()

        var temp: Int = nums.size - 1
        for (i in nums.indices step 2) {
            if (i + 1 == nums.size) {
                break
            }
            if (nums[i] != nums[i + 1]) {
                temp = i
                break
            }
        }
        return nums[temp]*/
/*
        异或运算有以下三个性质。

        任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
        任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
        异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。*/
        var singleNum: Int = 0
        for (i in nums.indices) {
            singleNum = singleNum.xor(nums[i])
        }
        return singleNum
    }

    /**
     * 6. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        nums1.sort()
        nums2.sort()

        var size1 = nums1.size
        var size2 = nums2.size

        var index1 = 0
        var index2 = 0
        var index = 0

        var result: IntArray = IntArray(if (size1 > size2) size2 else size1)

        while (index1 < size1 && index2 < size2) {

            if (nums1[index1] < nums2[index2]) {
                index1++
            } else if (nums1[index1] > nums2[index2]) {
                index2++
            } else {
                result[index] = nums1[index1]
                index1++
                index2++
                index++
            }
        }

        return result.copyOfRange(0, index - 1)
    }

    /**
     * 7. 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    fun plusOne(digits: IntArray): IntArray {

        for (index in digits.size - 1 downTo 0) {

            if (digits[index] == 9) {
                if (index == 0) {
                    digits[0] = 0
                    var result = IntArray(digits.size + 1)
                    result[0] = 1
                    for (index in digits.indices) {
                        result[index + 1] = digits[index]
                    }
                    return result
                } else {
                    digits[index] = 0
                    continue
                }
            } else {
                digits[index]++
                break
            }
        }

        return digits
    }

    /**
     * 8. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    fun moveZeroes(nums: IntArray): Unit {

        // 双指针方式，index0指向的是 第一个为0的下标
        var index0 = 0
        for (index in nums.indices) {
            // 遍历数组，当碰到0的时候
            if (nums[index] == 0) {

                if (nums[index0] == 0) {
                    // 前面已经有0了，继续，不记录第二个0
                    continue
                } else {
                    // 把第一个为0的下标记住
                    index0 = index
                }
            } else {
                // 交换第一个0与数的位置
                var temp = nums[index]
                nums[index] = nums[index0]
                nums[index0] = temp
                // 将0的下标下移一位 也许它是第二0  也许它就是一个数，为0的时候与下个数交换，为数的时候，等到下个0出现再赋值下个0 的位置
                index0++
            }
        }
    }

    /**
     * 9. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     */
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        /*for (index in 0..(nums.size - 2)) {
            for (index2 in index + 1 until nums.size) {
                if (nums[index] + nums[index2] == target) {
                    return intArrayOf(index, index2)
                }
            }
        }
        return null*/
        for (index in nums.indices) {

            if (nums.contains(target - nums[index])) {
                var index1 = nums.indexOf(target - nums[index])
                if (index != index1) {
                    return intArrayOf(index, index1)
                }
            }
        }
        return null
    }

    /**
     * 10. 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        var rows = Array(9) { IntArray(9) }
        var columns = Array(9) { IntArray(9) }
        var boxes = Array(9) { IntArray(9) }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] != '.') {
                    var num = board[i][j] - '1'
                    var index_box = (i / 3) * 3 + j / 3
                    if (rows[i][num] == 1 || columns[j][num] == 1 || boxes[index_box][num] == 1) {
                        return false
                    }
                    rows[i][num] = 1
                    columns[j][num] = 1
                    boxes[index_box][num] = 1

                }
            }
        }
        return true
    }

    /**
     * 11. 旋转图像
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * matrix.length == n
     * matrix[i].length == n
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     */
    fun rotate(matrix: Array<IntArray>): Unit {
        var length = matrix.size
        // 因为是对称的，只需要计算循环前半行即可
        for (i in 0 until length / 2) {
            for (j in i until length - i - 1) {
                var temp = matrix[i][j]
                var m = length - j - 1
                var n = length - i - 1
                matrix[i][j] = matrix[m][i]
                matrix[m][i] = matrix[n][m]
                matrix[n][m] = matrix[j][n]
                matrix[j][n] = temp
            }
        }
    }
}