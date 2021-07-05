package org.fog_rock.frextensions.ktx.date

import com.google.common.truth.Truth
import org.junit.Test
import java.util.*

/**
 * @see defaultToDate
 * @see utcToDate
 * @see toDate
 */
class StringToDateTest : DateTest() {

    /**
     * String.defaultToDate(): 正常系
     */
    @Test
    fun defaultToDate_default() {
        Truth.assertThat("2021/06/01 04:23:57.558"
            .defaultToDate(FRDateFormat.YYYYMMDD_HHMMSS_SSS.format))
            .isEqualTo(date)
    }
    /**
     * String.defaultToDate(): 正常系、日本語ロケール
     */
    @Test
    fun defaultToDate_localeJPN() {
        Truth.assertThat("2021年6月1日（火）4時23分57秒"
            .defaultToDate(FRDateFormat.JP_YYYYMMDDE_HHMMSS.format, Locale.JAPAN))
            .isEqualTo(dateCutMillis)
    }

    /**
     * String.utcToDate(): 正常系
     */
    @Test
    fun utcToDate_default() {
        Truth.assertThat("2021-05-31T19:23:57.558Z".utcToDate())
            .isEqualTo(date)
    }
    /**
     * String.utcToDate(): 正常系、別フォーマット
     */
    @Test
    fun utcToDate_format() {
        Truth.assertThat("2021/05/31 19:23:57".utcToDate(FRDateFormat.YYYYMMDD_HHMMSS.format))
            .isEqualTo(dateCutMillis)
    }

    /**
     * String.toDate(): 正常系
     */
    @Test
    fun toDate_variety() {
        Truth.assertThat("Mon, 5/31/2021 15:23:57"
            .toDate("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isEqualTo(dateCutMillis)
    }
    /**
     * String.toDate(): 異常系、フォーマットミス
     */
    @Test
    fun toDate_wrongFormat() {
        Truth.assertThat("Mon, 5/31/2021 15:23:57"
            .toDate("M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isNull()
    }
    /**
     * String.toDate(): 異常系、タイムゾーンミス
     */
    @Test
    fun toDate_wrongTimeZone() {
        Truth.assertThat("Mon, 5/31/2021 19:23:57"
            .toDate("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("Invalid")))
            .isEqualTo(dateCutMillis)
    }
}