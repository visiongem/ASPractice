package com.pyn.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pyn.tablayout.tablayout.CommonTabLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: CommonTabLayout
    val mTitles = arrayOf("动态", "要闻", "热门", "自选","关注")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab)

        for (i in 0 until mTitles.size) {
//            mTabEntities.add(TabEntity(mTitles[i], mIconSelectIds.get(i), mIconUnselectIds.get(i)))
        }
    }
}
