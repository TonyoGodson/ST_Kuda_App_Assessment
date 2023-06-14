package com.godston.st_task_kuda.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.R
import com.godston.st_task_kuda.databinding.FragmentConfirmEmailBinding

class ConfirmEmailFragment : Fragment() {

    private var _binding: FragmentConfirmEmailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentConfirmEmailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmEmailBackBtn.setOnClickListener {
            val action = ConfirmEmailFragmentDirections.actionConfirmEmailFragmentToSignUpFragmant()
            findNavController().navigate(action)
        }
        binding.confirmEmailNextBtn.setOnClickListener {
            val action = ConfirmEmailFragmentDirections.actionConfirmEmailFragmentToAboutYouFragment()
            findNavController().navigate(action)
        }
    }
}
