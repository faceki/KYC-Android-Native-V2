package com.facekikycverification.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.facekikycverification.R
import com.facekikycverification.databinding.TutorialActivityBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class TutorialActivity: AppCompatActivity() {
    lateinit var binding : TutorialActivityBinding
    var mPosition : Int = 0
    val adapter by lazy {
        ViewPagerAdapter(supportFragmentManager, lifecycle)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Objects.requireNonNull(supportActionBar)!!.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        binding = DataBindingUtil.setContentView(this, R.layout.tutorial_activity)
        adapter.addFragment(TutorialDocumentScanFragment())
        adapter.addFragment(TutorialVerifyScanFragment())
        adapter.addFragment(TutorialTakeSelfiFragment())
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

        }.attach()
        binding.viewPager.registerOnPageChangeCallback(object: OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(position == 2){
                    binding.btNext.visibility = View.GONE
                    binding.start.visibility = View.VISIBLE
                } else {
                    binding.btNext.visibility = View.VISIBLE
                    binding.start.visibility = View.GONE
                }
            }
        })
        binding.btNext.setOnClickListener {
            if(mPosition<2){
                mPosition++
            }

            binding.viewPager.currentItem = mPosition
        }
        binding.start.setOnClickListener {
            startActivity(Intent(this, DocumentTypeActivity::class.java))
            finish()
        }
    }

}
