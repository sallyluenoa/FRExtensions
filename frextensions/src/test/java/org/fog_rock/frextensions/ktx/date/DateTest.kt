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