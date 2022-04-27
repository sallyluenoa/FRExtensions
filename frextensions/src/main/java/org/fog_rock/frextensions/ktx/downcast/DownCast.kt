/**
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

package org.fog_rock.frextensions.ktx.downcast

/**
 * Downcast any objects to a specified typed array safely.
 * @return A typed array if the object inherits the specified array type, or null otherwise.
 */
inline fun <reified T> Any?.downCastArray(): Array<T>? {
    val tmp = this as? Array<*> ?: return null
    var array = emptyArray<T>()
    for (value in tmp) {
        if (value is T) array += value
        else return null
    }
    return array
}

/**
 * Downcast any objects to a specified typed list safely.
 * @return A typed list if the object inherits the specified list type, or null otherwise.
 */
inline fun <reified E> Any?.downCastList(): List<E>? {
    val tmp = this as? List<*> ?: return null
    val list = mutableListOf<E>()
    for (value in tmp) {
        if (value is E) list += value
        else return null
    }
    return list.toList()
}

/**
 * Downcast any objects to a specified typed set safely.
 * @return A typed set if the object inherits the specified set type, or null otherwise.
 */
inline fun <reified E> Any?.downCastSet(): Set<E>? {
    val tmp = this as? Set<*> ?: return null
    val set = mutableSetOf<E>()
    for (value in tmp) {
        if (value is E) set += value
        else return null
    }
    return set.toSet()
}

/**
 * Downcast any objects to a specified typed map safely.
 * @return A typed map if the object inherits the specified map type, or null otherwise.
 */
inline fun <reified K, reified V> Any?.downCastMap(): Map<K, V>? {
    val tmp = this as? Map<*, *> ?: return null
    val map = mutableMapOf<K, V>()
    for ((key, value) in tmp) {
        if (key is K && value is V) map[key] = value
        else return null
    }
    return map.toMap()
}