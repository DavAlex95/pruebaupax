package com.upax.androidproject

import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import com.amulyakhare.textdrawable.TextDrawable
import com.bumptech.glide.Glide
import com.upax.androidproject.databinding.ActivityMainBinding
import com.upax.upokemon.UPRootActivity
import com.upax.upokemon.base.UPBaseActivity


class MainActivity : UPBaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun setUpView() {
        super.setUpView()

        initElements()

    }

    private fun initElements() {

        with(binding){


            createInitials("AD")
            button.setOnClickListener {
                startActivity(Intent(this@MainActivity,UPRootActivity::class.java))

            }
        }
    }

    private fun createInitials(initials:String){

        val drawable = TextDrawable.builder().buildRound(initials, Color.RED)
        binding.image.setImageDrawable(drawable)
    }
}