package org.fog_rock.frextensions.ktx.date

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val TIMEZONE_UTC = "UTC"

/**
 * 端末に設定しているタイムゾーン基準で日付文字列に変換する.
 * @param format 日付フォーマット
 * @param locale 言語ロケール、未指定の場合 US
 * @return 日付文字列
 */
fun Long.toDefaultDateString(format: String, locale: Locale = Locale.US): String =
    toDateString(format, locale, TimeZone.getDefault())

/**
 * 協定世界時 (UTC) 基準で日付文字列に変換する.
 * @param format 日付フォーマット、未指定の場合 ISO 8601 形式
 * @return 日付文字列
 */
fun Long.toUtcDateString(format: String = FRDateFormat.ISO_8601.format): String =
    toDateString(format, Locale.US, TimeZone.getTimeZone(TIMEZONE_UTC))

/**
 * 日付文字列に変換する.
 * @param format 日付フォーマット
 * @param locale 言語ロケール
 * @param timezone タイムゾーン
 * @return 日付文字列
 */
fun Long.toDateString(format: String, locale: Locale, timezone: TimeZone): String =
    dateFormat(format, locale, timezone).format(Date(this))

/**
 * 端末に設定しているタイムゾーン基準の日付文字列から Date 型に変換する.
 * @param format 日付フォーマット
 * @param locale 言語ロケール、未指定の場合 US
 * @return Date 型、変換に失敗した場合は NULL
 */
fun String.defaultToDate(format: String, locale: Locale = Locale.US): Date? =
    toDate(format, locale, TimeZone.getDefault())

/**
 * 協定世界時 (UTC) 基準の日付文字列から Date 型に変換する.
 * @param format 日付フォーマット、未指定の場合 ISO 8601 形式
 * @return Date 型、変換に失敗した場合は NULL
 */
fun String.utcToDate(format: String = FRDateFormat.ISO_8601.format): Date? =
    toDate(format, Locale.US, TimeZone.getTimeZone(TIMEZONE_UTC))

/**
 * 日付文字列から Date 型に変換する.
 * @param format 日付フォーマット
 * @param locale 言語ロケール
 * @param timezone タイムゾーン
 * @return Date 型、変換に失敗した場合は NULL
 */
fun String.toDate(format: String, locale: Locale, timezone: TimeZone): Date? =
    try {
        dateFormat(format, locale, timezone).parse(this)
    } catch (e: ParseException) {
        null
    }

/**
 * 日付文字列と Date 型の相互変換のためのフォーマッターを取得する.
 * @param format 日付フォーマット
 * @param locale 言語ロケール
 * @param timezone タイムゾーン
 * @return 相互変換用のフォーマッター
 */
private fun dateFormat(format: String, locale: Locale, timezone: TimeZone) =
    SimpleDateFormat(format, locale).apply { timeZone = timezone }