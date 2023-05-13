package com.example.github.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.github.databinding.ItemCinemaBinding
import com.example.github.models.CinemaModel


class CinemaAdapter(
        val onItemClick: (model: CinemaModel) -> Unit
    ) : RecyclerView.Adapter<CinemaAdapter.FirstViewHolder>() {

        private var list: List<CinemaModel> = ArrayList()

        @SuppressLint("NotifyDataSetChanged")
        fun setList(listTwo: List<CinemaModel>) {
            this.list = listTwo
            notifyDataSetChanged()

        }

        inner class FirstViewHolder(private val binding: ItemCinemaBinding) :
            RecyclerView.ViewHolder(binding.root) {

            init {
                itemView.setOnClickListener {
                    onItemClick(list[adapterPosition])
                }
            }

            fun onBind(model: CinemaModel) {
                binding.txt.text = model.name
                Glide.with(binding.image.context).load(model.name).into(binding.image)
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
            holder.onBind(list[position])
        }

        override fun getItemCount(): Int = list.size
    }