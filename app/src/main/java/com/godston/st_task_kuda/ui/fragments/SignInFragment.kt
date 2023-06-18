package com.godston.st_task_kuda.ui.fragments // ktlint-disable package-name

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.databinding.FragmentSignInBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            emailEt = signinEmailEt
            passwordEt = signinPasswordEt
            signinBtn.setOnClickListener {
                when {
                    TextUtils.isEmpty(emailEt.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            requireContext(),
                            "Please Enter Your Email",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    TextUtils.isEmpty(passwordEt.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            requireContext(),
                            "Please Enter Your Password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else -> {
                        val email: String = emailEt.text.toString().trim { it <= ' ' }
                        val password: String = passwordEt.text.toString().trim { it <= ' ' }

                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(
                                OnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Toast.makeText(
                                            requireContext(),
                                            "Login Successfully.",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        val action =
                                            SignInFragmentDirections.actionSignInFragmentToOtpFragment()
                                        findNavController().navigate(action)
                                    } else {
                                        Toast.makeText(
                                            requireContext(),
                                            task.exception!!.message.toString(),
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                            )
                    }
                }
            }
            signinChangePasswordTv.setOnClickListener{
                val action = SignInFragmentDirections.actionSignInFragmentToChangePasswordFragment()
                findNavController().navigate(action)
            }
        }
    }
}
