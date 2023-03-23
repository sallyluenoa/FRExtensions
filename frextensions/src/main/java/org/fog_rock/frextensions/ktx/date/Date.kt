/*
 * Copyright (c) 2021 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fog_rock.frextensions.ktx.date

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val TIMEZONE_UTC = "UTC"

/**
 * Convert UNIX time to a date string which based on the time zone set in the System.
 * @param format A date format
 * @param locale A language locale, which the default is US.
 * @return A date string
 */
fun Long.toDefaultDateString(format: String, locale: Locale = Locale.US): String =
    toDateString(format, locale, TimeZone.getDefault())

/**
 * Convert UNIX time to a date string which based on the UTC.
 * @param format A date format, which the default is ISO 8601.
 * @return A date string
 */
fun Long.toUtcDateString(format: String = FRDateFormat.ISO_8601.format): String =
    toDateString(format, Locale.US, TimeZone.getTimeZone(TIMEZONE_UTC))

/**
 * Convert UNIX time to a date string.
 * @param format A date format
 * @param locale A language locale
 * @param timezone A time zone
 * @return A date string
 */
fun Long.toDateString(format: String, locale: Locale, timezone: TimeZone): String =
    dateFormat(format, locale, timezone).format(Date(this))

/**
 * Convert a date string to a date which based on the time zone set in the System.
 * @param format A date format
 * @param locale A language locale, which the default is US.
 * @return A date if the string can be converted, or null otherwise.
 */
fun String.defaultToDate(format: String, locale: Locale = Locale.US): Date? =
    toDate(format, locale, TimeZone.getDefault())

/**
 * Convert a date string to a date which based on the UTC.
 * @param format A date format, which the default is ISO 8601.
 * @return A date if the string can be converted, or null otherwise.
 */
fun String.utcToDate(format: String = FRDateFormat.ISO_8601.format): Date? =
    toDate(format, Locale.US, TimeZone.getTimeZone(TIMEZONE_UTC))

/**
 * Convert a date string to a date.
 * @param format A date format
 * @param locale A language locale
 * @param timezone A time zone
 * @return A date if the string can be converted, or null otherwise.
 */
fun String.toDate(format: String, locale: Locale, timezone: TimeZone): Date? =
    try {
        dateFormat(format, locale, timezone).parse(this)
    } catch (e: ParseException) {
        null
    }

/**
 * Get a formatter for the interconversion between strings and dates.
 * @param format A date format
 * @param locale A language locale
 * @param timezone A time zone
 * @return A formatter
 */
private fun dateFormat(format: String, locale: Locale, timezone: TimeZone) =
    SimpleDateFormat(format, locale).apply { timeZone = timezone }