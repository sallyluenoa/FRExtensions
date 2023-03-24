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

package org.fog_rock.frextensions.androidx.os

import androidx.core.os.bundleOf
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @see org.fog_rock.frextensions.androidx.os.getSerialize
 */
@RunWith(AndroidJUnit4::class)
class BundleSerializeTest {

    private companion object {
        const val KEY_ENUM_COLOR = "enum_color"
        const val KEY_ENUM_COLOR_CODE = "enum_color_code"
        const val KEY_ENUM_COLOR_ARRAY = "enum_color_array"
        const val KEY_ENUM_COLOR_CODE_ARRAY = "enum_color_code_array"
        const val KEY_DATA_COLOR = "data_color"
        const val KEY_DATA_COLOR_CODE = "data_color_code"
        const val KEY_DATA_COLOR_ARRAY = "data_color_array"
        const val KEY_DATA_COLOR_CODE_ARRAY = "data_color_code_array"
    }

    private val bundle = run {
        val enumColor = EnumColor.RED
        val enumColorArray = EnumColor.values()
        val enumColorCodeArray = enumColorArray.map { it.code }.toTypedArray()
        val dataColor = DataColor("#000000")
        val dataColorArray = arrayOf(dataColor, DataColor("#ffffff"))
        val dataColorCodeArray = dataColorArray.map { it.code }.toTypedArray()
        bundleOf(
            KEY_ENUM_COLOR to enumColor,
            KEY_ENUM_COLOR_CODE to enumColor.code,
            KEY_ENUM_COLOR_ARRAY to enumColorArray,
            KEY_ENUM_COLOR_CODE_ARRAY to enumColorCodeArray,
            KEY_DATA_COLOR to dataColor,
            KEY_DATA_COLOR_CODE to dataColor.code,
            KEY_DATA_COLOR_ARRAY to dataColorArray,
            KEY_DATA_COLOR_CODE_ARRAY to dataColorCodeArray,
        )
    }

    /**
     * Enum type: Normal case
     */
    @Test fun getSerialize_enumOK() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(KEY_ENUM_COLOR))
            .isEqualTo(EnumColor.RED)
    }

    /**
     * Enum Type: Abnormal case (Not Serialize type)
     */
    @Test fun getSerialize_enumNG_nonSerialize() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(KEY_ENUM_COLOR_CODE))
            .isNull()
    }

    /**
     * Enum Type: Abnormal case (Another Serialize type)
     */
    @Test fun getSerialize_enumNG_otherSerialize() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(KEY_DATA_COLOR))
            .isNull()
    }

    /**
     * Data type: Normal case
     */
    @Test fun getSerialize_dataOK() {
        Truth.assertThat(bundle.getSerialize<DataColor>(KEY_DATA_COLOR))
            .isEqualTo(DataColor("#000000"))
    }

    /**
     * Data Type: Abnormal case (Not Serialize type)
     */
    @Test fun getSerialize_dataNG_nonSerialize() {
        Truth.assertThat(bundle.getSerialize<DataColor>(KEY_DATA_COLOR_CODE))
            .isNull()
    }

    /**
     * Data Type: Abnormal case (Another Serialize type)
     */
    @Test fun getSerialize_dataNG_otherSerialize() {
        Truth.assertThat(bundle.getSerialize<DataColor>(KEY_ENUM_COLOR))
            .isNull()
    }
}