package com.upax.upokemon.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class UPBaseFragment<VB:ViewBinding>(private val bindingInflater: (LayoutInflater)->VB):Fragment() {

    private var _binding:VB?=null
    val binding:VB
    get()=_binding as VB

    open fun setupView(){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=bindingInflater.invoke(inflater)
        setupView()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}