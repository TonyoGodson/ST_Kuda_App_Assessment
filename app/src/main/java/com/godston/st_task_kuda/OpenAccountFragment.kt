package com.godston.st_task_kuda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.databinding.FragmentOpenAccountBinding

class OpenAccountFragment : Fragment() {

    private var _binding: FragmentOpenAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var ngnAcctChkBox: CheckBox
    private lateinit var gbpAcctChkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOpenAccountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ngnAcctChkBox = binding.openAccountNgnChkbox
        ngnAcctChkBox.setOnClickListener {
            selectNGN()
        }
        gbpAcctChkBox = binding.openAccountGbpChkbox
        gbpAcctChkBox.setOnClickListener {
            selectGBP()
        }
        binding.openAcctBackBtn.setOnClickListener {
            val action = OpenAccountFragmentDirections.actionOpenAccountFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }
        binding.openAccountNextBtn.setOnClickListener {
            val action = OpenAccountFragmentDirections.actionOpenAccountFragmentToSignUpFragmant()
            findNavController().navigate(action)
        }
    }
    fun selectNGN() {
        binding.openAccountNgnLlo.visibility = View.VISIBLE
        gbpAcctChkBox.isChecked = false
        ngnAcctChkBox.isChecked = true
        binding.openAccountGbpLlo.visibility = View.GONE
        binding.openAccountNgnCv.strokeWidth = 3
        binding.openAccountGbpCv.strokeWidth = 0
    }
    fun selectGBP() {
        binding.openAccountGbpLlo.visibility = View.VISIBLE
        ngnAcctChkBox.isChecked = false
        gbpAcctChkBox.isChecked = true
        binding.openAccountNgnLlo.visibility = View.GONE
        binding.openAccountGbpCv.strokeWidth = 3
        binding.openAccountNgnCv.strokeWidth = 0
    }
}
