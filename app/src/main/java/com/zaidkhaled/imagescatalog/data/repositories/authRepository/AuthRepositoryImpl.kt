package com.zaidkhaled.imagescatalog.data.repositories.authRepository

import com.zaidkhaled.imagescatalog.data.daos.AuthRemoteDao
import com.zaidkhaled.imagescatalog.data.models.wrappers.ResponseWrapper

class AuthRepositoryImpl(private val remoteDao: AuthRemoteDao) : AuthRepository {
    override suspend fun loginUser(username: String?, password: String?): ResponseWrapper<Boolean> {
        return remoteDao.loginUser(username, password)
    }

    override suspend fun registerUser(
        username: String?,
        age: Int?,
        password: String?
    ): ResponseWrapper<Boolean> {
        return remoteDao.registerUser(username, age, password)
    }
}