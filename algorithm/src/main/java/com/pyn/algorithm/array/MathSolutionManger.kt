package com.pyn.algorithm.array

/**
 * 数学
 * 面试中提出的大部分数学问题都不需要超出初中阶段的数学知识。
 */
object MathSolutionManger {

    /**
     * Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     */
    fun fizzBuzz(n: Int): List<String> {

        var result: MutableList<String> = mutableListOf()
        for (i in 1..n) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz")
            } else if (i % 3 == 0) {
                result.add("Fizz")
            } else if (i % 5 == 0) {
                result.add("Buzz")
            } else {
                result.add("$i")
            }
        }
        return result
    }

    /**
     * 计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     */
    fun countPrimes(n: Int): Int {
        var count = 0
        for (i in 2 until n) {
            if (isPrime(i)) {
                count++
            }
        }
        return count
    }

    fun isPrime(num: Int): Boolean {
        var max = Math.sqrt(num.toDouble()).toInt()
        for (i in 2..max) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }

    /**
     * 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
     */
    fun isPowerOfThree(n: Int): Boolean {
        var n = n
        if (n > 1) {
            while (n % 3 == 0) {
                n = n / 3
            }
        }
        return n == 1
        // return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
        //return ((Math.log10(n.toDouble()) / Math.log10(3.toDouble())) % 1).toInt() == 0;
    }

    /**
     * 罗马数字转整数
     */
    fun romanToInt(s: String): Int {
        var map: MutableMap<String, Int> = HashMap()
        map["I"] = 1
        map["IV"] = 4
        map["V"] = 5
        map["IX"] = 9
        map["X"] = 10
        map["XL"] = 40
        map["L"] = 50
        map["XC"] = 90
        map["C"] = 100
        map["CD"] = 400
        map["D"] = 500
        map["CM"] = 900
        map["M"] = 1000

        var result = 0
        var i = 0
        while (i < s.length) {
            if ((i + 1) < s.length && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2))!!
                i += 2
            } else {
                result += map.get(s.substring(i, i + 1))!!
                i += 1
            }
        }
        return result
    }

}