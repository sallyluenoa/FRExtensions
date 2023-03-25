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

package org.fog_rock.frextensions.ktx.nonnull

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see org.fog_rock.frextensions.ktx.nonnull.toNonNull
 */
class NonNullObjectTest {

    /**
     * T?.toNonNull(default: T): Normal case 1
     */
    @Test
    fun tmp_toNonNull_normal1() {
        val obj: Any? = "Hello World!"
        Truth.assertThat(obj.toNonNull("Test")).isEqualTo("Hello World!")
    }

    /**
     * T?.toNonNull(default: T): Normal case 2
     */
    @Test
    fun tmp_toNonNull_normal2() {
        val obj: Any? = ""
        Truth.assertThat(obj.toNonNull("Test")).isEqualTo("")
    }

    /**
     * T?.toNonNull(default: T): Null case
     */
    @Test
    fun tmp_toNonNull_null() {
        val obj: Any? = null
        Truth.assertThat(obj.toNonNull("Test")).isEqualTo("Test")
    }

    /**
     * String?.toNonNull(): Normal string
     */
    @Test
    fun string_toNonNull_normal() {
        val str: String? = "Hello World!"
        Truth.assertThat(str.toNonNull()).isEqualTo("Hello World!")
    }

    /**
     * String?.toNonNull(): Empty string
     */
    @Test
    fun string_toNonNull_empty() {
        val str: String? = ""
        Truth.assertThat(str.toNonNull()).isEmpty()
    }

    /**
     * String?.toNonNull(): Null
     */
    @Test
    fun string_toNonNull_null() {
        val str: String? = null
        Truth.assertThat(str.toNonNull()).isEmpty()
    }

    /**
     * Array<T>?.toNonNull(): Normal array
     */
    @Test
    fun array_toNonNull_normal() {
        val array: Array<String>? = arrayOf("Hello", "World", "!")
        Truth.assertThat(array.toNonNull()).isEqualTo(arrayOf("Hello", "World", "!"))
    }

    /**
     * Array<T>?.toNonNull(): Empty array
     */
    @Test
    fun array_toNonNull_empty() {
        val array: Array<String>? = emptyArray()
        Truth.assertThat(array.toNonNull()).isEmpty()
    }

    /**
     * Array<T>?.toNonNull(): Null
     */
    @Test
    fun array_toNonNull_null() {
        val array: Array<String>? = null
        Truth.assertThat(array.toNonNull()).isEmpty()
    }

    /**
     * List<E>?.toNonNull(): Normal list
     */
    @Test
    fun list_toNonNull_normal() {
        val list: List<String>? = listOf("Hello", "World", "!")
        Truth.assertThat(list.toNonNull()).isEqualTo(listOf("Hello", "World", "!"))
    }

    /**
     * List<E>?.toNonNull(): Empty list
     */
    @Test
    fun list_toNonNull_empty() {
        val list: List<String>? = emptyList()
        Truth.assertThat(list.toNonNull()).isEmpty()
    }

    /**
     * List<E>?.toNonNull(): Null
     */
    @Test
    fun list_toNonNull_null() {
        val list: List<String>? = null
        Truth.assertThat(list.toNonNull()).isEmpty()
    }

    /**
     * Set<E>?.toNonNull(): Normal set
     */
    @Test
    fun set_toNonNull_normal() {
        val set: Set<String>? = setOf("Hello", "World", "!")
        Truth.assertThat(set.toNonNull()).isEqualTo(setOf("Hello", "World", "!"))
    }

    /**
     * Set<E>?.toNonNull(): Empty set
     */
    @Test
    fun set_toNonNull_empty() {
        val set: Set<String>? = emptySet()
        Truth.assertThat(set.toNonNull()).isEmpty()
    }

    /**
     * Set<E>?.toNonNull(): Null
     */
    @Test
    fun set_toNonNull_null() {
        val set: Set<String>? = null
        Truth.assertThat(set.toNonNull()).isEmpty()
    }

    /**
     * Map<K, V>?.toNonNull(): Normal map
     */
    @Test
    fun map_toNonNull_normal() {
        val map: Map<String, String>? = mapOf(
            "Hello" to "1",
            "World" to "2",
            "!" to "3"
        )
        Truth.assertThat(map.toNonNull()).isEqualTo(
            mapOf(
                "Hello" to "1",
                "World" to "2",
                "!" to "3"
            )
        )
    }

    /**
     * Map<K, V>?.toNonNull(): Empty map
     */
    @Test
    fun map_toNonNull_empty() {
        val map: Map<String, String>? = emptyMap()
        Truth.assertThat(map.toNonNull()).isEmpty()
    }

    /**
     * Map<K, V>?.toNonNull(): Null
     */
    @Test
    fun map_toNonNull_null() {
        val map: Map<String, String>? = null
        Truth.assertThat(map.toNonNull()).isEmpty()
    }
}