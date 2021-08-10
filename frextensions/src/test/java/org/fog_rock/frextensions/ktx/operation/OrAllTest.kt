package org.fog_rock.frextensions.ktx.operation

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see orAll
 */
class OrAllTest {

    /**
     * True only
     */
    @Test fun orAll_true() {
        Truth.assertThat(orAll(true)).isTrue()
    }

    /**
     * False only
     */
    @Test fun orAll_false() {
        Truth.assertThat(orAll(false)).isFalse()
    }

    /**
     * Null only
     */
    @Test fun orAll_null() {
        Truth.assertThat(orAll(null)).isNull()
    }

    /**
     * Empty
     */
    @Test fun orAll_empty()  {
        Truth.assertThat(orAll()).isNull()
    }

    /**
     * True 2, false 1
     */
    @Test fun orAll_trueTrueFalse() {
        Truth.assertThat(orAll(true, false, true)).isTrue()
    }

    /**
     * True 1, false 2
     */
    @Test fun orAll_trueFalseFalse() {
        Truth.assertThat(orAll(false, false, true)).isTrue()
    }

    /**
     * True all
     */
    @Test fun orAll_trueTrueTrue() {
        Truth.assertThat(orAll(true, true, true)).isTrue()
    }

    /**
     * False all
     */
    @Test fun orAll_FalseFalseFalse() {
        Truth.assertThat(orAll(false, false, false)).isFalse()
    }

    /**
     * True 1, false 1, null 1
     */
    @Test fun orAll_TrueFalseNull() {
        Truth.assertThat(orAll(true, null, false)).isTrue()
    }

    /**
     * True 2, null 1
     */
    @Test fun orAll_TrueTrueNull() {
        Truth.assertThat(orAll(true, null, true)).isTrue()
    }

    /**
     * False 2, null 1
     */
    @Test fun orAll_FalseFalseNull() {
        Truth.assertThat(orAll(null, false, false)).isFalse()
    }

    /**
     * Null all
     */
    @Test fun orAll_NullNullNull() {
        Truth.assertThat(orAll(null, null, null)).isNull()
    }
}