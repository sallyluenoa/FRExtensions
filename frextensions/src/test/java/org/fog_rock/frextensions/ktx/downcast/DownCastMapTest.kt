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
class DownCastMapTest {

    /**
     * Normal case
     */
    @Test
    fun downCastMap_ok() {
        val obj: Any = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            "!" to "!",
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isEqualTo(
            mapOf(
                "Hello" to "Hello",
                "World" to "World",
                "!" to "!",
            )
        )
    }

    /**
     * Semi normal case: Empty map
     */
    @Test fun downCastMap_emptyMap() {
        val obj: Any = emptyMap<String, String>()
        Truth.assertThat(obj.downCastMap<String, String>()).isEqualTo(emptyMap<String, String>())
    }

    /**
     * Abnormal case: Simple type, not map type
     */
    @Test fun downCastMap_singleType() {
        val obj: Any = "Hello World!"
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Set type, not map type
     */
    @Test fun downCastMap_set() {
        val obj: Any = setOf("Hello", "World", "!")
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch key type in the map
     */
    @Test fun downCastMap_missTypedKey() {
        val obj: Any = mapOf(
            1 to "Hello",
            2 to "World",
            3 to "!",
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch value type in the map
     */
    @Test fun downCastMap_missTypedValue() {
        val obj: Any = mapOf(
            "Hello" to 1,
            "World" to 2,
            "!" to 3,
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch key and value types in the map
     */
    @Test fun downCastMap_missTypedKeyValue() {
        val obj: Any = mapOf(
            1 to 1,
            2 to 2,
            3 to 3,
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Multiple key types in the map
     */
    @Test fun downCastMap_mixTypedKey() {
        val obj: Any = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            1 to "1",
            "!" to "!",
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Multiple value types in the map
     */
    @Test fun downCastMap_mixTypedValue() {
        val obj: Any = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            "1" to 1,
            "!" to "!",
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Multiple key and value types in the map
     */
    @Test fun downCastMap_mixTypedKeyValue() {
        val obj: Any = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            1 to 1,
            "!" to "!",
        )
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }

    /**
     * Abnormal case: Null object
     */
    @Test fun downCastMap_null() {
        val obj: Any? = null
        Truth.assertThat(obj.downCastMap<String, String>()).isNull()
    }
}