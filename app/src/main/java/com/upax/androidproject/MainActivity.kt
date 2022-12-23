package com.upax.androidproject

import android.content.Intent
import android.graphics.Color
import android.util.Patterns
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

            button.setOnClickListener {
                startActivity(Intent(this@MainActivity,UPRootActivity::class.java))

            }

            btnSubmit.setOnClickListener {

                if(Patterns.WEB_URL.matcher(editforurl.text.toString()).matches()){
                    paintHolderImage(editforurl.text.toString())
                }else{
                    if(!editforurl.text.toString().isNullOrEmpty()) createInitials(getInitials(editforurl.text.toString())) else paintHolderImage()

                }

            }

        }
    }

    fun getInitials(name:String): String {

        val words: List<String> = name.split(" ")
        val builder = StringBuilder()
        for (word in words) {
            builder.append(word[0])
        }
        return builder.toString()
    }

    private fun createInitials(initials:String){


            val drawable = TextDrawable.builder().buildRound(initials, Color.RED)
            binding.image.setImageDrawable(drawable)

    }

    fun paintHolderImage(url:String=""){
        Glide.with(applicationContext)
            .load(if(url.isNullOrEmpty())ContextCompat.getDrawable(applicationContext,R.drawable.person)else url)
            .circleCrop()
            .into(binding.image)
    }
}