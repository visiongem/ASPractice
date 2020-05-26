package com.pyn.simplecalculator

import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pyn.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG: String = this.javaClass.simpleName
    private lateinit var mBinding: ActivityMainBinding

    // 操作符
    private var operator: String = ""

    // 第一个操作数
    private var firstNum: String = "0"

    // 第二个操作数
    private var nextNum: String = ""

    // 结果
    private var result: String = ""

    // 显示文本
    private var showText: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initViews()
    }

    /**
     * 初始化视图
     */
    private fun initViews() {
        // 设置结果文本为滚动形式
        mBinding.tvResult.movementMethod = ScrollingMovementMethod()
        mBinding.tvResult.text = showText
    }

    fun onKeyClick(view: View) {

        val resId = view.id
        // 开根号控件和其他按钮不一样，做个输入区分
        var inputText = if (resId == R.id.ib_sqrt) {
            "√"
        } else {
            (view as TextView).text.toString()
        }

        when (resId) {
            R.id.btn_clear -> clear()
            R.id.btn_cancel -> {
                // 无操作符，则表示逐位取消前一个操作数
                if (operator.equals("")) {
                    if (firstNum.length == 1) {
                        firstNum = "0"
                    } else {
                        firstNum = firstNum.substring(0, firstNum.length - 1)
                    }
                    showText = firstNum
                    mBinding.tvResult.text = showText
                } else {
                    // 有操作符，则表示逐位取消后一个操作数
                    if (nextNum.length == 1) {
                        nextNum = ""
                    } else {
                        nextNum = nextNum.substring(0, nextNum.length - 1)
                    }
                    showText = showText.substring(0, showText.length - 1)
                    mBinding.tvResult.text = showText
                }
            }
            R.id.btn_equal -> {
                if (!TextUtils.isEmpty(operator)) {
                    if (caculate()) {
                        showText = showText + inputText + result
                    } else {
                        return
                    }
                }
                operator = inputText
            }
            R.id.ib_sqrt -> {
                if (TextUtils.isEmpty(operator)) {
                    result = Math.sqrt(firstNum.toDouble()).toString()

                } else {

                }
            }

            R.id.btn_plus, R.id.btn_minus, R.id.btn_multiply, R.id.btn_divide -> {
                operator = inputText
                showText += operator
                mBinding.tvResult.text = showText
            }
            else -> {
                if (operator.equals("=")) {
                    operator = ""
                    firstNum = "0"
                    nextNum = ""
                    showText = "0"
                }
                if (TextUtils.isEmpty(operator)) {
                    if (firstNum.contains(".") && inputText.equals(".")) {
                        return
                    }
                    firstNum += inputText
                } else {
                    if (nextNum.contains(".") && inputText.equals(".")) {
                        return; // 一个数字不能有两个小数点
                    }
                    nextNum += inputText
                }
                showText += inputText
                mBinding.tvResult.text = showText
            }
        }
    }

    /**
     * 加减乘数四则运算，成功返回 ture,失败返回 false
     */
    private fun caculate(): Boolean {

        when (operator) {

            resources.getString(R.string.plus) -> result = Arith.add(firstNum, nextNum)
            resources.getString(R.string.minus) -> result = Arith.sub(firstNum, nextNum)
            resources.getString(R.string.multiply) -> result = Arith.mul(firstNum, nextNum)
            resources.getString(R.string.divide) -> {
                if ("0".equals(nextNum)) {
                    Toast.makeText(this, "被除数不能为零", Toast.LENGTH_SHORT).show()
                    return false
                } else {
                    result
                }
            }
        }
        Log.d(TAG, "result = $result")
        firstNum = result
        nextNum = ""
        return true
    }

    /**
     * 清空并初始化
     */
    private fun clear() {
        showText = ""
        mBinding.tvResult.text = ""
        operator = ""
        firstNum = ""
        nextNum = ""
        result = ""
    }
}
