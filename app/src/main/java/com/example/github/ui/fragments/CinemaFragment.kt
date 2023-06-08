package com.example.github.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.github.R
import com.example.github.databinding.FragmentCinemaBinding
import com.example.github.models.CinemaModel
import com.example.github.repository.CinemaRepository
import com.example.github.ui.adapter.CinemaAdapter

class CinemaFragment : Fragment() {

    private lateinit var binding: FragmentCinemaBinding
    private val listCinema = mutableListOf<CinemaModel>()
    private val adapter = CinemaAdapter(listCinema, this::onItemClick)
    private val args by navArgs<CinemaFragmentArgs>()
    private val repository = CinemaRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCinemaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        data()
    }

    private fun initialize() {
        binding.rvCinema.adapter = adapter
        listCinema.addAll(repository.getListOfText())
    }

    private fun setupListener() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_cinemaFragment_to_thirdFragment)
        }
    }

    private fun data() {
        if (args.saveText.isNotEmpty()) {
            listCinema.add(CinemaModel("", args.saveText))
        } else {
            Log.e("ELSE", "NOT DATA")
        }
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