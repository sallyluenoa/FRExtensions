package org.fog_rock.frextensions.androidx.os

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @see getSerialize
 */
@RunWith(AndroidJUnit4::class)
class BundleSerializeTest : BundleTest() {

    /**
     * ENUM型正常系
     */
    @Test fun getSerialize_enumOK() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(KEY_ENUM_COLOR))
            .isEqualTo(EnumColor.RED)
    }

    /**
     * ENUM型異常系（Serialize型ではない）
     */
    @Test fun getSerialize_enumNG_nonSerialize() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(KEY_ENUM_COLOR_CODE))
            .isNull()
    }

    /**
     * ENUM型異常系（別のSerialize型）
     */
    @Test fun getSerialize_enumNG_otherSerialize() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(KEY_DATA_COLOR))
            .isNull()
    }

    /**
     * DATA型正常系
     */
    @Test fun getSerialize_dataOK() {
        Truth.assertThat(bundle.getSerialize<DataColor>(KEY_DATA_COLOR))
            .isEqualTo(blackColor)
    }

    /**
     * DATA型異常系（Serialize型ではない）
     */
    @Test fun getSerialize_dataNG_nonSerialize() {
        Truth.assertThat(bundle.getSerialize<DataColor>(KEY_DATA_COLOR_CODE))
            .isNull()
    }

    /**
     * DATA型異常系（別のSerialize型）
     */
    @Test fun getSerialize_dataNG_otherSerialize() {
        Truth.assertThat(bundle.getSerialize<DataColor>(KEY_ENUM_COLOR))
            .isNull()
    }
}