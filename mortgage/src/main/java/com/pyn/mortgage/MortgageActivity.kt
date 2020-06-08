package com.pyn.mortgage

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pyn.mortgage.databinding.ActivityMortgageBinding
import java.math.BigDecimal
import java.math.RoundingMode

class MortgageActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMortgageBinding

    // 是否为等额本息
    private var isInterest = true

    // 是否存在商业贷款
    private var hasBusiness = true

    // 是否存在公积金贷款
    private var hasAccumulation = false

    // 还款年限
    private var returnYear: Double = 0.0

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

        mBinding.btnLoan.setOnClickListener {
            if (TextUtils.isEmpty(mBinding.edtPrice.text.toString())) {
                Toast.makeText(this, "购房总价不能为空", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(mBinding.etLoan.text.toString())) {
                Toast.makeText(this, "按揭部分不能为空", Toast.LENGTH_SHORT).show()
            } else {
                showLoan()
            }
        }

        mBinding.btnCalculate.setOnClickListener {
            if (hasBusiness && TextUtils.isEmpty(mBinding.etBusiness.text.toString())) {
                Toast.makeText(this, "商业贷款总额不能为空", Toast.LENGTH_SHORT).show();
            } else if (hasBusiness && TextUtils.isEmpty(mBinding.etAccumulation.text.toString())) {
                Toast.makeText(this, "公积金贷款总额不能为空", Toast.LENGTH_SHORT).show();
            } else if (!hasBusiness && !hasAccumulation) {
                Toast.makeText(this, "请选择商业贷款或者公积金贷款", Toast.LENGTH_SHORT).show();
            } else {
                showRepayment()
            }
        }

        mBinding.rgPayment.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.rb_interest) {
                isInterest = true
            } else if (i == R.id.rb_principal) {
                isInterest = false
            }
        }
        mBinding.ckBusiness.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.id == R.id.ck_business) {
                hasBusiness = b
            } else if (compoundButton.id == R.id.ck_accumulation) {
                hasAccumulation = b
            }
        }
        mBinding.ckAccumulation.setOnCheckedChangeListener { compoundButton, b -> }
    }

    /**
     * 根据贷款的相关条件，计算还款总额、利息总额，以及月供
     */
    private fun showRepayment() {
        var businessResult: Repayment? = Repayment()
        var accumulationResult: Repayment? = Repayment()
        // 申请了商业贷款
        if (hasBusiness) {
            val businessLoad: Double = mBinding.etBusiness.text.toString().toDouble() * 10000
            val businessTime: Double = returnYear * 12
            val businessRate: Double = businessRatio / 100
            // 计算商业贷款部分的还款明细
            businessResult = calMortgage(businessLoad, businessTime, businessRate, isInterest)
        }
        // 申请了公积金贷款
        if (hasAccumulation) {
            val accumulationLoad: Double = mBinding.etAccumulation.text.toString().toDouble() * 10000
            val accumulationTime: Double = returnYear * 12
            val accumulationRate: Double = businessRatio / 100
            // 计算公积金贷款部分的还款明细
            accumulationResult = calMortgage(accumulationLoad, accumulationTime, accumulationRate, isInterest)
        }
        var desc =
            "您的贷款总额为${formatDecimal(
                (businessResult!!.total + accumulationResult!!.total) / 10000, 2
            )}万元"

        desc =
            "$desc　　还款总额为%s万元${formatDecimal(
                (businessResult.total + businessResult.totalInterest +
                        accumulationResult.total + accumulationResult.totalInterest) / 10000, 2
            )}"
        desc =
            "$desc 其中利息总额为${formatDecimal(
                (businessResult.totalInterest + accumulationResult.totalInterest) / 10000, 2

            )}万元"
        desc = "$desc　　还款总时间为${returnYear * 12}月 "
        desc = if (isInterest) { // 如果是等额本息方式

                "$desc\n每月还款金额为${formatDecimal(
                    businessResult.monthRepayment + accumulationResult.monthRepayment, 2
                )}元"

        } else { // 如果是等额本金方式

                "$desc\n首月还款金额为${formatDecimal(
                    businessResult.monthRepayment + accumulationResult.monthRepayment, 2
                )}元，其后每月递减${formatDecimal(businessResult.monthMinus + accumulationResult.monthMinus, 2)}元"


        }
        mBinding.tvPayment.text = desc
    }

    private fun showLoan() {
        val total: Double = mBinding.edtPrice.text.toString().toDouble()
        val rate: Double = mBinding.etLoan.text.toString().toDouble() / 100
        val desc = java.lang.String.format("您的贷款总额为%s万元", formatDecimal(total * rate, 2))
        mBinding.tvLoan.text = desc
    }

    /**
     *  精确到小数点后第几位
     */
    private fun formatDecimal(value: Double, digit: Int): String? {
        var bd = BigDecimal(value)
        bd = bd.setScale(digit, RoundingMode.HALF_UP)
        return bd.toString()
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
            returnYear = yearArray[p2].toDouble()
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

