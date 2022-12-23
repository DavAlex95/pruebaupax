package com.upax.upokemon.ui.pokemons

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.upax.upokemon.base.UPBaseFragment
import com.upax.upokemon.data.UPResult
import com.upax.upokemon.databinding.FragmentHomeBinding
import com.upax.upokemon.ui.adapter.UPokemonAdapter
import com.upax.upokemon.viewmodel.UPokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PokemonFragment : UPBaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel : UPokemonViewModel by viewModels()
    private var adapter:UPokemonAdapter?=null
    private var mContext:Context?=null


    override fun setupView() {
        super.setupView()
        mContext=binding.root.context
        //initElements()
        //initObservers()
    }

    private fun initElements() {
        viewModel.getPokemons(25)
    }

    private fun initObservers() {
        viewModel.pokemons.flowWithLifecycle(lifecycle).onEach { state ->
            when(state){
                is UPResult.Error->{

                }
                is UPResult.Success->{
                    adapter=UPokemonAdapter(mContext!!,state.data.results.toMutableList())
                    binding.rv.adapter=adapter
                }
                else->{}
            }
        }.launchIn(lifecycleScope)
    }
}