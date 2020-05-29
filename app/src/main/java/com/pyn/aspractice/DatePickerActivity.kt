package com.pyn.aspractice

import android.app.Activity
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.pyn.aspractice.databinding.ActivityDatePickerBinding
import java.util.*

class DatePickerActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    private lateinit var mBinding: ActivityDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDatePickerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.dpDate.setOnClickListener(this)
        mBinding.tvDate.setOnClickListener(this)
        mBinding.btnDate.setOnClickListener(this)
        mBinding.btnOk.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        var resId = view?.id
        when(resId){
            R.id.btn_date->{
                var calendar = Calendar.getInstance()
                var dialog = DatePickerDialog(this, this,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                dialog.show()
            }
            R.id.btn_ok->{
                var date = String.format("您选择的日期是 ${mBinding.dpDate.year}年${mBinding.dpDate.month}月${mBinding.dpDate.dayOfMonth}日")
                mBinding.tvDate.text = date
            }
        }

    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        var desc = String.format("您选择的日期是$p1 年$p2 月 $p3 日 ")
        mBinding.tvDate.text = desc
    }
}