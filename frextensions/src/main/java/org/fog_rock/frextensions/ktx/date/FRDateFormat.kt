package org.fog_rock.frextensions.ktx.date

/**
 * An enum class for date formats.
 * @param format A format string
 */
enum class FRDateFormat(val format: String) {
    /**
     * ISO 8601
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
     * Year年Month月Day日（曜日）
     * Note that JP locale is required.
     */
    JP_YYYYMMDDE("yyyy年M月d日（E）"),

    /**
     * Year年Month月Day日（曜日） Hour時Minute分Second秒
     * Note that JP locale is required.
     */
    JP_YYYYMMDDE_HHMMSS("yyyy年M月d日（E）H時m分s秒"),
    ;
}