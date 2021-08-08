package com.teste_kotlin.ui.activity

import androidx.viewpager.widget.ViewPager
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import com.teste_kotlin.R
import com.teste_kotlin.ui.fragment.FirstFragment
import com.teste_kotlin.ui.fragment.SecondFragment
import com.teste_kotlin.ui.fragment.ThirdFragment

class MainActivity : AbstractActivity() {

    lateinit var smartTabLayout: SmartTabLayout;
    lateinit var viewPager: ViewPager;

    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {
        removeTitleBar()
        configTabLayout()
    }

    private fun removeTitleBar() {
        this.supportActionBar?.hide();
    }

    private fun configTabLayout() {
        smartTabLayout = findViewById<SmartTabLayout>(R.id.viewpagertab);
        viewPager = findViewById<ViewPager>(R.id.viewpager);
        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager,
            FragmentPagerItems.with(this).add("First", FirstFragment::class.java)
                .add("Second", SecondFragment::class.java).add("Third", ThirdFragment::class.java)
                .create()
        )
        viewPager.apply {
            this.adapter = adapter
        }
        smartTabLayout.setViewPager(viewPager)
    }
}