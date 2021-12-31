package com.zaidkhaled.imagescatalog.extensions

import com.zaidkhaled.imagescatalog.common.constants.AppConstants.EMAIL_REGEX
import com.zaidkhaled.imagescatalog.common.constants.AppConstants.MAX_PASSWORD_LENGTH
import com.zaidkhaled.imagescatalog.common.constants.AppConstants.MIN_PASSWORD_LENGTH

fun String.isValidEmail(): Boolean {
    return this.matches(Regex(EMAIL_REGEX))
}

fun String.isValidPassword(): Boolean {
    return this.length in MIN_PASSWORD_LENGTH..MAX_PASSWORD_LENGTH
}