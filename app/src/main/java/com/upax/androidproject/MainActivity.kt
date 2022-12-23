package com.upax.androidproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upax.androidproject.databinding.ActivityMainBinding
import com.upax.upokemon.UPRootActivity
import com.upax.upokemon.base.UPBaseActivity

class MainActivity : UPBaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun setUpView() {
        super.setUpView()

        initElements()
        startActivity(Intent(this@MainActivity,UPRootActivity::class.java))

    }

    private fun initElements() {

    }
}