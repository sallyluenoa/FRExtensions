package org.fog_rock.frextensions.ktx.date

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val ONE_SECOND_MILLIS = 1000L
const val ONE_MINUTE_MILLIS = 60 * ONE_SECOND_MILLIS
const val ONE_HOUR_MILLIS = 60 * ONE_MINUTE_MILLIS
const val ONE_DAY_MILLIS = 24 * ONE_HOUR_MILLIS

const val TIMEZONE_UTC = "UTC"
const val TIMEZONE_JST = "JST"

const val FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val FORMAT_YYYYMMDD = "yyyy/MM/dd"
const val FORMAT_YYYYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss"
const val FORMAT_YYYYMMDD_HHMMSS_SSS = "yyyy/MM/dd HH:mm:ss.SSS"
const val FORMAT_JP_YYYYMMDDE = "yyyy年M月d日（E）"
const val FORMAT_JP_YYYYMMDDE_HHMMSS = "yyyy年M月d日（E）H時m分s秒"

fun Long.toDefaultDateString(format: String, locale: Locale = Locale.US): String =
    toDateString(format, locale, TimeZone.getDefault())

fun Long.toUtcDateString(format: String = FORMAT_ISO_8601): String =
    toDateString(format, Locale.US, TimeZone.getTimeZone(TIMEZONE_UTC))

fun Long.toDateString(format: String, locale: Locale, timezone: TimeZone): String =
    dateFormat(format, locale, timezone).format(Date(this))

fun String.defaultToDate(format: String, locale: Locale = Locale.US): Date? =
    toDate(format, locale, TimeZone.getDefault())

fun String.utcToDate(format: String = FORMAT_ISO_8601): Date? =
    toDate(format, Locale.US, TimeZone.getTimeZone(TIMEZONE_UTC))

fun String.toDate(format: String, locale: Locale, timezone: TimeZone): Date? =
    try {
        dateFormat(format, locale, timezone).parse(this)
    } catch (e: ParseException) {
        null
    }

private fun dateFormat(format: String, locale: Locale, timezone: TimeZone) =
    SimpleDateFormat(format, locale).apply { timeZone = timezone }