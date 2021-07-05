package org.fog_rock.frextensions.androidx.os

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @see getSerializeArray
 */
@RunWith(AndroidJUnit4::class)
class BundleSerializeArrayTest : BundleTest() {

    /**
     * ENUM型正常系
     */
    @Test fun getSerializeArray_enumOK() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_ENUM_COLOR_ARRAY))
            .isEqualTo(enumColorArray)
    }

    /**
     * ENUM型異常系（Serialize型ではない）
     */
    @Test fun getSerializeArray_enumNG_nonSerialize() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_ENUM_COLOR_CODE_ARRAY))
            .isNull()
    }

    /**
     * ENUM型異常系（別のSerialize型）
     */
    @Test fun getSerializeArray_enumNG_otherSerialize() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_DATA_COLOR_ARRAY))
            .isNull()
    }

    /**
     * ENUM型異常系（配列ではない）
     */
    @Test fun getSerializeArray_enumNG_nonArray() {
        Truth.assertThat(bundle.getSerializeArray<EnumColor>(KEY_ENUM_COLOR))
            .isNull()
    }

    /**
     * DATA型正常系
     */
    @Test fun getSerializeArray_dataOK() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_DATA_COLOR_ARRAY))
            .isEqualTo(dataColorArray)
    }

    /**
     * ENUM型異常系（Serialize型ではない）
     */
    @Test fun getSerializeArray_dataNG_nonSerialize() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_DATA_COLOR_CODE_ARRAY))
            .isNull()
    }

    /**
     * ENUM型異常系（別のSerialize型）
     */
    @Test fun getSerializeArray_dataNG_otherSerialize() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_ENUM_COLOR_ARRAY))
            .isNull()
    }

    /**
     * ENUM型異常系（配列ではない）
     */
    @Test fun getSerializeArray_dataNG() {
        Truth.assertThat(bundle.getSerializeArray<DataColor>(KEY_DATA_COLOR))
            .isNull()
    }
}