package org.fog_rock.frextensions.ktx.date

import com.google.common.truth.Truth
import org.junit.Test
import java.util.*

class DateTest {

    // 2021/06/01 04:23:57.558 JST
    // 2021/05/31 19:23:57.558 UTC
    private val dateLong = 1622489037558L
    private val date = Date(dateLong)

    // Cutoff milli seconds.
    private val dateLongCutMillis = 1622489037000L
    private val dateCutMillis = Date(dateLongCutMillis)

    /**
     * Long.toDefaultDateString(): 正常系
     */
    @Test fun toDefaultDateString_default() {
        Truth.assertThat(dateLong.toDefaultDateString(FORMAT_YYYYMMDD_HHMMSS_SSS))
            .isEqualTo("2021/06/01 04:23:57.558")
    }
    /**
     * Long.toDefaultDateString(): 正常系、日本語ロケール
     */
    @Test fun toDefaultDateString_localeJPN() {
        Truth.assertThat(dateLong
            .toDefaultDateString(FORMAT_JP_YYYYMMDDE_HHMMSS, Locale.JAPAN))
            .isEqualTo("2021年6月1日（火）4時23分57秒")
    }

    /**
     * Long.toUtcDateString(): 正常系
     */
    @Test fun toUtcDateString_default() {
        Truth.assertThat(dateLong.toUtcDateString())
            .isEqualTo("2021-05-31T19:23:57.558Z")
    }
    /**
     * Long.toUtcDateString(): 正常系、別フォーマット
     */
    @Test fun toUtcDateString_format() {
        Truth.assertThat(dateLong.toUtcDateString(FORMAT_YYYYMMDD_HHMMSS))
            .isEqualTo("2021/05/31 19:23:57")
    }

    /**
     * Long.toDateString(): 正常系
     */
    @Test fun toDateString_variety() {
        Truth.assertThat(dateLong
            .toDateString("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isEqualTo("Mon, 5/31/2021 15:23:57")
    }
    /**
     * Long.toDateString(): 異常系、タイムゾーンミス
     */
    @Test fun toDateString_wrongTimeZone() {
        Truth.assertThat(dateLong
            .toDateString("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("Invalid")))
            .isEqualTo("Mon, 5/31/2021 19:23:57")
    }

    /**
     * String.defaultToDate(): 正常系
     */
    @Test fun defaultToDate_default() {
        Truth.assertThat("2021/06/01 04:23:57.558".defaultToDate(FORMAT_YYYYMMDD_HHMMSS_SSS))
            .isEqualTo(date)
    }
    /**
     * String.defaultToDate(): 正常系、日本語ロケール
     */
    @Test fun defaultToDate_localeJPN() {
        Truth.assertThat("2021年6月1日（火）4時23分57秒"
            .defaultToDate(FORMAT_JP_YYYYMMDDE_HHMMSS, Locale.JAPAN))
            .isEqualTo(dateCutMillis)
    }

    /**
     * String.utcToDate(): 正常系
     */
    @Test fun utcToDate_default() {
        Truth.assertThat("2021-05-31T19:23:57.558Z".utcToDate())
            .isEqualTo(date)
    }
    /**
     * String.utcToDate(): 正常系、別フォーマット
     */
    @Test fun utcToDate_format() {
        Truth.assertThat("2021/05/31 19:23:57".utcToDate(FORMAT_YYYYMMDD_HHMMSS))
            .isEqualTo(dateCutMillis)
    }

    /**
     * String.toDate(): 正常系
     */
    @Test fun toDate_variety() {
        Truth.assertThat("Mon, 5/31/2021 15:23:57"
            .toDate("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isEqualTo(dateCutMillis)
    }
    /**
     * String.toDate(): 異常系、フォーマットミス
     */
    @Test fun toDate_wrongFormat() {
        Truth.assertThat("Mon, 5/31/2021 15:23:57"
            .toDate("M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isNull()
    }
    /**
     * String.toDate(): 異常系、タイムゾーンミス
     */
    @Test fun toDate_wrongTimeZone() {
        Truth.assertThat("Mon, 5/31/2021 19:23:57"
            .toDate("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("Invalid")))
            .isEqualTo(dateCutMillis)
    }
}