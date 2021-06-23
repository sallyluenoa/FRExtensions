package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Test

class DownCastTest {

    private val string = "Hello World!"
    private val string2 = "Hello World2!"
    private val integer = 0

    private var anyObject: Any? = null

    /**
     * Any?.downCastOrNull(): 正常系
     */
    @Test fun downCastOrNull_castOk() {
        anyObject = string
        Truth.assertThat(anyObject.downCastOrNull<String>()).isEqualTo(string)
    }
    /**
     * Any?.downCastOrNull(): 異常系、キャスト失敗
     */
    @Test fun downCastOrNull_castNull() {
        anyObject = string
        Truth.assertThat(anyObject.downCastOrNull<Int>()).isNull()
    }
    /**
     * Any?.downCastOrNull(): 異常系、キャスト前からNULL
     */
    @Test fun downCastOrNull_nullValue() {
        Truth.assertThat(anyObject.downCastOrNull<String>()).isNull()
    }

    /**
     * Any?.downCastOr(defaultValue): 正常系
     */
    @Test fun downCastOr_castOk() {
        anyObject = string
        Truth.assertThat(anyObject.downCastOr(string2)).isEqualTo(string)
    }
    /**
     * Any?.downCastOr(defaultValue): 異常系、キャスト失敗
     */
    @Test fun downCastOr_defaultValue() {
        anyObject = string
        Truth.assertThat(anyObject.downCastOr(integer)).isEqualTo(integer)
    }
    /**
     * Any?.downCastOr(defaultValue): 異常系、キャスト前からNULL
     */
    @Test fun downCastOr_nullValue() {
        Truth.assertThat(anyObject.downCastOr(string2)).isEqualTo(string2)
    }
}