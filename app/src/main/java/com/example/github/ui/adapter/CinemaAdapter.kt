package com.example.github.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.github.databinding.ItemCinemaBinding
import com.example.github.models.CinemaModel

class CinemaAdapter(
    private var cinemaList: MutableList<CinemaModel>,
    val onItemClick: (model: CinemaModel) -> Unit
) : RecyclerView.Adapter<CinemaAdapter.FirstViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(listTwo: MutableList<CinemaModel>) {
        this.cinemaList = listTwo
        notifyDataSetChanged()
    }

    inner class FirstViewHolder(private val binding: ItemCinemaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(cinemaList[adapterPosition])
            }
        }

        fun onBind(model: CinemaModel) {
            binding.txt.text = model.name
            Glide.with(binding.img.context).load(model.image).into(binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        return FirstViewHolder(
            ItemCinemaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.onBind(cinemaList[position])
    }

    override fun getItemCount(): Int = cinemaList.size
}