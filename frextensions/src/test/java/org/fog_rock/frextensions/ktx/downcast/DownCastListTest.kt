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
 * @see org.fog_rock.frextensions.ktx.downcast.downCastList
 */
class DownCastListTest : DownCastTest() {

    /**
     * Normal case
     */
    @Test fun downCastList_ok() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastList<String>()).isEqualTo(strList)
    }

    /**
     * Semi normal case: Empty list
     */
    @Test fun downCastList_emptyList() {
        val emptyList = emptyList<String>()
        anyObject = emptyList
        Truth.assertThat(anyObject.downCastList<String>()).isEqualTo(emptyList)
    }

    /**
     * Abnormal case: Simple type, not list type
     */
    @Test fun downCastList_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * Abnormal case: Array type, not list type
     */
    @Test fun downCastList_array() {
        val strArray = arrayOf("Hello", "World", "!")
        anyObject = strArray
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch type in the list
     */
    @Test fun downCastList_missTypedList() {
        val intList = listOf(1, 2, 3)
        anyObject = intList
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * Abnormal case: Multiple types in the list
     */
    @Test fun downCastList_mixTypedList() {
        val mixList = listOf("Hello", "World", 1, "!")
        anyObject = mixList
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * Abnormal case: Null object
     */
    @Test fun downCastList_null() {
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }
}