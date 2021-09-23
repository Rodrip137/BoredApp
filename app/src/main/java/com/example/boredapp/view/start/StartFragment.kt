package com.example.boredapp.view.start

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.boredapp.R
import com.example.boredapp.StartActivity
import com.example.boredapp.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private val startViewModel : StartViewModel by viewModels()

    private lateinit var binding :FragmentStartBinding


    private lateinit var starActivity : StartActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        starActivity = context as StartActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        startViewModel.setSharedPreferences(starActivity.preferences)

        startViewModel.dataValid.observe(viewLifecycleOwner, Observer { dataValid ->
            binding.fragmentStart.btnStart.isEnabled = dataValid
        })

        binding.fragmentStart.etParticipants.doAfterTextChanged {
            startViewModel.dataChange(binding.fragmentStart.etParticipants.text.toString())
        }

        binding.fragmentStart.tvTerms.setOnClickListener {
            //it.findNavController().navigate(R.id.action_fragmentStart_to_termsFragment2)
            Navigation.findNavController(it).navigate(R.id.action_fragmentStart_to_termsFragment2)
        }
        binding.fragmentStart.btnStart.setOnClickListener {
            startViewModel.saveParticipes(binding.fragmentStart.etParticipants.text.toString())
        }

    }

}
















