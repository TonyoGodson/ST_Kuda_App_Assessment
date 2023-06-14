package com.godston.st_task_kuda.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.viewmodel.KudaViewModel
import com.godston.st_task_kuda.R
import com.godston.st_task_kuda.databinding.FragmentPasscode2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PasscodeFragment2 : Fragment() {

    private var _binding: FragmentPasscode2Binding? = null
    private val binding get() = _binding!!
    val kudaViewModel: KudaViewModel by activityViewModels()

//    private var otpText: String? = null
    private var otpListConfirm = emptyList<String>().toMutableList()
    private lateinit var delete: TextView
    private lateinit var replace: TextView
    private var otpList2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPasscode2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delete = binding.deleteTv
        replace = binding.replaceTv

//        otpList2 = arguments?.getString("otpList")
        kudaViewModel.passcodeData.observe(viewLifecycleOwner) { passcode ->
            Log.d("OTPList", "kudaViewModel Passcode: $passcode")
            otpList2 = passcode
        }

        binding.passcode2BackBtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val action = PasscodeFragment2Directions.actionPasscodeFragment2ToSignInFragment()
            findNavController().navigate(action)
        }
        binding.oneTv.setOnClickListener {
            val one = "1"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(one)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.twoTv.setOnClickListener {
            val two = "2"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(two)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.threeTv.setOnClickListener {
            val three = "3"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(three)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.fourTv.setOnClickListener {
            val four = "4"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(four)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.fiveTv.setOnClickListener {
            val five = "5"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(five)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.sixTv.setOnClickListener {
            val six = "6"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(six)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.sevenTv.setOnClickListener {
            val seven = "7"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(seven)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.eightTv.setOnClickListener {
            val eight = "8"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(eight)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.nineTv.setOnClickListener {
            val nine = "9"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(nine)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.zeroTv.setOnClickListener {
            val zero = "0"
            if (otpListConfirm.size < 6) {
                otpListConfirm.add(zero)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpListConfirm.toString())
            checkOtpListSize()
        }
        binding.deleteTv.setOnClickListener {
            if (otpListConfirm.size > 0) {
                otpListConfirm = otpListConfirm.dropLast(1).toMutableList()
                Log.d("OTP_List", otpListConfirm.toString())
            }
            showOrHideDeleteButton()
        }
    }
    private fun showOrHideDeleteButton() {
        checkDots()
        if (otpListConfirm.size > 0) {
            replace.visibility = View.GONE
            delete.visibility = View.VISIBLE
        } else {
            replace.visibility = View.VISIBLE
            delete.visibility = View.GONE
        }
    }
    private fun checkOtpListSize() {
        checkDots()
        if (otpListConfirm.size == 6) {
            Log.d("OTP_List", otpListConfirm.toString().filter { it.isDigit() })
            Log.d("OTP_List", otpList2.toString())
            if (otpListConfirm.toString().filter { it.isDigit() } == otpList2.toString()) {
                Log.d("OTP_List", "Passcode Created. $otpListConfirm and $otpList2"/*.filter { it.isDigit() }*/)
                val action = PasscodeFragment2Directions.actionPasscodeFragment2ToPasscodeOkFragment()
                findNavController().navigate(action)
            }
        } else {
            Log.d("OTP_List", "Passcodes do not match. $otpListConfirm and $otpList2"/*.filter { it.isDigit() }*/)
            return
        }
    }
    private fun checkDots() {
        when (otpListConfirm.size) {
            1 -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_2)
            }
            2 -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_2)
            }
            3 -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_2)
            }
            4 -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_2)
            }
            5 -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_2)
            }
            6 -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_3)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_3)
            }
            else -> {
                binding.otpDigit1.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit2.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit3.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit4.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit5.setImageResource(R.drawable.ic_baseline_circle_2)
                binding.otpDigit6.setImageResource(R.drawable.ic_baseline_circle_2)
            }
        }
    }
}
