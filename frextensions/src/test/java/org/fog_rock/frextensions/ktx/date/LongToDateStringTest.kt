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
 * @see org.fog_rock.frextensions.ktx.date.toDefaultDateString
 * @see org.fog_rock.frextensions.ktx.date.toUtcDateString
 * @see org.fog_rock.frextensions.ktx.date.toDateString
 */
class LongToDateStringTest {

    // 2021/06/01 04:23:57.558 JST
    // 2021/05/31 19:23:57.558 UTC
    private val dateLong = 1622489037558L

    /**
     * Long.toDefaultDateString(): Normal case
     */
    @Test fun toDefaultDateString_default() {
        Truth.assertThat(dateLong.toDefaultDateString(FRDateFormat.YYYYMMDD_HHMMSS_SSS.format))
            .isEqualTo("2021/06/01 04:23:57.558")
    }
    /**
     * Long.toDefaultDateString(): Normal case with JPN locale
     */
    @Test fun toDefaultDateString_localeJPN() {
        Truth.assertThat(dateLong
            .toDefaultDateString(FRDateFormat.JP_YYYYMMDDE_HHMMSS.format, Locale.JAPAN))
            .isEqualTo("2021年6月1日（火）4時23分57秒")
    }

    /**
     * Long.toUtcDateString(): Normal case
     */
    @Test fun toUtcDateString_default() {
        Truth.assertThat(dateLong.toUtcDateString())
            .isEqualTo("2021-05-31T19:23:57.558Z")
    }
    /**
     * Long.toUtcDateString(): Normal case with another format
     */
    @Test fun toUtcDateString_format() {
        Truth.assertThat(dateLong.toUtcDateString(FRDateFormat.YYYYMMDD_HHMMSS.format))
            .isEqualTo("2021/05/31 19:23:57")
    }

    /**
     * Long.toDateString(): Normal case
     */
    @Test fun toDateString_variety() {
        Truth.assertThat(dateLong
            .toDateString("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("America/Anguilla")))
            .isEqualTo("Mon, 5/31/2021 15:23:57")
    }
    /**
     * Long.toDateString(): Abnormal case with timezone mistake
     */
    @Test fun toDateString_wrongTimeZone() {
        Truth.assertThat(dateLong
            .toDateString("EEE, M/d/yyyy HH:mm:ss", Locale.US,
                TimeZone.getTimeZone("Invalid")))
            .isEqualTo("Mon, 5/31/2021 19:23:57")
    }
}