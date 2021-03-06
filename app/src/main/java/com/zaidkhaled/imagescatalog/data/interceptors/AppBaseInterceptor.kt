package com.zaidkhaled.imagescatalog.data.interceptors

import android.text.TextUtils
import com.zaidkhaled.imagescatalog.common.constants.AppConstants.AUTHORIZATION_HEADER_KEY
import com.zaidkhaled.imagescatalog.common.constants.AppConstants.AUTHORIZATION_HEADER_STARTED_VALUE
import com.zaidkhaled.imagescatalog.common.constants.AppConstants.SKIP_AUTHORIZATION_HEADER
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import java.util.prefs.Preferences
import javax.inject.Inject

class AppBaseInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequest = chain.request().newBuilder()

        if (TextUtils.isEmpty(original.header(SKIP_AUTHORIZATION_HEADER)) ||
            !TextUtils.isEmpty(original.header(SKIP_AUTHORIZATION_HEADER)) && original.header(
                SKIP_AUTHORIZATION_HEADER
            )!!.lowercase(Locale.ROOT) == "false"
        ) {
            newRequest.addHeader(
                AUTHORIZATION_HEADER_KEY,
                AUTHORIZATION_HEADER_STARTED_VALUE + getAccessToken()
            )
        }

        return chain.proceed(newRequest.build())
    }

    private fun getAccessToken(): String {
        //  return userPref.getAccessToken()
        return ""
    }
}