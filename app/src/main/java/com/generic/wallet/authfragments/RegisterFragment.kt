package com.generic.wallet.authfragments

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.generic.wallet.R
import com.generic.wallet.after_dg.dataclasses.RegisterData
import com.generic.wallet.after_dg.dataclasses.User
import com.generic.wallet.after_dg.dataclasses.mvvm.*
import com.generic.wallet.databinding.FragmentRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Request
import retrofit2.Response


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

//        return inflater.inflate(com.generic.wallet.R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorString()
        val retrofitInterface = ApiImplementation.apiInterface
        val loginRepository = LoginRepository(retrofitInterface)

        val viewModel: LoginViewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(loginRepository)
        ).get(LoginViewModel::class.java)


        binding.continueButton.setOnClickListener {
            val checkBlankField = checkField()

            if (checkBlankField) {
                viewLifecycleOwner.lifecycleScope.launch {
                    val response = viewModel.getPost(getFormInput())
                    if(response.isSuccessful)
                    {
                       Log.d("Posted", response.body().toString())
                        findNavController().navigate(R.id.action_registerFragment_to_OTPFragment)
                    }
                    else
                    {
                        Log.d("error" , "Error")
                    }
                }
            }
        }

        binding.loginText.setOnClickListener {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.registerFragment, false).build()
            findNavController().navigate(
                R.id.action_registerFragment_to_logInFragment,
                null,
                navOptions
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun getFormInput(): RegisterData {
        val userName = binding.userName.text.toString()
        val phoneNumber = binding.mobileNumber.text.toString()
        val email = binding.userEmail.text.toString()
        val x = Request.Builder()
        return RegisterData(fullName = userName, mobileNumber = phoneNumber, email = email)
    }

    private fun colorString() {
        val toColorText = resources.getString(R.string.terms_and_condition_string)
        val spannableString = SpannableString(toColorText)
        val color =
            ContextCompat.getColor(requireContext(), com.example.sample01.R.color.button_purple)
        spannableString.setSpan(
            ForegroundColorSpan(color),
            31,
            48,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(color),
            53,
            68,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.termsConditionText.text = spannableString
    }

    private fun checkField(): Boolean {
        val formData = getFormInput()
        binding.apply {

            if (formData.fullName.isBlank()) {
                userName.error = "This is required"
                return false
            }
            if (formData.mobileNumber.isBlank()) {
                userMobileNumber.error = "This is required"
                return false
            } else if (PhoneNumberUtils.isGlobalPhoneNumber(formData.mobileNumber)) {
                userMobileNumber.error = "Phone number is not global"
                return false
            }
            if (formData.email.isBlank()) {
                userEmail.error = "This is required"
                return false
            }
            return true
        }

    }

}



