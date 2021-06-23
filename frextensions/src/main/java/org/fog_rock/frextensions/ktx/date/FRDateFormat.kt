package org.fog_rock.frextensions.ktx.date

/**
 * 日付フォーマット形式
 * @param format フォーマット文字列
 */
enum class FRDateFormat(val format: String) {
    /**
     * ISO8601形式
     */
    ISO_8601("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),

    /**
     * Year/Month/Day
     */
    YYYYMMDD("yyyy/MM/dd"),

    /**
     * Year/Month/Day Hour:Minute:Second
     */
    YYYYMMDD_HHMMSS("yyyy/MM/dd HH:mm:ss"),

    /**
     * Year/Month/Day Hour:Minute:Second.MilliSecond
     */
    YYYYMMDD_HHMMSS_SSS("yyyy/MM/dd HH:mm:ss.SSS"),

    /**
     * 日本語形式: Year年Month月Day日（曜日）
     */
    JP_YYYYMMDDE("yyyy年M月d日（E）"),

    /**
     * 日本語形式: Year年Month月Day日（曜日） Hour時Minute分Second秒
     */
    JP_YYYYMMDDE_HHMMSS("yyyy年M月d日（E）H時m分s秒"),
    ;
}