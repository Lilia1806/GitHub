package com.example.github.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.github.R
import com.example.github.databinding.FragmentCinemaBinding

class CinemaFragment : Fragment() {

    private lateinit var binding: FragmentCinemaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCinemaBinding.inflate(inflater, container, false)
        return binding.root
    }
}