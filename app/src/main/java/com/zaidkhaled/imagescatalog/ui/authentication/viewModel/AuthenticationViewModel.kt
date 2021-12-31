package com.zaidkhaled.imagescatalog.ui.authentication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.zaidkhaled.imagescatalog.data.models.wrappers.Resource
import com.zaidkhaled.imagescatalog.data.repositories.authRepository.AuthRepository
import com.zaidkhaled.imagescatalog.ui.base.lifeCycle.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authRepo: AuthRepository,
) : BaseViewModel() {

    //login attributes
    val loginUsername: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val loginPassword: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    //register attributes
    val registerUsername: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val registerAge: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
    val registerPassword: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun login() = liveData {
        emit(Resource.loading(data = null))
        try {
            val response =
                authRepo.loginUser(loginUsername.value?.trim(), loginPassword.value?.trim())
            if (response.success == true) {
                emit(Resource.success(data = response))
            } else {
                emit(
                    Resource.customError(
                        data = null,
                        message = response.message ?: "Error Occurred!",
                        code = response.code ?: 0
                    )
                )
            }
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    fun register() = liveData {
        emit(Resource.loading(data = null))
        try {
            val response = authRepo.registerUser(
                registerUsername.value?.trim(),
                registerAge.value,
                registerPassword.value?.trim()
            )
            if (response.success == true) {
                emit(Resource.success(data = response))
            } else {
                emit(
                    Resource.customError(
                        data = null,
                        message = response.message ?: "Error Occurred!",
                        code = response.code ?: 0
                    )
                )
            }
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}