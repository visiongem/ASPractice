package com.pyn.aspractice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pyn.aspractice.databinding.ActivityNotificationBinding


class NotificationActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityNotificationBinding
    private val pushId = 1
    private val PRIMARY_CHANNEL = "default"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnSendSimpleNotify.setOnClickListener { sendSimpleNotify("sendSimpleNotify", "Test sendSimpleNotify") }
        mBinding.btnSendCounterNotify.setOnClickListener { sendCounterNotify("sendCounterNotify", "Test sendCounterNotify") }
    }

    /**
     * 发送简单的通知消息
     */
    fun sendSimpleNotify(title: String, message: String) {
        // 创建跳转意图
        val clickIntent = Intent(this, MainActivity().javaClass)
        val contentIntent = PendingIntent.getActivity(this, R.string.app_name, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder: Notification.Builder
        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 判断是否是 8.0 Android.O
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val chan = NotificationChannel(PRIMARY_CHANNEL, "Primary Channel", NotificationManager.IMPORTANCE_DEFAULT)
            chan.lightColor = Color.BLUE
            chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
            notificationManager.createNotificationChannel(chan)
            builder = Notification.Builder(this, PRIMARY_CHANNEL)
        } else {
            builder = Notification.Builder(this)
        }
        builder
            // 设置通知栏点击意图
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            // 设置通知小ICON
            .setSmallIcon(R.drawable.logo)
            .setTicker("提示消息来了")
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.logo)) // 设置通知栏里面的大图标
            // 通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
            .setWhen(System.currentTimeMillis())
            // 设置通知栏标题
            .setContentTitle(title)
            // 设置通知栏内容
            .setContentText(message)
            // 向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
            .setDefaults(Notification.DEFAULT_ALL)
        val notify: Notification = builder.build()
        notificationManager.notify(pushId, notify)
    }

    /**
     *发送计时的通知消息（通知栏右边自动计时）
     */
    fun sendCounterNotify(title: String, message: String) {
        // 创建一个跳转到活动页面的意图
        val cancelIntent = Intent(this, MainActivity::class.java)
        // 创建一个用于页面跳转的延迟意图
        val deleteIntent = PendingIntent.getActivity(
            this,
            R.string.app_name, cancelIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        val builder: Notification.Builder
        val notifyMgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // 创建一个通知消息的构造器
        // 判断是否是 8.0 Android.O
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val chan = NotificationChannel(PRIMARY_CHANNEL, "Primary Channel", NotificationManager.IMPORTANCE_DEFAULT)
            chan.lightColor = Color.BLUE
            chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
            notifyMgr.createNotificationChannel(chan)
            builder = Notification.Builder(this, PRIMARY_CHANNEL)
        } else {
            builder = Notification.Builder(this)
        }
        builder.setDeleteIntent(deleteIntent) // 设置内容的清除意图
            .setAutoCancel(true) // 设置是否允许自动清除
            .setUsesChronometer(true) // 设置是否显示计数器
            .setProgress(100, 60, false) // 设置进度条与当前进度
            .setNumber(99) // 设置通知栏右下方的数字
            .setSmallIcon(R.drawable.ic_launcher_background) // 设置状态栏里的小图标
            .setTicker("提示消息来啦") // 设置状态栏里面的提示文本
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.logo)) // 设置通知栏里面的大图标
            .setContentTitle(title) // 设置通知栏里面的标题文本
            .setContentText(message) // 设置通知栏里面的内容文本
        // 根据消息构造器构建一个通知对象
        val notify = builder.build()
        // 使用通知管理器推送通知，然后在手机的通知栏就会看到该消息
        notifyMgr.notify(R.string.app_name, notify)
    }

}