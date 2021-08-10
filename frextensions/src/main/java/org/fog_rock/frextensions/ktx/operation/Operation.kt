package org.fog_rock.frextensions.ktx.operation

/**
 * Performs logical `and` operations on multiple boolean values.
 * If a part of the values is null, it is ignored to performs the operations.
 * If there is only one valid value, the result is the value itself.
 * If all values are null or no value, the result is null.
 * @param flags Variable number of boolean values
 * @return A result of logical `and` operations, or null if all values are null or no value.
 */
fun andAll(vararg flags: Boolean?): Boolean? {
    var ret: Boolean? = null
    flags.forEach {
        ret = if (it != null) ret?.and(it) ?: it else ret
    }
    return ret
}

/**
 * Performs logical `or` operations on multiple boolean values.
 * If a part of the values is null, it is ignored to performs the operations.
 * If there is only one valid value, the result is the value itself.
 * If all values are null or no value, the result is null.
 * @param flags Variable number of boolean values
 * @return A result of logical `or` operations, or null if all values are null or no value.
 */
fun orAll(vararg flags: Boolean?): Boolean? {
    var ret: Boolean? = null
    flags.forEach {
        ret = if (it != null) ret?.or(it) ?: it else ret
    }
    return ret
}

/**
 * Performs logical `xor` operations on multiple boolean values.
 * If a part of the values is null, it is ignored to performs the operations.
 * If there is only one valid value, the result is the value itself.
 * If all values are null or no value, the result is null.
 * @param flags Variable number of boolean values
 * @return A result of logical `xor` operations, or null if all values are null or no value.
 */
fun xorAll(vararg flags: Boolean?): Boolean? {
    var ret: Boolean? = null
    flags.forEach {
        ret = if (it != null) ret?.xor(it) ?: it else ret
    }
    return ret
}