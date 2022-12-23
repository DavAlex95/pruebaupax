package com.upax.upokemon

import android.content.Context
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.upax.upokemon.base.UPBaseActivity
import com.upax.upokemon.databinding.ActivityUprootBinding
import com.upax.upokemon.viewmodel.UPokemonViewModel

class UPRootActivity : UPBaseActivity<ActivityUprootBinding>(ActivityUprootBinding::inflate) {

    private val homeViewModel : UPokemonViewModel by viewModels()
    lateinit var mContext: Context

    override fun setUpView() {
        super.setUpView()
        initElements()
    }

    private fun initElements() {
        with(binding){
            rv.layoutManager=
                LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)

        }
    }
}