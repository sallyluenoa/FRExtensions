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
class NonNullPrimitiveTest {

    /**
     * Boolean?.toNonNull(): True
     */
    @Test fun boolean_toNonNull_true() {
        val boolean: Boolean? = true
        Truth.assertThat(boolean.toNonNull()).isTrue()
    }
    /**
     * Boolean?.toNonNull(): False
     */
    @Test fun boolean_toNonNull_false() {
        val boolean: Boolean? = false
        Truth.assertThat(boolean.toNonNull()).isFalse()
    }
    /**
     * Boolean?.toNonNull(): Null
     */
    @Test fun boolean_toNonNull_null() {
        val boolean: Boolean? = null
        Truth.assertThat(boolean.toNonNull()).isFalse()
    }

    /**
     * Int?.toNonNull(): 1
     */
    @Test fun int_toNonNull_one() {
        val int: Int? = 1
        Truth.assertThat(int.toNonNull()).isEqualTo(1)
    }
    /**
     * Int?.toNonNull(): 0
     */
    @Test fun int_toNonNull_zero() {
        val int: Int? = 0
        Truth.assertThat(int.toNonNull()).isEqualTo(0)
    }
    /**
     * Int?.toNonNull(): Null
     */
    @Test fun int_toNonNull_null() {
        val int: Int? = null
        Truth.assertThat(int.toNonNull()).isEqualTo(0)
    }

    /**
     * Long?.toNonNull(): 1
     */
    @Test fun long_toNonNull_one() {
        val long: Long? = 1L
        Truth.assertThat(long.toNonNull()).isEqualTo(1L)
    }
    /**
     * Long?.toNonNull(): 0
     */
    @Test fun long_toNonNull_zero() {
        val long: Long? = 0L
        Truth.assertThat(long.toNonNull()).isEqualTo(0L)
    }
    /**
     * Long?.toNonNull(): Null
     */
    @Test fun long_toNonNull_null() {
        val long: Long? = null
        Truth.assertThat(long.toNonNull()).isEqualTo(0L)
    }

    /**
     * Float?.toNonNull(): 1.0
     */
    @Test fun float_toNonNull_one() {
        val float: Float? = 1.0f
        Truth.assertThat(float.toNonNull()).isEqualTo(1.0f)
    }
    /**
     * Float?.toNonNull(): 0.0
     */
    @Test fun float_toNonNull_zero() {
        val float: Float? = 0.0f
        Truth.assertThat(float.toNonNull()).isZero()
    }
    /**
     * Float?.toNonNull(): Null
     */
    @Test fun float_toNonNull_null() {
        val float: Float? = null
        Truth.assertThat(float.toNonNull()).isZero()
    }

    /**
     * Double?.toNonNull(): 1.0
     */
    @Test fun double_toNonNull_one() {
        val double: Double? = 1.0
        Truth.assertThat(double.toNonNull()).isEqualTo(1.0)
    }
    /**
     * Double?.toNonNull(): 0.0
     */
    @Test fun double_toNonNull_zero() {
        val double: Double? = 0.0
        Truth.assertThat(double.toNonNull()).isZero()
    }
    /**
     * Double?.toNonNull(): Null
     */
    @Test fun double_toNonNull_null() {
        val double: Double? = null
        Truth.assertThat(double.toNonNull()).isZero()
    }
}