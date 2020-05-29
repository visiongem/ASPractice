package com.pyn.aspractice

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import com.pyn.aspractice.databinding.ActivityDatePickerBinding
import com.pyn.aspractice.databinding.ActivityTimePickerBinding
import java.util.*

class TimePickerActivity : AppCompatActivity(), View.OnClickListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var mBinding: ActivityTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mBinding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.tpTime.setOnClickListener(this)
        mBinding.btnTime.setOnClickListener(this)
        mBinding.btnOk.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(view: View?) {
        val resId = view?.id
        when(resId){
            R.id.btn_time->{
                val calendar = Calendar.getInstance()
                // true 表示24小时制，false 表示12小时制
                val dialog = TimePickerDialog(this, this,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.HOUR), true)
                dialog.show()
            }
            R.id.btn_ok->{
                val time = String.format("您选择的时间是 ${mBinding.tpTime.hour}时${mBinding.tpTime.minute}分")
                mBinding.tvTime.text = time
            }
        }
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val time = String.format("您选择的时间是 $p1 时 $p2 分")
        mBinding.tvTime.text = time
    }
}