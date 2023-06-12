package com.godston.st_task_kuda

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.databinding.FragmentOtpBinding

class OtpFragment : Fragment() {

    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!
    var otpText: String? = null
    private var otpList = emptyList<String>().toMutableList()
    private lateinit var delete: TextView
    private lateinit var replace: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOtpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delete = binding.deleteTv
        replace = binding.replaceTv
//        Log.d("OTP_List", otpList.toString())

        binding.passcode1BackBtn.setOnClickListener {
            val action = OtpFragmentDirections.actionOtpFragmentToSignInFragment()
            findNavController().navigate(action)
        }
        binding.oneTv.setOnClickListener {
            val one = "1"
            if (otpList.size < 6) {
                otpList.add(one)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.twoTv.setOnClickListener {
            val two = "2"
            if (otpList.size < 6) {
                otpList.add(two)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.threeTv.setOnClickListener {
            val three = "3"
            if (otpList.size < 6) {
                otpList.add(three)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.fourTv.setOnClickListener {
            val four = "4"
            if (otpList.size < 6) {
                otpList.add(four)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.fiveTv.setOnClickListener {
            val five = "5"
            if (otpList.size < 6) {
                otpList.add(five)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.sixTv.setOnClickListener {
            val six = "6"
            if (otpList.size < 6) {
                otpList.add(six)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.sevenTv.setOnClickListener {
            val seven = "7"
            if (otpList.size < 6) {
                otpList.add(seven)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.eightTv.setOnClickListener {
            val eight = "8"
            if (otpList.size < 6) {
                otpList.add(eight)
            }
//            checkDots()
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.nineTv.setOnClickListener {
            val nine = "9"
            if (otpList.size < 6) {
                otpList.add(nine)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.zeroTv.setOnClickListener {
            val zero = "0"
            if (otpList.size < 6) {
                otpList.add(zero)
            }
            showOrHideDeleteButton()
            Log.d("OTP_List", otpList.toString())
            checkOtpListSize()
        }
        binding.deleteTv.setOnClickListener {
            if (otpList.size > 0) {
                otpList = otpList.dropLast(1).toMutableList()
                Log.d("OTP_List", otpList.toString())
            }
            showOrHideDeleteButton()
        }
    }
    private fun showOrHideDeleteButton() {
        checkDots()
        if (otpList.size > 0) {
            replace.visibility = View.GONE
            delete.visibility = View.VISIBLE
        } else {
            replace.visibility = View.VISIBLE
            delete.visibility = View.GONE
        }
    }
    private fun checkOtpListSize() {
        if (otpList.size == 6) {
            otpText = otpList.toString()
            Log.d("OTP_List", "Enter passcode again.\n$otpText")
            Log.d("OTP_List", "Enter passcode again.\n$otpList".filter { it.isDigit() })
            val action = OtpFragmentDirections.actionOtpFragmentToPasscodeFragment2()
            findNavController().navigate(action)
        }
        checkDots()
    }
    private fun checkDots() {
        when (otpList.size) {
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
