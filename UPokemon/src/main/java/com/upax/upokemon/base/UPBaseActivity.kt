package com.upax.upokemon.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class UPBaseActivity <VB : ViewBinding>(private val bindingFactory: (LayoutInflater)->VB):AppCompatActivity(){

    lateinit var binding: VB

    open fun setUpView(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=bindingFactory(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

}