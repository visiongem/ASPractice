package com.pyn.algorithm.array

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pyn.algorithm.R

class ArrayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array)

        var nums: IntArray = intArrayOf(1, 1, 2, 2)
        var nums2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        var count = ArraySolutionManager.removeDuplicates(nums)
        Log.d("removeDuplicates", "2 removeDuplicates1 = $count")
        Log.d(
            "removeDuplicates", "5 removeDuplicates2 = ${
                ArraySolutionManager.removeDuplicates(
                    nums2
                )
            }"
        )

        val rotateNum = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        ArraySolutionManager.rotate(rotateNum, 3)

        val singleNum = intArrayOf(4, 1, 2, 1, 2)
        Log.d("singleNumber", "singleNumber = ${ArraySolutionManager.singleNumber(singleNum)}")

        val powerNum = 16
        Log.d("isPowerOfTwo", "isPowerOfTwo = ${GooseManger.isPowerOfTwo(powerNum)}")

        val reverseNum = -120
        Log.d("reverse", "-120 reverse = ${StringSolutionManager.reverse(reverseNum)}")

        StringSolutionManager.firstUniqChar("leetcode")

        var atoiNum = "    -42"
        Log.d("Atoi", " = ${StringSolutionManager.myAtoi(atoiNum)}")

        var primes = 10
        Log.d("countPrimes", "${MathSolutionManger.countPrimes(primes)}")

        var charArray: CharArray = charArrayOf('1', '0', '1', '0')
        Log.d("hammingWeight", "${OtherSolutionManger.hammingWeight(primes)}")

        Log.d("hammingDistance", "${OtherSolutionManger.hammingDistance(1, 4)}")

        Log.d("missingNumber", "${OtherSolutionManger.missingNumber(IntArray(1))}")

        Log.d("threeSum", "${IntermediateAlgorithmManager.threeSum(intArrayOf(-2, 0, 1, 1, 2))}")
    }
}