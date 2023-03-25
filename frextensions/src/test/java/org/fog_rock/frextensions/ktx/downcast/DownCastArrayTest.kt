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
 * @see org.fog_rock.frextensions.ktx.downcast.downCastArray
 */
class DownCastArrayTest {

    /**
     * Normal case
     */
    @Test
    fun downCastArray_ok() {
        val obj: Any = arrayOf("Hello", "World", "!")
        Truth.assertThat(obj.downCastArray<String>()).isEqualTo(arrayOf("Hello", "World", "!"))
    }

    /**
     * Semi normal case: Empty array
     */
    @Test
    fun downCastArray_emptyArray() {
        val obj: Any = emptyArray<String>()
        Truth.assertThat(obj.downCastArray<String>()).isEqualTo(emptyArray<String>())
    }

    /**
     * Abnormal case: Simple type, not array type
     */
    @Test
    fun downCastArray_singleType() {
        val obj: Any = "Hello World!"
        Truth.assertThat(obj.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: List type, not array type
     */
    @Test
    fun downCastArray_list() {
        val obj: Any = listOf("Hello", "World", "!")
        Truth.assertThat(obj.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch type in the array
     */
    @Test
    fun downCastArray_missTypedArray() {
        val obj: Any = arrayOf(1, 2, 3)
        Truth.assertThat(obj.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: Multiple types in the array
     */
    @Test
    fun downCastArray_mixTypedArray() {
        val obj: Any = arrayOf("Hello", "World", 1, "!")
        Truth.assertThat(obj.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: Null object
     */
    @Test
    fun downCastArray_null() {
        val obj: Any? = null
        Truth.assertThat(obj.downCastArray<String>()).isNull()
    }
}