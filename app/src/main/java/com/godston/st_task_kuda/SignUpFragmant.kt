package com.godston.st_task_kuda

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.databinding.FragmentSignUpBinding

class SignUpFragmant : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toggleReferralIv.setOnClickListener {
            toggleRefCodeLayout()
        }
        binding.openAcctBackBtn.setOnClickListener {
            backToOpenAccountFragment()
        }
    }

    fun toggleRefCodeLayout() {
        count++
        if (count == 1) {
            binding.toggleReferralIv.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            binding.haveReferralTv.setText(R.string.referral_code)
            binding.referralLlo.visibility = View.VISIBLE
        }
        if (count > 1) {
            count = 0
            binding.toggleReferralIv.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            binding.haveReferralTv.setText(R.string.have_a_referral_code)
            binding.referralLlo.visibility = View.GONE
        }
        Log.d("count is", "$count")
    }
    fun backToOpenAccountFragment() {
        val action = SignUpFragmantDirections.actionSignUpFragmantToOpenAccountFragment()
        findNavController().navigate(action)
    }
}
