package com.godston.st_task_kuda.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.R
import com.godston.st_task_kuda.databinding.FragmentSignUpBinding
import com.godston.st_task_kuda.utils.Common
import com.godston.st_task_kuda.viewmodel.KudaViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpFragmant : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private var count = 0
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var dbRef: DatabaseReference
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var c_password: String
    val kudaViewModel: KudaViewModel by activityViewModels()
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
        binding.refferalNextTv.setOnClickListener {
            checkInputs()
        }

    }
//    private fun init() {
//        firebaseDatabase = FirebaseDatabase.getInstance()
//        dbRef = firebaseDatabase.getReference(Common.USER_INFO_REF)
//    }

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
    fun checkInputs() {
        binding.apply {
            when {
                TextUtils.isEmpty(signupEmailEt.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        requireContext(),
                        "Please Enter Your Email",
                        Toast.LENGTH_LONG
                    ).show()
                }
                TextUtils.isEmpty(signupPasswordEt.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        requireContext(),
                        "Please Enter Your Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
                TextUtils.isEmpty(signupConfirmEt.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        requireContext(),
                        "Please Confirm Your Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    email = signupEmailEt.text.toString().trim { it <= ' ' }
                    password = signupPasswordEt.text.toString().trim { it <= ' ' }
                    c_password = signupConfirmEt.text.toString().trim { it <= ' ' }
                    kudaViewModel.email.value = email
                    kudaViewModel.password.value = c_password
                    val action = SignUpFragmantDirections.actionSignUpFragmantToConfirmEmailFragment()
                    findNavController().navigate(action)
                }
            }
        }
    }
}
