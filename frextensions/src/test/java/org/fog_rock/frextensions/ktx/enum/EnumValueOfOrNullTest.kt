/*
 * Copyright (c) 2022 SallyLueNoa
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

package org.fog_rock.frextensions.ktx.enum

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see org.fog_rock.frextensions.ktx.enum.valueOfOrNull
 */
class EnumValueOfOrNullTest {

    /**
     * Int -> Enum: Normal case 1
     */
    @Test
    fun int_valueOfOrNull_normal1() {
        val color: IntColor? = valueOfOrNull(0)
        Truth.assertThat(color).isEqualTo(IntColor.RED)
    }

    /**
     * Int -> Enum: Normal case 2
     */
    @Test
    fun int_valueOfOrNull_normal2() {
        Truth.assertThat(valueOfOrNull<IntColor, Int>(1)).isEqualTo(IntColor.GREEN)
    }

    /**
     * Int -> Enum: Null
     */
    @Test
    fun int_valueOfOrNull_null() {
        val color: IntColor? = valueOfOrNull(-1)
        Truth.assertThat(color).isNull()
    }

    /**
     * String -> Enum: Normal case 1
     */
    @Test
    fun string_valueOfOrNull_normal1() {
        val color: StringColor? = valueOfOrNull("#FF0000")
        Truth.assertThat(color).isEqualTo(StringColor.RED)
    }

    /**
     * String -> Enum: Normal case 2
     */
    @Test
    fun string_valueOfOrNull_normal2() {
        Truth.assertThat(valueOfOrNull<StringColor, String>("#008000"))
            .isEqualTo(StringColor.GREEN)
    }

    /**
     * String -> Enum: Null
     */
    @Test
    fun string_valueOfOrNull_null() {
        val color: StringColor? = valueOfOrNull("#000000")
        Truth.assertThat(color).isNull()
    }
}