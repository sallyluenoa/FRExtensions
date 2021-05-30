package org.fog_rock.frextensions.kotlin

import java.text.SimpleDateFormat
import java.util.*

const val ONE_SECOND_MILLIS = 1000L
const val ONE_MINUTE_MILLIS = 60 * ONE_SECOND_MILLIS
const val ONE_HOUR_MILLIS = 60 * ONE_MINUTE_MILLIS
const val ONE_DAY_MILLIS = 24 * ONE_HOUR_MILLIS

const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'"

fun Long.toDateString(
    format: String = ISO_8601_FORMAT,
    timezone: TimeZone = TimeZone.getDefault()
): String = dateFormat(format, timezone).format(Date(this))

fun String.toDate(
    format: String = ISO_8601_FORMAT,
    timezone: TimeZone = TimeZone.getDefault()
): Date? = dateFormat(format, timezone).parse(this)

private fun dateFormat(format: String, timezone: TimeZone) =
    SimpleDateFormat(format, Locale.US).apply { timeZone = timezone }