package org.fog_rock.frextensions.kotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.util.*

class DateTest {

    // 2021/06/01 04:23:57.558 JST
    // 2021/05/31 19:23:57.558 UTC
    private val dateLong = 1622489037558L

    // Cutoff milli seconds.
    private val dateLongCutMillis = 1622489037000L

    /**
     * Long.toDefaultDateString(): 正常系
     */
    @Test fun toDefaultDateString_default() {
        val dateString = dateLong.toDefaultDateString(FORMAT_YYYYMMDD_HHMMSS_SSS)
        assertEquals("2021/06/01 04:23:57.558", dateString)
    }
    /**
     * Long.toDefaultDateString(): 正常系、日本語ロケール
     */
    @Test fun toDefaultDateString_localeJPN() {
        val dateString = dateLong.toDefaultDateString(FORMAT_JP_YYYYMMDDE_HHMMSS, Locale.JAPAN)
        assertEquals("2021年6月1日（火）4時23分57秒", dateString)
    }

    /**
     * Long.toUtcDateString(): 正常系
     */
    @Test fun toUtcDateString_default() {
        val dateString = dateLong.toUtcDateString()
        assertEquals("2021-05-31T19:23:57.558Z", dateString)
    }
    /**
     * Long.toUtcDateString(): 正常系、別フォーマット
     */
    @Test fun toUtcDateString_format() {
        val dateString = dateLong.toUtcDateString(FORMAT_YYYYMMDD_HHMMSS)
        assertEquals("2021/05/31 19:23:57", dateString)
    }

    /**
     * Long.toDateString(): 正常系
     */
    @Test fun toDateString_variety() {
        val dateString = dateLong.toDateString(
            "EEE, M/d/yyyy HH:mm:ss", Locale.US, TimeZone.getTimeZone("America/Anguilla"))
        assertEquals("Mon, 5/31/2021 15:23:57", dateString)
    }
    /**
     * Long.toDateString(): 異常系、タイムゾーンミス
     */
    @Test fun toDateString_wrongTimeZone() {
        val dateString = dateLong.toDateString(
            "EEE, M/d/yyyy HH:mm:ss", Locale.US, TimeZone.getTimeZone("Invalid"))
        assertEquals("Mon, 5/31/2021 19:23:57", dateString)
    }

    /**
     * String.defaultToDate(): 正常系
     */
    @Test fun defaultToDate_default() {
        val dateString = "2021/06/01 04:23:57.558"
        val date = dateString.defaultToDate(FORMAT_YYYYMMDD_HHMMSS_SSS)
        assertEquals(dateLong, date?.time)
    }
    /**
     * String.defaultToDate(): 正常系、日本語ロケール
     */
    @Test fun defaultToDate_localeJPN() {
        val dateString = "2021年6月1日（火）4時23分57秒"
        val date = dateString.defaultToDate(FORMAT_JP_YYYYMMDDE_HHMMSS, Locale.JAPAN)
        assertEquals(dateLongCutMillis, date?.time)
    }

    /**
     * String.utcToDate(): 正常系
     */
    @Test fun utcToDate_default() {
        val dateString = "2021-05-31T19:23:57.558Z"
        val date = dateString.utcToDate()
        assertEquals(dateLong, date?.time)
    }
    /**
     * String.utcToDate(): 正常系、別フォーマット
     */
    @Test fun utcToDate_format() {
        val dateString = "2021/05/31 19:23:57"
        val date = dateString.utcToDate(FORMAT_YYYYMMDD_HHMMSS)
        assertEquals(dateLongCutMillis, date?.time)
    }

    /**
     * String.toDate(): 正常系
     */
    @Test fun toDate_variety() {
        val dateString = "Mon, 5/31/2021 15:23:57"
        val date = dateString.toDate(
            "EEE, M/d/yyyy HH:mm:ss", Locale.US, TimeZone.getTimeZone("America/Anguilla"))
        assertEquals(dateLongCutMillis, date?.time)
    }
    /**
     * String.toDate(): 異常系、フォーマットミス
     */
    @Test fun toDate_wrongFormat() {
        val dateString = "Mon, 5/31/2021 15:23:57"
        val date = dateString.toDate(
            "M/d/yyyy HH:mm:ss", Locale.US, TimeZone.getTimeZone("America/Anguilla"))
        assertNull(date)
    }
    /**
     * String.toDate(): 異常系、タイムゾーンミス
     */
    @Test fun toDate_wrongTimeZone() {
        val dateString = "Mon, 5/31/2021 19:23:57"
        val date = dateString.toDate(
            "EEE, M/d/yyyy HH:mm:ss", Locale.US, TimeZone.getTimeZone("Invalid"))
        assertEquals(dateLongCutMillis, date?.time)
    }
}