package org.fog_rock.frextensions.ktx.date

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Long.toDefaultDateString(format: String, locale: Locale = Locale.US): String =
    toDateString(format, locale, TimeZone.getDefault())

fun Long.toUtcDateString(format: String = FRDateFormat.ISO_8601.format): String =
    toDateString(format, Locale.US, TimeZone.getTimeZone(FRTimeZone.UTC.id))

fun Long.toDateString(format: String, locale: Locale, timezone: TimeZone): String =
    dateFormat(format, locale, timezone).format(Date(this))

fun String.defaultToDate(format: String, locale: Locale = Locale.US): Date? =
    toDate(format, locale, TimeZone.getDefault())

fun String.utcToDate(format: String = FRDateFormat.ISO_8601.format): Date? =
    toDate(format, Locale.US, TimeZone.getTimeZone(FRTimeZone.UTC.id))

fun String.toDate(format: String, locale: Locale, timezone: TimeZone): Date? =
    try {
        dateFormat(format, locale, timezone).parse(this)
    } catch (e: ParseException) {
        null
    }

private fun dateFormat(format: String, locale: Locale, timezone: TimeZone) =
    SimpleDateFormat(format, locale).apply { timeZone = timezone }