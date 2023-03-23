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

    private var string: String? = null
    private var array: Array<String>? = null
    private var list: List<String>? = null
    private var set: Set<String>? = null
    private var map: Map<String, String>? = null

    /**
     * T?.toNonNull(default: T): Normal case 1
     */
    @Test fun tmp_toNonNull_normal1() {
        string = "Hello World!"
        Truth.assertThat(string.toNonNull("Test")).isEqualTo("Hello World!")
    }
    /**
     * T?.toNonNull(default: T): Normal case 2
     */
    @Test fun tmp_toNonNull_normal2() {
        string = ""
        Truth.assertThat(string.toNonNull("Test")).isEmpty()
    }
    /**
     * T?.toNonNull(default: T): Null case
     */
    @Test fun tmp_toNonNull_null() {
        Truth.assertThat(string).isNull()
        Truth.assertThat(string.toNonNull("Test")).isEqualTo("Test")
    }

    /**
     * String?.toNonNull(): Normal string
     */
    @Test fun string_toNonNull_normal() {
        string = "Hello World!"
        Truth.assertThat(string.toNonNull()).isEqualTo("Hello World!")
    }
    /**
     * String?.toNonNull(): Empty string
     */
    @Test fun string_toNonNull_empty() {
        string = ""
        Truth.assertThat(string.toNonNull()).isEmpty()
    }
    /**
     * String?.toNonNull(): Null
     */
    @Test fun string_toNonNull_null() {
        Truth.assertThat(string).isNull()
        Truth.assertThat(string.toNonNull()).isEmpty()
    }

    /**
     * Array<T>?.toNonNull(): Normal array
     */
    @Test fun array_toNonNull_normal() {
        val expArray = arrayOf("Hello", "World", "!")
        array = expArray
        Truth.assertThat(array.toNonNull()).isEqualTo(expArray)
    }
    /**
     * Array<T>?.toNonNull(): Empty array
     */
    @Test fun array_toNonNull_empty() {
        array = emptyArray()
        Truth.assertThat(array.toNonNull()).isEmpty()
    }
    /**
     * Array<T>?.toNonNull(): Null
     */
    @Test fun array_toNonNull_null() {
        Truth.assertThat(array).isNull()
        Truth.assertThat(array.toNonNull()).isEmpty()
    }

    /**
     * List<E>?.toNonNull(): Normal list
     */
    @Test fun list_toNonNull_normal() {
        val expList = listOf("Hello", "World", "!")
        list = expList
        Truth.assertThat(list.toNonNull()).isEqualTo(expList)
    }
    /**
     * List<E>?.toNonNull(): Empty list
     */
    @Test fun list_toNonNull_empty() {
        list = emptyList()
        Truth.assertThat(list.toNonNull()).isEmpty()
    }
    /**
     * List<E>?.toNonNull(): Null
     */
    @Test fun list_toNonNull_null() {
        Truth.assertThat(list).isNull()
        Truth.assertThat(list.toNonNull()).isEmpty()
    }

    /**
     * Set<E>?.toNonNull(): Normal set
     */
    @Test fun set_toNonNull_normal() {
        val expSet = setOf("Hello", "World", "!")
        set = expSet
        Truth.assertThat(set.toNonNull()).isEqualTo(expSet)
    }
    /**
     * Set<E>?.toNonNull(): Empty set
     */
    @Test fun set_toNonNull_empty() {
        set = emptySet()
        Truth.assertThat(set.toNonNull()).isEmpty()
    }
    /**
     * Set<E>?.toNonNull(): Null
     */
    @Test fun set_toNonNull_null() {
        Truth.assertThat(set).isNull()
        Truth.assertThat(set.toNonNull()).isEmpty()
    }

    /**
     * Map<K, V>?.toNonNull(): Normal map
     */
    @Test fun map_toNonNull_normal() {
        val expMap = mapOf(
            "Hello" to "1",
            "World" to "2",
            "!" to "3"
        )
        map = expMap
        Truth.assertThat(map.toNonNull()).isEqualTo(expMap)
    }
    /**
     * Map<K, V>?.toNonNull(): Empty map
     */
    @Test fun map_toNonNull_empty() {
        map = emptyMap()
        Truth.assertThat(map.toNonNull()).isEmpty()
    }
    /**
     * Map<K, V>?.toNonNull(): Null
     */
    @Test fun map_toNonNull_null() {
        Truth.assertThat(map).isNull()
        Truth.assertThat(map.toNonNull()).isEmpty()
    }
}