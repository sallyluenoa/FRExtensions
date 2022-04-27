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

package org.fog_rock.frextensions.ktx.operation

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see xorAll
 */
class XorAllTest {

    /**
     * True only
     */
    @Test fun xorAll_true() {
        Truth.assertThat(xorAll(true)).isTrue()
    }

    /**
     * False only
     */
    @Test fun xorAll_false() {
        Truth.assertThat(xorAll(false)).isFalse()
    }

    /**
     * Null only
     */
    @Test fun xorAll_null() {
        Truth.assertThat(xorAll(null)).isNull()
    }

    /**
     * Empty
     */
    @Test fun xorAll_empty()  {
        Truth.assertThat(xorAll()).isNull()
    }

    /**
     * True 2, false 1
     */
    @Test fun xorAll_trueTrueFalse() {
        Truth.assertThat(xorAll(true, false, true)).isFalse()
    }

    /**
     * True 1, false 2
     */
    @Test fun xorAll_trueFalseFalse() {
        Truth.assertThat(xorAll(false, false, true)).isTrue()
    }

    /**
     * True all
     */
    @Test fun xorAll_trueTrueTrue() {
        Truth.assertThat(xorAll(true, true, true)).isTrue()
    }

    /**
     * False all
     */
    @Test fun xorAll_FalseFalseFalse() {
        Truth.assertThat(xorAll(false, false, false)).isFalse()
    }

    /**
     * True 1, false 1, null 1
     */
    @Test fun xorAll_TrueFalseNull() {
        Truth.assertThat(xorAll(true, null, false)).isTrue()
    }

    /**
     * True 2, null 1
     */
    @Test fun xorAll_TrueTrueNull() {
        Truth.assertThat(xorAll(true, null, true)).isFalse()
    }

    /**
     * False 2, null 1
     */
    @Test fun xorAll_FalseFalseNull() {
        Truth.assertThat(xorAll(null, false, false)).isFalse()
    }

    /**
     * Null all
     */
    @Test fun xorAll_NullNullNull() {
        Truth.assertThat(xorAll(null, null, null)).isNull()
    }
}