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

import java.util.*

open class DateTest {

    // 2021/06/01 04:23:57.558 JST
    // 2021/05/31 19:23:57.558 UTC
    protected val dateLong = 1622489037558L
    protected val date = Date(dateLong)

    // Cutoff milli seconds.
    protected val dateLongCutMillis = 1622489037000L
    protected val dateCutMillis = Date(dateLongCutMillis)

}