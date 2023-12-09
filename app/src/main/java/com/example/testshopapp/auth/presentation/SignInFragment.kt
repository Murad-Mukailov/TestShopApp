package com.example.testshopapp.auth.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testshopapp.R
import com.example.testshopapp.databinding.SigninFragmentBinding

class SignInFragment : Fragment(R.layout.signin_fragment) {
    companion object {
        const val APP_PREFERENCES = "APP_PREFERENCES"
        const val PREF_SOME_TEXT_VALUE = "PREF_SOME_TEXT_VALUE"
    }

    private lateinit var binding: SigninFragmentBinding
    private val viewModel: SignInViewModel by viewModels()
    private lateinit var preferences: SharedPreferences


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = SigninFragmentBinding.bind(view)

        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        binding.apply {
            firstNameSignInField.setText(preferences.getString(PREF_SOME_TEXT_VALUE, ""))
            lastNameSignInField.setText(preferences.getString(PREF_SOME_TEXT_VALUE, ""))
            emailSignInField.setText(preferences.getString(PREF_SOME_TEXT_VALUE, ""))
            signInLoginButton.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_signInFragment_to_profileFragment)
                val value = firstNameSignInField.text.toString()
                preferences.edit()
                    .putString(PREF_SOME_TEXT_VALUE, value)
                    .apply()
            }
        }
    }
}