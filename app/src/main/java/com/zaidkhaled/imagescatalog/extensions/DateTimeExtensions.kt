package com.zaidkhaled.imagescatalog.extensions

import java.util.*

fun getDateTimeAfter(
    days: Int? = null,
    months: Int? = null,
    years: Int? = null,
    hour: Int? = null,
    minute: Int? = null,
    second: Int? = null
): Date {
    val calendar = Calendar.getInstance()
    if (days != null) {
        calendar.add(Calendar.DATE, days)
    }
    if (months != null) {
        calendar.add(Calendar.MONTH, months)
    }
    if (years != null) {
        calendar.add(Calendar.YEAR, years)
    }
    if (hour != null) {
        calendar.add(Calendar.HOUR, hour)
    }
    if (minute != null) {
        calendar.add(Calendar.MINUTE, minute)
    }
    if (second != null) {
        calendar.add(Calendar.SECOND, second)
    }

    return calendar.time
}