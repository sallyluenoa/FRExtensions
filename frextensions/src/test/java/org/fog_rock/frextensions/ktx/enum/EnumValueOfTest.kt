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
 * @see org.fog_rock.frextensions.ktx.enum.valueOf
 */
class EnumValueOfTest {

    /**
     * Int -> Enum: Normal case
     */
    @Test
    fun int_valueOf_normal() {
        Truth.assertThat(valueOf(2, IntColor.RED)).isEqualTo(IntColor.BLUE)
    }

    /**
     * Int -> Enum: Default value
     */
    @Test
    fun int_valueOf_defaultValue() {
        Truth.assertThat(valueOf(-1, IntColor.RED)).isEqualTo(IntColor.RED)
    }

    /**
     * String -> Enum: Normal case
     */
    @Test
    fun string_valueOf_normal() {
        Truth.assertThat(valueOf("#0000FF", StringColor.RED)).isEqualTo(StringColor.BLUE)
    }

    /**
     * String -> Enum: Default value
     */
    @Test
    fun string_valueOf_defaultValue() {
        Truth.assertThat(valueOf("#000000", StringColor.RED)).isEqualTo(StringColor.RED)
    }
}