package org.fog_rock.frextensions.androidx.os

import androidx.core.os.bundleOf

open class BundleTest {

    companion object {
        const val KEY_ENUM_COLOR = "enum_color"
        const val KEY_ENUM_COLOR_ARRAY = "enum_color_array"
        const val KEY_ENUM_COLOR_CODE = "enum_color_code"
        const val KEY_ENUM_COLOR_CODE_ARRAY = "enum_color_code_array"
        const val KEY_DATA_COLOR = "data_color"
        const val KEY_DATA_COLOR_ARRAY = "data_color_array"
        const val KEY_DATA_COLOR_CODE = "data_color_code"
        const val KEY_DATA_COLOR_CODE_ARRAY = "data_color_code_array"
    }

    protected val blackColor = DataColor("#000000")
    protected val whiteColor = DataColor("#ffffff")

    protected val enumColorArray = EnumColor.values()
    protected val enumColorCodeArray = enumColorArray.map { it.code }.toTypedArray()
    protected val dataColorArray = arrayOf(blackColor, whiteColor)
    protected val dataColorCodeArray = dataColorArray.map { it.code }.toTypedArray()

    protected val bundle = bundleOf(
        KEY_ENUM_COLOR to EnumColor.RED,
        KEY_ENUM_COLOR_ARRAY to enumColorArray,
        KEY_ENUM_COLOR_CODE to EnumColor.RED.code,
        KEY_ENUM_COLOR_CODE_ARRAY to enumColorCodeArray,
        KEY_DATA_COLOR to blackColor,
        KEY_DATA_COLOR_ARRAY to dataColorArray,
        KEY_DATA_COLOR_CODE to blackColor.code,
        KEY_DATA_COLOR_CODE_ARRAY to dataColorCodeArray,
    )

}