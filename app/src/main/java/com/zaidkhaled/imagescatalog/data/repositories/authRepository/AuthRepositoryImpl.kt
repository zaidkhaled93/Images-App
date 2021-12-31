package com.zaidkhaled.imagescatalog.data.repositories.authRepository

import com.zaidkhaled.imagescatalog.common.constants.AppConstants.MOCKED_PASSWORD
import com.zaidkhaled.imagescatalog.common.constants.AppConstants.MOCKED_USERNAME
import com.zaidkhaled.imagescatalog.common.constants.NetworkConstants.SUCCESS_CODE
import com.zaidkhaled.imagescatalog.data.daos.AuthRemoteDao
import com.zaidkhaled.imagescatalog.data.models.wrappers.ResponseWrapper

class AuthRepositoryImpl(private val remoteDao: AuthRemoteDao) : AuthRepository {
    override suspend fun loginUser(username: String?, password: String?): ResponseWrapper<Boolean> {
        return if (username == MOCKED_USERNAME && password == MOCKED_PASSWORD) {
            ResponseWrapper(SUCCESS_CODE, true, null, true)
        } else {
            ResponseWrapper(400, false, "User not found", false)
        }
        //live api data access
        // return remoteDao.loginUser(username, password)
    }

    override suspend fun registerUser(
        username: String?,
        age: String?,
        password: String?
    ): ResponseWrapper<Boolean> {
        return if (username == MOCKED_USERNAME && password == MOCKED_PASSWORD) {
            ResponseWrapper(SUCCESS_CODE, true, null, true)
        } else {
            ResponseWrapper(400, false, "User not found", false)
        }
        //live api data access
        //return remoteDao.registerUser(username, age, password)
    }
}