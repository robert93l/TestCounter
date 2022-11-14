package com.example.testcounter.presentation.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testcounter.databinding.ActivityWelcomeBinding

import com.example.testcounter.presentation.common.extension.android.navigateTo
import com.example.testcounter.presentation.home.HomeActivity

class WelcomeActivity : AppCompatActivity() {

    private val binding: ActivityWelcomeBinding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpAction()
    }

    private fun setUpAction() {
        binding.activityWelcomeBtn.setOnClickListener {
            navigateTo(HomeActivity::class.java, clearTop = true)
        }
    }

}