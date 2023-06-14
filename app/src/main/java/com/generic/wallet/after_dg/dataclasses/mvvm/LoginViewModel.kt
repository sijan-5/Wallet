package com.generic.wallet.after_dg.dataclasses.mvvm

import androidx.lifecycle.ViewModel
import com.generic.wallet.after_dg.dataclasses.RegisterData
import com.generic.wallet.after_dg.dataclasses.User


class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    suspend fun getPost(user : RegisterData) = repository.getPost(user)
}