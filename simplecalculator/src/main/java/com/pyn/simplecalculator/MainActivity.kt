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

/**
 * 简易的计算机，规则定制简单点
 */
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
            resources.getString(R.string.sqrt)
        } else {
            (view as TextView).text.toString()
        }

        if (operator == resources.getString(R.string.equal)) {
            clear()
        }

        when (resId) {
            R.id.btn_clear -> clear()
            R.id.btn_cancel -> {
                // 无操作符，则表示逐位取消前一个操作数
                if (TextUtils.isEmpty(operator)) {
                    if (firstNum.length == 1) {
                        firstNum = "0"
                    } else {
                        firstNum = firstNum.substring(0, firstNum.length - 1)
                    }
                    showText = firstNum
                    mBinding.tvResult.text = showText
                } else {
                    // 有操作符，则表示逐位取消后一个操作数
                    if (operator == resources.getString(R.string.sqrt)) {
                        // 根号的情况
                        if (showText.length == 1) {
                            clear()
                        } else {
                            firstNum = firstNum.substring(0, firstNum.length - 1)
                            showText = "√$firstNum"
                            mBinding.tvResult.text = showText
                        }
                    } else {
                        // 不是根号的情况
                        if (nextNum.length > 1) {
                            nextNum = nextNum.substring(0, nextNum.length - 1)
                        } else if (nextNum.length == 1) {
                            nextNum = ""
                        } else {
                            operator = ""
                        }
                        showText = showText.substring(0, showText.length - 1)
                        mBinding.tvResult.text = showText
                    }
                }
            }
            R.id.btn_equal -> {
                if (!TextUtils.isEmpty(operator)) {
                    if (operator != resources.getString(R.string.sqrt)) {
                        // + - * /
                        if (caculate()) {
                            showText = showText + inputText + result
                        } else {
                            clear();
                            return
                        }
                    } else {
                        // 开根号
                        if (firstNum != "0") {
                            result = Math.sqrt(firstNum.toDouble()).toString()
                            showText = showText + inputText + result
                        } else {
                            showText = showText + "0=0"
                        }
                    }
                }
                operator = inputText
                mBinding.tvResult.text = showText
            }
            R.id.ib_sqrt -> {

                // 开根号必须放第一位，就这规定。哈哈~
                if (showText == "0") {
                    operator = inputText
                    showText = operator
                    mBinding.tvResult.text = showText
                } else {
                    Toast.makeText(this, "计算开根号请先输入根号，再输入数字", Toast.LENGTH_SHORT).show()
                    return
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
                    // 包含小数点的情况
                    if (firstNum.contains(resources.getString(R.string.dot)) && inputText == resources.getString(
                            R.string.dot
                        )
                    ) {
                        return
                    }

                    // 初始状态的情况，输入0，显示0的情况
                    if (inputText == "0" && showText == "0") {
                        return
                    }
                    if (firstNum == "0") {
                        if (inputText == resources.getString(R.string.dot)) {
                            firstNum = "0."
                        } else {
                            firstNum = inputText
                        }
                    } else {
                        firstNum += inputText
                    }
                    showText = firstNum
                } else {
                    if (operator != resources.getString(R.string.sqrt)) {
                        if (nextNum.contains(resources.getString(R.string.dot)) && inputText == resources.getString(
                                R.string.dot
                            )
                        ) {
                            return; // 一个数字不能有两个小数点
                        }
                        // 禁止输入两个0的情况
                        if (nextNum == "0" && inputText == "0") {
                            return
                        }

                        if (inputText == resources.getString(R.string.dot) && (nextNum == "")) {
                            nextNum = "0."
                        } else {
                            nextNum += inputText
                        }
                        showText = firstNum + operator + nextNum
                    } else {
                        // 包含小数点的情况
                        if (firstNum.contains(resources.getString(R.string.dot)) && inputText == resources.getString(
                                R.string.dot
                            )
                        ) {
                            return
                        }

                        // 初始状态的情况，输入0，显示0的情况
                        if (inputText == "0" && firstNum == "0" && showText == "√0") {
                            return
                        }
                        if (firstNum == "0") {
                            if (inputText == resources.getString(R.string.dot)) {
                                firstNum = "0."
                            } else {
                                firstNum = inputText
                            }
                        } else {
                            firstNum += inputText
                        }
                        showText = "√" + firstNum
                    }
                }
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
                    result = Arith.div(firstNum, nextNum)
                }
            }
        }
        Log.d(TAG, "result = $result")
        return true
    }

    /**
     * 清空并初始化
     */
    private fun clear() {
        showText = "0"
        mBinding.tvResult.text = "0"
        operator = ""
        firstNum = "0"
        nextNum = ""
        result = ""
    }
}
