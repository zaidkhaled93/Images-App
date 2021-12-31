package com.zaidkhaled.imagescatalog.data.daos

import com.zaidkhaled.imagescatalog.data.models.wrappers.ResponseWrapper
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthRemoteDao {

    @POST
    suspend fun loginUser(
        @Query("username") username: String?,
        @Query("password") password: String?
    ): ResponseWrapper<Boolean>

    @POST
    suspend fun registerUser(
        @Query("username") username: String?,
        @Query("age") age: Int?,
        @Query("password") password: String?
    ): ResponseWrapper<Boolean>

}