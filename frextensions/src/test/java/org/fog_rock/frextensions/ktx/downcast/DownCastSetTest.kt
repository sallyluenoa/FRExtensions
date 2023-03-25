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
 * @see org.fog_rock.frextensions.ktx.downcast.downCastSet
 */
class DownCastSetTest {

    /**
     * Normal case
     */
    @Test fun downCastSet_ok() {
        val obj: Any = setOf("Hello", "World", "!")
        Truth.assertThat(obj.downCastSet<String>()).isEqualTo(setOf("Hello", "World", "!"))
    }

    /**
     * Semi normal case: Empty set
     */
    @Test fun downCastSet_emptySet() {
        val obj: Any = emptySet<String>()
        Truth.assertThat(obj.downCastSet<String>()).isEqualTo(emptySet<String>())
    }

    /**
     * Abnormal case: Simple type, not set type
     */
    @Test fun downCastSet_singleType() {
        val obj: Any = "Hello World!"
        Truth.assertThat(obj.downCastSet<String>()).isNull()
    }

    /**
     * Abnormal case: List type, not set type
     */
    @Test fun downCastSet_list() {
        val obj: Any = listOf("Hello", "World", "!")
        Truth.assertThat(obj.downCastSet<String>()).isNull()
    }

    /**
     * Abnormal case: Mismatch type in the set
     */
    @Test fun downCastSet_missTypedSet() {
        val obj: Any = setOf(1, 2, 3)
        Truth.assertThat(obj.downCastSet<String>()).isNull()
    }

    /**
     * Abnormal case: Multiple types in the set
     */
    @Test fun downCastSet_mixTypedSet() {
        val obj: Any = setOf("Hello", "World", 1, "!")
        Truth.assertThat(obj.downCastSet<String>()).isNull()
    }

    /**
     * Abnormal case: Null object
     */
    @Test fun downCastSet_null() {
        val obj: Any? = null
        Truth.assertThat(obj.downCastSet<String>()).isNull()
    }
}