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
class DownCastArrayTest : DownCastTest() {

    /**
     * Normal case
     */
    @Test fun downCastArray_ok() {
        val strArray = arrayOf("Hello", "World", "!")
        anyObject = strArray
        Truth.assertThat(anyObject.downCastArray<String>()).isEqualTo(strArray)
    }

    /**
     * Semi normal case: Empty array
     */
    @Test fun downCastArray_emptyArray() {
        val emptyArray = emptyArray<String>()
        anyObject = emptyArray
        Truth.assertThat(anyObject.downCastArray<String>()).isEqualTo(emptyArray)
    }

    /**
     * Abnormal case: Simple type, not array type
     */
    @Test fun downCastArray_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: List type, not array type
     */
    @Test fun downCastArray_list() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch type in the array
     */
    @Test fun downCastArray_missTypedArray() {
        val intArray = arrayOf(1, 2, 3)
        anyObject = intArray
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: Multiple types in the array
     */
    @Test fun downCastArray_mixTypedArray() {
        val mixArray = arrayOf("Hello", "World", 1, "!")
        anyObject = mixArray
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * Abnormal case: Null object
     */
    @Test fun downCastArray_null() {
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }
}