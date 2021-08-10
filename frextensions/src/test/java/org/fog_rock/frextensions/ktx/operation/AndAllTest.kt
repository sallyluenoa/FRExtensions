package org.fog_rock.frextensions.ktx.operation

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see andAll
 */
class AndAllTest {

    /**
     * True only
     */
    @Test fun andAll_true() {
        Truth.assertThat(andAll(true)).isTrue()
    }

    /**
     * False only
     */
    @Test fun andAll_false() {
        Truth.assertThat(andAll(false)).isFalse()
    }

    /**
     * Null only
     */
    @Test fun andAll_null() {
        Truth.assertThat(andAll(null)).isNull()
    }

    /**
     * Empty
     */
    @Test fun andAll_empty()  {
        Truth.assertThat(andAll()).isNull()
    }

    /**
     * True 2, false 1
     */
    @Test fun andAll_trueTrueFalse() {
        Truth.assertThat(andAll(true, false, true)).isFalse()
    }

    /**
     * True 1, false 2
     */
    @Test fun andAll_trueFalseFalse() {
        Truth.assertThat(andAll(false, false, true)).isFalse()
    }

    /**
     * True all
     */
    @Test fun andAll_trueTrueTrue() {
        Truth.assertThat(andAll(true, true, true)).isTrue()
    }

    /**
     * False all
     */
    @Test fun andAll_FalseFalseFalse() {
        Truth.assertThat(andAll(false, false, false)).isFalse()
    }

    /**
     * True 1, false 1, null 1
     */
    @Test fun andAll_TrueFalseNull() {
        Truth.assertThat(andAll(true, null, false)).isFalse()
    }

    /**
     * True 2, null 1
     */
    @Test fun andAll_TrueTrueNull() {
        Truth.assertThat(andAll(true, null, true)).isTrue()
    }

    /**
     * False 2, null 1
     */
    @Test fun andAll_FalseFalseNull() {
        Truth.assertThat(andAll(null, false, false)).isFalse()
    }

    /**
     * Null all
     */
    @Test fun andAll_NullNullNull() {
        Truth.assertThat(andAll(null, null, null)).isNull()
    }
}