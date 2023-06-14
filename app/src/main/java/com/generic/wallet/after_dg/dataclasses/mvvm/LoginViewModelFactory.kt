package com.generic.wallet.after_dg.dataclasses.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModelFactory(private val repository: LoginRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) LoginViewModel(this.repository) as T else
            throw IllegalArgumentException("Unknown ViewModel Class")
    }
}