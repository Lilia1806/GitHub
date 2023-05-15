package com.example.github.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.github.databinding.FragmentCinemaDetailBinding

class CinemaDetailFragment : Fragment() {

    private lateinit var binding: FragmentCinemaDetailBinding
    private val args by navArgs<CinemaDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCinemaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data()
    }

    private fun data() {
        binding.tvDetail.text = args.name
        val name = args.image
        Glide
            .with(binding.tvDetail.context)
            .load(name)
            .into(binding.imgDetail)
    }
}