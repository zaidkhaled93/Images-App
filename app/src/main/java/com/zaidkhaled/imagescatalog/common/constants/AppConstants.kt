package com.zaidkhaled.imagescatalog.common.constants

object AppConstants {
    const val SKIP_AUTHORIZATION_HEADER = "Skip_Authorization"
    const val AUTHORIZATION_HEADER_KEY = "Authorization"
    const val AUTHORIZATION_HEADER_STARTED_VALUE = "Bearer "
    const val APP_TIMEOUT_SECONDS = 20L

    const val EMAIL_REGEX = "^.+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2}[A-Za-z]*$"
    const val MIN_PASSWORD_LENGTH = 6
    const val MAX_PASSWORD_LENGTH = 12
    const val MIN_AGE = 18
    const val MAX_AGE = 99
    //mocking data
    const val MOCKED_USERNAME = "test@gmail.com"
    const val MOCKED_PASSWORD = "123456"

}