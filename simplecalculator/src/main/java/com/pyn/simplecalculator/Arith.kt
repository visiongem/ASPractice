package com.pyn.simplecalculator

import java.math.BigDecimal

/**
 * @author pengyanni
 * @date 2020/5/26  10:09.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class Arith {

    companion object {

        private const val DEF_DIV_SCALE: Int = 10

        /**
         * 精确的加法
         */
        fun add(num1: Double, num2: Double): String {
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.add(b2).toString()
        }

        /**
         * 精确的加法
         */
        fun add(num1: String, num2: String): String {
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.add(b2).toString()
        }

        /**
         * 精确的减法
         */
        fun sub(num1: Double, num2: Double): String {
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.subtract(b2).toString()
        }

        /**
         * 精确的减法
         */
        fun sub(num1: String, num2: String): String {
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.subtract(b2).toString()
        }

        /**
         * 精确的乘法
         */
        fun mul(num1: String, num2: String): String {
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.multiply(b2).toString()
        }

        /**
         * 精确的乘法
         */
        fun mul(num1: Double, num2: Double): String {
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.multiply(b2).toString()
        }


        fun div(num1: Double, num2: Double): String {
            return div(num1, num2, DEF_DIV_SCALE)
        }

        fun div(num1: String, num2: String): String {
            return div(num1, num2, DEF_DIV_SCALE)
        }

        /**
         * 精确的乘法
         * scale 表示表示需要精确到小数点以后几位
         */
        fun div(num1: Double, num2: Double, scale: Int): String {
            require(scale >= 0) { "The scale must be a positive integer or zero" }
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString()
        }

        /**
         * 精确的乘法
         * scale 表示表示需要精确到小数点以后几位
         */
        fun div(num1: String, num2: String, scale: Int): String {
            require(scale >= 0) { "The scale must be a positive integer or zero" }
            val b1 = BigDecimal(num1)
            val b2 = BigDecimal(num2)
            var result: BigDecimal
            try {
                result = b1.divide(b2)
            } catch (e: Exception) {
                result = b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP)
            }
            return result.toString()
        }

        /**
         * 提供精确的小数位四舍五入处理。
         *
         * @param v     需要四舍五入的数字
         * @param scale 小数点后保留几位
         * @return 四舍五入后的结果
         */
        fun round(v: Double, scale: Int): String? {
            require(scale >= 0) { "The scale must be a positive integer or zero" }
            val b = BigDecimal(v.toString())
            val one = BigDecimal("1")
            return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString()
        }
    }
}