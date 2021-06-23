package org.fog_rock.frextensions.androidx.os

import androidx.core.os.bundleOf
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BundleTest {

    private val keyEnumColor = "enum_color"
    private val keyEnumColorArray = "enum_color_array"
    private val keyEnumColorCode = "enum_color_code"
    private val keyEnumColorCodeArray = "enum_color_code_array"

    private val keyDataColor = "data_color"
    private val keyDataColorArray = "data_color_array"
    private val keyDataColorCode = "data_color_code"
    private val keyDataColorCodeArray = "data_color_code_array"

    private val blackColor = DataColor("#000000")
    private val whiteColor = DataColor("#ffffff")

    private val enumColorArray = EnumColor.values()
    private val enumColorCodeArray = enumColorArray.map { it.code }.toTypedArray()
    private val dataColorArray = arrayOf(blackColor, whiteColor)
    private val dataColorCodeArray = dataColorArray.map { it.code }.toTypedArray()

    private val bundle = bundleOf(
        keyEnumColor to EnumColor.RED,
        keyEnumColorCode to EnumColor.RED.code,
        keyEnumColorArray to enumColorArray,
        keyEnumColorCodeArray to enumColorCodeArray,
        keyDataColor to blackColor,
        keyDataColorCode to blackColor.code,
        keyDataColorArray to dataColorArray,
        keyDataColorCodeArray to dataColorCodeArray,
    )

    /**
     * Bundle.getSerialize(): ENUM型正常系
     */
    @Test fun getSerialize_enumOK() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(keyEnumColor))
            .isEqualTo(EnumColor.RED)
    }
    /**
     * Bundle.getSerialize(): ENUM型異常系（Serialize型ではない）
     */
    @Test fun getSerialize_enumNG_nonSerialize() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(keyEnumColorCode))
            .isNull()
    }
    /**
     * Bundle.getSerialize(): ENUM型異常系（別のSerialize型）
     */
    @Test fun getSerialize_enumNG_otherSerialize() {
        Truth.assertThat(bundle.getSerialize<EnumColor>(keyDataColor))
            .isNull()
    }

    /**
     * Bundle.getSerialize(): DATA型正常系
     */
    @Test fun getSerialize_dataOK() {
        Truth.assertThat(bundle.getSerialize<DataColor>(keyDataColor))
            .isEqualTo(blackColor)
    }
    /**
     * Bundle.getSerialize(): DATA型異常系（Serialize型ではない）
     */
    @Test fun getSerialize_dataNG_nonSerialize() {
        Truth.assertThat(bundle.getSerialize<DataColor>(keyDataColorCode))
            .isNull()
    }
    /**
     * Bundle.getSerialize(): DATA型異常系（別のSerialize型）
     */
    @Test fun getSerialize_dataNG_otherSerialize() {
        Truth.assertThat(bundle.getSerialize<DataColor>(keyEnumColor))
            .isNull()
    }

    /**
     * Bundle.getSerializeArrayList(): ENUM型正常系
     */
    @Test fun getSerializeArrayList_enumOK() {
        Truth.assertThat(bundle.getSerializeArrayList<EnumColor>(keyEnumColorArray))
            .isEqualTo(enumColorArray)
    }
    /**
     * Bundle.getSerializeArrayList(): ENUM型異常系（Serialize型ではない）
     */
    @Test fun getSerializeArrayList_enumNG_nonSerialize() {
        Truth.assertThat(bundle.getSerializeArrayList<EnumColor>(keyEnumColorCodeArray))
            .isNull()
    }
    /**
     * Bundle.getSerializeArrayList(): ENUM型異常系（別のSerialize型）
     */
    @Test fun getSerializeArrayList_enumNG_otherSerialize() {
        Truth.assertThat(bundle.getSerializeArrayList<EnumColor>(keyDataColorArray))
            .isNull()
    }
    /**
     * Bundle.getSerializeArrayList(): ENUM型異常系（配列ではない）
     */
    @Test fun getSerializeArrayList_enumNG_nonArray() {
        Truth.assertThat(bundle.getSerializeArrayList<EnumColor>(keyEnumColor))
            .isNull()
    }

    /**
     * Bundle.getSerializeArrayList(): DATA型正常系
     */
    @Test fun getSerializeArrayList_dataOK() {
        Truth.assertThat(bundle.getSerializeArrayList<DataColor>(keyDataColorArray))
            .isEqualTo(dataColorArray)
    }
    /**
     * Bundle.getSerializeArrayList(): ENUM型異常系（Serialize型ではない）
     */
    @Test fun getSerializeArrayList_dataNG_nonSerialize() {
        Truth.assertThat(bundle.getSerializeArrayList<DataColor>(keyDataColorCodeArray))
            .isNull()
    }
    /**
     * Bundle.getSerializeArrayList(): ENUM型異常系（別のSerialize型）
     */
    @Test fun getSerializeArrayList_dataNG_otherSerialize() {
        Truth.assertThat(bundle.getSerializeArrayList<DataColor>(keyEnumColorArray))
            .isNull()
    }
    /**
     * Bundle.getSerializeArrayList(): ENUM型異常系（配列ではない）
     */
    @Test fun getSerializeArrayList_dataNG() {
        Truth.assertThat(bundle.getSerializeArrayList<DataColor>(keyDataColor))
            .isNull()
    }
}