package com.pyn.mortgage

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.pyn.mortgage.databinding.ActivityMortgageBinding

class MortgageActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMortgageBinding

    // 是否为等额本息
    private var isInterest = true

    // 是否存在商业贷款
    private var hasBusiness = true

    // 是否存在公积金贷款
    private var hasAccumulation = false

    // 还款年限
    private var returnYear = 0

    // 商业贷款利率
    private var businessRatio: Double = 0.0

    // 公积金贷款利率
    private var accumulationRatio: Double = 0.0
    private val yearDescArray = arrayOf("5年", "10年", "15年", "20年", "30年")
    private val yearArray = arrayOf(5, 10, 15, 20, 30)
    private val ratioDescArray = arrayOf(
        "2015年10月24日 五年期商贷利率 4.90%　公积金利率 3.25%",
        "2015年08月26日 五年期商贷利率 5.15%　公积金利率 3.25%",
        "2015年06月28日 五年期商贷利率 5.40%　公积金利率 3.50%",
        "2015年05月11日 五年期商贷利率 5.65%　公积金利率 3.75%",
        "2015年03月01日 五年期商贷利率 5.90%　公积金利率 4.00%",
        "2014年11月22日 五年期商贷利率 6.15%　公积金利率 4.25%",
        "2012年07月06日 五年期商贷利率 6.55%　公积金利率 4.50%"
    )
    private val businessArray = doubleArrayOf(4.90, 5.15, 5.40, 5.65, 5.90, 6.15, 6.55)
    private val accumulationArray = doubleArrayOf(3.25, 3.25, 3.50, 3.75, 4.00, 4.25, 4.50)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMortgageBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initYearSpinner()
        initRatioSpinner()
    }

    /**
     * 初始化基准利率下拉框
     */
    private fun initRatioSpinner() {
        val ratioAdapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.item_select, ratioDescArray)
        ratioAdapter.setDropDownViewResource(R.layout.item_dropdown)
        mBinding.spRatio.prompt = "请选择基准利率"
        mBinding.spRatio.adapter = ratioAdapter
        mBinding.spRatio.setSelection(0)
        mBinding.spRatio.onItemSelectedListener = RatioSelectedListener()
    }

    /**
     *  初始化贷款年限拉框
     */
    private fun initYearSpinner() {
        val yearAdapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.item_select, yearDescArray)
        yearAdapter.setDropDownViewResource(R.layout.item_dropdown)
        mBinding.spYear.prompt = "请选择贷款年限"
        mBinding.spYear.adapter = yearAdapter
        mBinding.spYear.setSelection(0)
        mBinding.spYear.onItemSelectedListener = YearSelectedListener()
    }

    /**
     * 定义一个贷款年限的选择监听器
     */
    inner class YearSelectedListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            returnYear = yearArray[p2]
        }

    }

    /**
     * 定义一个基准利率的选择监听器
     */
    inner class RatioSelectedListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            businessRatio = businessArray[p2]
            accumulationRatio = accumulationArray[p2]
        }

    }

    /**
     * 根据贷款金额、还款年限、基准利率，计算还款信息
     */
    private fun calMortgage(ze: Double, nx: Double, rate: Double, bInterest: Boolean): Repayment? {
        val zem = (ze * rate / 12 * Math.pow(1 + rate / 12, nx)
                / (Math.pow(1 + rate / 12, nx) - 1))
        val amount = zem * nx
        val rateAmount = amount - ze
        val benjinm = ze / nx
        val lixim = ze * (rate / 12)
        val diff = benjinm * (rate / 12)
        val huankuanm = benjinm + lixim
        val zuihoukuan = diff + benjinm
        val av = (huankuanm + zuihoukuan) / 2
        val zong = av * nx
        val zongli = zong - ze
        val result = Repayment()
        result.total = ze
        if (bInterest) {
            result.monthRepayment = zem
            result.totalInterest = rateAmount
        } else {
            result.monthRepayment = huankuanm
            result.monthMinus = diff
            result.totalInterest = zongli
        }
        return result
    }
}

