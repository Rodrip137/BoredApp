package com.example.boredapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.boredapp.databinding.FragmentTermsBinding

class TermsFragment : Fragment() {

    private val termsViewModel :TermsViewModel by viewModels()
    private lateinit var starActivity :StartActivity

    private var _binding :FragmentTermsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MyViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        starActivity = context as StartActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        // Inflate the layout for this fragment
        _binding = FragmentTermsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        termsViewModel.setSharedPreferences(starActivity.preferences)

        termsViewModel.termsAccepted.observe(viewLifecycleOwner, Observer { termsAccepted ->
            binding.checkboxTerms.isChecked = termsAccepted
        })

        //retrocede luego de presionatr el btnClose
        binding.btnClose.setOnClickListener { activity?.onBackPressed() }

    }







    //Para evitar Memory leaks
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}