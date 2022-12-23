package com.upax.upokemon.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upax.upokemon.data.models.responses.Result
import com.upax.upokemon.databinding.UpPokemonItemBinding

class UPokemonAdapter(private val context:Context, private val items: MutableList<Result>): RecyclerView.Adapter<UPokemonAdapter.ViewHolder>() {

    var listener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UpPokemonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

     inner class ViewHolder(private val binding: UpPokemonItemBinding):RecyclerView.ViewHolder(binding.root){
         fun bind(item: Result) {

             binding.name.text=item.name


             binding.root.setOnClickListener{
                 listener?.invoke()
             }

         }


    }

}