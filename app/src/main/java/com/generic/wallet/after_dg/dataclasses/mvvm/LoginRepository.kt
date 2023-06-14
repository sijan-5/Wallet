package com.generic.wallet.after_dg.dataclasses.mvvm

import com.generic.wallet.after_dg.dataclasses.RegisterData
import com.generic.wallet.after_dg.dataclasses.User
import retrofit2.Response
import retrofit2.http.POST

class LoginRepository(private val apiInterface: ApiInterface) {

suspend fun getPost(user : RegisterData)  = apiInterface.postUser(user)
}