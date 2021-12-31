package com.zaidkhaled.imagescatalog.data.repositories.authRepository

import com.zaidkhaled.imagescatalog.data.models.wrappers.ResponseWrapper
import retrofit2.http.POST

interface AuthRepository {
    suspend fun loginUser(
        username: String?,
        password: String?
    ): ResponseWrapper<Boolean>

    @POST
    suspend fun registerUser(
        username: String?,
        age: String?,
        password: String?
    ): ResponseWrapper<Boolean>
}