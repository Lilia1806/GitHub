package com.example.github.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.github.databinding.FragmentCinemaBinding
import com.example.github.models.CinemaModel
import com.example.github.ui.adapter.CinemaAdapter

class CinemaFragment : Fragment() {

    private lateinit var binding: FragmentCinemaBinding
    private var viewModel: CinemaViewModel? = null
    private val adapter = CinemaAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCinemaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CinemaViewModel::class.java]

        initialize()
        setupObserve()
    }

    private fun setupObserve() {
        viewModel?.getListOfText()?.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

    private fun initialize() {
        binding.rvCinema.adapter = adapter
    }

    private fun onItemClick(model: CinemaModel) {
        findNavController().navigate(
            CinemaFragmentDirections.actionCinemaFragmentToCinemaDetailFragment(
                model.name,
                model.image
            )
        )
    }
}