package org.fog_rock.frextensions.ktx.date

/**
 * ミリ秒時間
 * @param millis ミリ秒
 */
enum class FRTimeMillis(val millis: Long) {
    /**
     * 秒
     */
    SECOND(1000L),

    /**
     * 分
     */
    MINUTE(60 * SECOND.millis),

    /**
     * 時間
     */
    HOUR(60 * MINUTE.millis),

    /**
     * 日
     */
    DAY(24 * HOUR.millis),
    ;
}