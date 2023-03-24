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

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @see org.fog_rock.frextensions.androidx.os.getSerializeArray
 */
@RunWith(AndroidJUnit4::class)
class BundleSerializeArrayTest : BundleTest() {

    /**
     * Enum type: Normal case
     */
    @Test fun getSerializeArray_enumOK() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_ENUM_COLOR_ARRAY))
            .isEqualTo(enumColorArray)
    }

    /**
     * Enum Type: Abnormal case (Not Serialize type)
     */
    @Test fun getSerializeArray_enumNG_nonSerialize() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_ENUM_COLOR_CODE_ARRAY))
            .isNull()
    }

    /**
     * Enum Type: Abnormal case (Another Serialize type)
     */
    @Test fun getSerializeArray_enumNG_otherSerialize() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_DATA_COLOR_ARRAY))
            .isNull()
    }

    /**
     * Enum Type: Abnormal case (Not array type)
     */
    @Test fun getSerializeArray_enumNG_nonArray() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_ENUM_COLOR))
            .isNull()
    }

    /**
     * Data type: Normal case
     */
    @Test fun getSerializeArray_dataOK() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_DATA_COLOR_ARRAY))
            .isEqualTo(dataColorArray)
    }

    /**
     * Data Type: Abnormal case (Not Serialize type)
     */
    @Test fun getSerializeArray_dataNG_nonSerialize() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_DATA_COLOR_CODE_ARRAY))
            .isNull()
    }

    /**
     * Data Type: Abnormal case (Another Serialize type)
     */
    @Test fun getSerializeArray_dataNG_otherSerialize() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_ENUM_COLOR_ARRAY))
            .isNull()
    }

    /**
     * Data Type: Abnormal case (Not array type)
     */
    @Test fun getSerializeArray_dataNG() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_DATA_COLOR))
            .isNull()
    }
}