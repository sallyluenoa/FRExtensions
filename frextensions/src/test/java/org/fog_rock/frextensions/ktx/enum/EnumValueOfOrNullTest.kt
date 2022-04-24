package org.fog_rock.frextensions.ktx.enum

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see valueOfOrNull
 */
class EnumValueOfOrNullTest {

    /**
     * Int -> Enum: Normal case 1
     */
    @Test fun int_valueOfOrNull_normal1() {
        val color: IntColor? = valueOfOrNull(0)
        Truth.assertThat(color).isEqualTo(IntColor.RED)
    }

    /**
     * Int -> Enum: Normal case 2
     */
    @Test fun int_valueOfOrNull_normal2() {
        Truth.assertThat(valueOfOrNull<IntColor, Int>(1)).isEqualTo(IntColor.GREEN)
    }

    /**
     * Int -> Enum: Null
     */
    @Test fun int_valueOfOrNull_null() {
        val color: IntColor? = valueOfOrNull(-1)
        Truth.assertThat(color).isNull()
    }

    /**
     * String -> Enum: Normal case 1
     */
    @Test fun string_valueOfOrNull_normal1() {
        val color: StringColor? = valueOfOrNull("#FF0000")
        Truth.assertThat(color).isEqualTo(StringColor.RED)
    }

    /**
     * String -> Enum: Normal case 2
     */
    @Test fun string_valueOfOrNull_normal2() {
        Truth.assertThat(valueOfOrNull<StringColor, String>("#008000"))
            .isEqualTo(StringColor.GREEN)
    }

    /**
     * String -> Enum: Null
     */
    @Test fun string_valueOfOrNull_null() {
        val color: StringColor? = valueOfOrNull("#000000")
        Truth.assertThat(color).isNull()
    }
}