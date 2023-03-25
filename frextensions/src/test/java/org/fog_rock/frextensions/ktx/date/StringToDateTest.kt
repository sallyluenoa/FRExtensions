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

import com.google.common.truth.Truth
import org.junit.Test
import java.util.*

/**
 * @see org.fog_rock.frextensions.ktx.date.defaultToDate
 * @see org.fog_rock.frextensions.ktx.date.utcToDate
 * @see org.fog_rock.frextensions.ktx.date.toDate
 */
class StringToDateTest {

    /**
     * String.defaultToDate(): Normal case
     */
    @Test
    fun defaultToDate_default() {
        Truth.assertThat("2021/06/01 04:23:57.558"
            .defaultToDate(FRDateFormat.YYYYMMDD_HHMMSS_SSS.format))
            .isEqualTo(Date(1622489037558L))
    }

    /**
     * String.defaultToDate(): Normal case with JPN locale
     */
    @Test
    fun defaultToDate_localeJPN() {
        Truth.assertThat("2021年6月1日（火）4時23分57秒"
            .defaultToDate(FRDateFormat.JP_YYYYMMDDE_HHMMSS.format, Locale.JAPAN))
            .isEqualTo(Date(1622489037000L))
    }

    /**
     * String.utcToDate(): Normal case
     */
    @Test
    fun utcToDate_default() {
        Truth.assertThat("2021-05-31T19:23:57.558Z".utcToDate())
            .isEqualTo(Date(1622489037558L))
    }

    /**
     * String.utcToDate(): Normal case with another format
     */
    @Test
    fun utcToDate_format() {
        Truth.assertThat("2021/05/31 19:23:57".utcToDate(FRDateFormat.YYYYMMDD_HHMMSS.format))
            .isEqualTo(Date(1622489037000L))
    }

    /**
     * String.toDate(): Normal case
     */
    @Test
    fun toDate_variety() {
        Truth.assertThat("Mon, 5/31/2021 15:23:57"
            .toDate("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isEqualTo(Date(1622489037000L))
    }

    /**
     * String.toDate(): Abnormal case with format mistake
     */
    @Test
    fun toDate_wrongFormat() {
        Truth.assertThat("Mon, 5/31/2021 15:23:57"
            .toDate("M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isNull()
    }

    /**
     * String.toDate(): Abnormal case with timezone mistake
     */
    @Test
    fun toDate_wrongTimeZone() {
        Truth.assertThat("Mon, 5/31/2021 19:23:57"
            .toDate("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("Invalid")))
            .isEqualTo(Date(1622489037000L))
    }
}