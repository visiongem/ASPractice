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
}