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