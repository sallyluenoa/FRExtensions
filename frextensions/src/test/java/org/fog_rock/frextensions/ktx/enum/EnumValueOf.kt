package org.fog_rock.frextensions.ktx.enum

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see valueOf
 */
class EnumValueOf {

    /**
     * Int -> Enum: Normal case
     */
    @Test fun int_valueOf_normal() {
        Truth.assertThat(valueOf(2, IntColor.RED)).isEqualTo(IntColor.BLUE)
    }

    /**
     * Int -> Enum: Default value
     */
    @Test fun int_valueOf_defaultValue() {
        Truth.assertThat(valueOf(-1, IntColor.RED)).isEqualTo(IntColor.RED)
    }

    /**
     * String -> Enum: Normal case
     */
    @Test fun string_valueOf_normal() {
        Truth.assertThat(valueOf("#0000FF", StringColor.RED)).isEqualTo(StringColor.BLUE)
    }

    /**
     * String -> Enum: Default value
     */
    @Test fun string_valueOf_defaultValue() {
        Truth.assertThat(valueOf("#000000", StringColor.RED)).isEqualTo(StringColor.RED)
    }
}