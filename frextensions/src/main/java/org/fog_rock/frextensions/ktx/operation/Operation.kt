package org.fog_rock.frextensions.ktx.operation

fun andAll(vararg flags: Boolean?): Boolean? {
    var ret: Boolean? = null
    flags.forEach {
        ret = if (it != null) ret?.and(it) ?: it else ret
    }
    return ret
}

fun orAll(vararg flags: Boolean?): Boolean? {
    var ret: Boolean? = null
    flags.forEach {
        ret = if (it != null) ret?.or(it) ?: it else ret
    }
    return ret
}

fun xorAll(vararg flags: Boolean?): Boolean? {
    var ret: Boolean? = null
    flags.forEach {
        ret = if (it != null) ret?.xor(it) ?: it else ret
    }
    return ret
}