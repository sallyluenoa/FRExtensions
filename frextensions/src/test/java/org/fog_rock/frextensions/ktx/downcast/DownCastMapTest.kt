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

package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see org.fog_rock.frextensions.ktx.downcast.downCastMap
 */
class DownCastMapTest : DownCastTest() {

    /**
     * Normal case
     */
    @Test
    fun downCastMap_ok() {
        val strMap = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            "!" to "!",
        )
        anyObject = strMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isEqualTo(strMap)
    }

    /**
     * Semi normal case: Empty map
     */
    @Test fun downCastMap_emptyMap() {
        val emptyMap = emptyMap<String, String>()
        anyObject = emptyMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isEqualTo(emptyMap)
    }

    /**
     * Abnormal case: Simple type, not map type
     */
    @Test fun downCastMap_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Set type, not map type
     */
    @Test fun downCastMap_set() {
        val strSet = setOf("Hello", "World", "!")
        anyObject = strSet
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch key type in the map
     */
    @Test fun downCastMap_missTypedKey() {
        val intKeyMap = mapOf(
            1 to "Hello",
            2 to "World",
            3 to "!",
        )
        anyObject = intKeyMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch value type in the map
     */
    @Test fun downCastMap_missTypedValue() {
        val intValueMap = mapOf(
            "Hello" to 1,
            "World" to 2,
            "!" to 3,
        )
        anyObject = intValueMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch key and value types in the map
     */
    @Test fun downCastMap_missTypedKeyValue() {
        val intMap = mapOf(
            1 to 1,
            2 to 2,
            3 to 3,
        )
        anyObject = intMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Multiple key types in the map
     */
    @Test fun downCastMap_mixTypedKey() {
        val mixMap = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            1 to "1",
            "!" to "!",
        )
        anyObject = mixMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Multiple value types in the map
     */
    @Test fun downCastMap_mixTypedValue() {
        val mixMap = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            "1" to 1,
            "!" to "!",
        )
        anyObject = mixMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Multiple key and value types in the map
     */
    @Test fun downCastMap_mixTypedKeyValue() {
        val mixMap = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            1 to 1,
            "!" to "!",
        )
        anyObject = mixMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Null object
     */
    @Test fun downCastMap_null() {
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }
}