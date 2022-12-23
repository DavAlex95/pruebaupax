package com.upax.upokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.upokemon.data.UPResult
import com.upax.upokemon.data.models.responses.UPokemonDetail
import com.upax.upokemon.data.repository.UPokemonRepository
import com.upax.upokemon.network.UPNetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UPokemonViewModel @Inject constructor(
    private var repository:UPokemonRepository
):ViewModel() {

    private val coroutineException= CoroutineExceptionHandler{_,_->
        _pokemon.value= UPResult.Error("ERROR")
    }

    private val _pokemon= MutableStateFlow<UPResult<UPokemonDetail>>(UPResult.Start)
    val pokemon: StateFlow<UPResult<UPokemonDetail>> = _pokemon

    fun getPokemon(id:Int){
        viewModelScope.launch ( Dispatchers.IO+coroutineException ){
            repository.getPokemonDetail(id).onStart {}.collectLatest { result->

                when(result){
                    is UPNetworkResult.Success->{
                        _pokemon.value=UPResult.Success(result.data)
                    }
                    is UPNetworkResult.Error->{

                    }
                    else->{}
                }

            }
        }
    }

}