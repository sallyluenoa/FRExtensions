package org.fog_rock.frextensions.ktx.date

/**
 * An enum class for time millis.
 * @param millis A time of Milli seconds.
 */
enum class FRTimeMillis(val millis: Long) {
    /**
     * A second
     */
    SECOND(1000L),

    /**
     * A minute
     */
    MINUTE(60 * SECOND.millis),

    /**
     * An hour
     */
    HOUR(60 * MINUTE.millis),

    /**
     * A day
     */
    DAY(24 * HOUR.millis),
    ;
}