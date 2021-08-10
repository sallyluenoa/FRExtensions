package org.fog_rock.frextensions.ktx.nonnull

import com.google.common.truth.Truth
import org.junit.Test

class NonNullPrimitiveTest {

    private var boolean: Boolean? = null
    private var int: Int? = null
    private var long: Long? = null
    private var float: Float? = null
    private var double: Double? = null

    /**
     * Boolean?.toNonNull(): True
     */
    @Test fun boolean_toNonNull_true() {
        boolean = true
        Truth.assertThat(boolean.toNonNull()).isTrue()
    }
    /**
     * Boolean?.toNonNull(): False
     */
    @Test fun boolean_toNonNull_false() {
        boolean = false
        Truth.assertThat(boolean.toNonNull()).isFalse()
    }
    /**
     * Boolean?.toNonNull(): Null
     */
    @Test fun boolean_toNonNull_null() {
        Truth.assertThat(boolean).isNull()
        Truth.assertThat(boolean.toNonNull()).isFalse()
    }

    /**
     * Int?.toNonNull(): 1
     */
    @Test fun int_toNonNull_one() {
        int = 1
        Truth.assertThat(int.toNonNull()).isEqualTo(1)
    }
    /**
     * Int?.toNonNull(): 0
     */
    @Test fun int_toNonNull_zero() {
        int = 0
        Truth.assertThat(int.toNonNull()).isEqualTo(0)
    }
    /**
     * Int?.toNonNull(): Null
     */
    @Test fun int_toNonNull_null() {
        Truth.assertThat(int).isNull()
        Truth.assertThat(int.toNonNull()).isEqualTo(0)
    }

    /**
     * Long?.toNonNull(): 1
     */
    @Test fun long_toNonNull_one() {
        long = 1
        Truth.assertThat(long.toNonNull()).isEqualTo(1L)
    }
    /**
     * Long?.toNonNull(): 0
     */
    @Test fun long_toNonNull_zero() {
        long = 0
        Truth.assertThat(long.toNonNull()).isEqualTo(0L)
    }
    /**
     * Long?.toNonNull(): Null
     */
    @Test fun long_toNonNull_null() {
        Truth.assertThat(long).isNull()
        Truth.assertThat(long.toNonNull()).isEqualTo(0L)
    }

    /**
     * Float?.toNonNull(): 1.0
     */
    @Test fun float_toNonNull_one() {
        float = 1.0f
        Truth.assertThat(float.toNonNull()).isEqualTo(1.0f)
    }
    /**
     * Float?.toNonNull(): 0.0
     */
    @Test fun float_toNonNull_zero() {
        float = 0.0f
        Truth.assertThat(float.toNonNull()).isZero()
    }
    /**
     * Float?.toNonNull(): Null
     */
    @Test fun float_toNonNull_null() {
        Truth.assertThat(float).isNull()
        Truth.assertThat(float.toNonNull()).isZero()
    }

    /**
     * Double?.toNonNull(): 1.0
     */
    @Test fun double_toNonNull_one() {
        double = 1.0
        Truth.assertThat(double.toNonNull()).isEqualTo(1.0)
    }
    /**
     * Double?.toNonNull(): 0.0
     */
    @Test fun double_toNonNull_zero() {
        double = 0.0
        Truth.assertThat(double.toNonNull()).isZero()
    }
    /**
     * Double?.toNonNull(): Null
     */
    @Test fun double_toNonNull_null() {
        Truth.assertThat(double).isNull()
        Truth.assertThat(double.toNonNull()).isZero()
    }
}