package com.godston.st_task_kuda.ui.fragments // ktlint-disable package-name

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.godston.st_task_kuda.databinding.FragmentAboutYouBinding
import com.godston.st_task_kuda.model.User
import com.godston.st_task_kuda.utils.Common
import com.godston.st_task_kuda.viewmodel.KudaViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class AboutYouFragment : Fragment() {

    private var _binding: FragmentAboutYouBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var dbRef: DatabaseReference
    private lateinit var u_email: String
    private lateinit var u_password: String
    private val user = User()
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
        _binding = FragmentAboutYouBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kudaViewModel.email.observe(viewLifecycleOwner) { email ->
            u_email = email
        }
        kudaViewModel.password.observe(viewLifecycleOwner) { password ->
            u_password = password
        }
        init()
    }

    fun init() {
        firebaseDatabase = FirebaseDatabase.getInstance()
        dbRef = firebaseDatabase.getReference(Common.USER_INFO_REF)

        binding.apply {
            aboutYouBackBtn.setOnClickListener {
                val action =
                    AboutYouFragmentDirections.actionAboutYouFragmentToConfirmEmailFragment()
                findNavController().navigate(action)
            }
            aboutYouNextBtn.setOnClickListener {
                when {
                    TextUtils.isEmpty(legalFnEt.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            requireContext(),
                            "Please Enter Your Legal Name",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    TextUtils.isEmpty(legalMnEt.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            requireContext(),
                            "Please Enter Your Middle Name",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    TextUtils.isEmpty(legalLnEt.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            requireContext(),
                            "Please Enter Your Email",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else -> {
                        val first_name: String = legalFnEt.text.toString().trim { it <= ' ' }
                        val middle_name: String = legalMnEt.text.toString().trim { it <= ' ' }
                        val last_name: String = legalLnEt.text.toString().trim { it <= ' ' }

                        user.firstName = first_name
                        user.middleName = middle_name
                        user.lastName = last_name
                        user.email = u_email
                        user.password = u_password
                        createUser()
                    }
                }
            }
        }
    }
    fun createUser() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(u_email, u_password)
            .addOnCompleteListener(
                OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        saveToFB()
                        Toast.makeText(
                            requireContext(),
                            "Signed Up Successfully.",
                            Toast.LENGTH_LONG
                        ).show()
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

    fun saveToFB() {
        dbRef.child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(user)
            .addOnFailureListener { error ->
                Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
            }
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Registration Successful", Toast.LENGTH_LONG)
                    .show()
            }
    }
}
