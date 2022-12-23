package com.upax.upokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.upokemon.data.UPResult
import com.upax.upokemon.data.models.responses.UPokemonDetail
import com.upax.upokemon.data.models.responses.UPokemons
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
        _pokemonDetail.value= UPResult.Error("ERROR")
    }

    private val _pokemonDetail= MutableStateFlow<UPResult<UPokemonDetail>>(UPResult.Start)
    val pokemonDetail: StateFlow<UPResult<UPokemonDetail>> = _pokemonDetail

    private val _pokemons= MutableStateFlow<UPResult<UPokemons>>(UPResult.Start)
    val pokemons: StateFlow<UPResult<UPokemons>> = _pokemons

    fun getPokemons(offset:Int){
        viewModelScope.launch ( Dispatchers.IO+coroutineException ){
            repository.getPokemon(offset).onStart {}.collectLatest { result->

                when(result){
                    is UPNetworkResult.Success->{
                        _pokemons.value=UPResult.Success(result.data)
                    }
                    is UPNetworkResult.Error->{

                    }
                    else->{}
                }

            }
        }
    }

    fun getPokemonDetail(id:Int){
        viewModelScope.launch ( Dispatchers.IO+coroutineException ){
            repository.getPokemonDetail(id).onStart {}.collectLatest { result->

                when(result){
                    is UPNetworkResult.Success->{
                        _pokemonDetail.value=UPResult.Success(result.data)
                    }
                    is UPNetworkResult.Error->{

                    }
                    else->{}
                }

            }
        }
    }

}