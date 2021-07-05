package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see downCastArray
 */
class DownCastArrayTest : DownCastTest() {

    /**
     * 正常系
     */
    @Test fun downCastArray_ok() {
        val strArray = arrayOf("Hello", "World", "!")
        anyObject = strArray
        Truth.assertThat(anyObject.downCastArray<String>()).isEqualTo(strArray)
    }

    /**
     * 準正常系: 空配列
     */
    @Test fun downCastArray_emptyArray() {
        val emptyArray = emptyArray<String>()
        anyObject = emptyArray
        Truth.assertThat(anyObject.downCastArray<String>()).isEqualTo(emptyArray)
    }

    /**
     * 異常系: 配列ではなくシンプルな型
     */
    @Test fun downCastArray_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * 異常系: 配列ではなくリスト
     */
    @Test fun downCastArray_list() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * 異常系: 配列に内包している型が不一致
     */
    @Test fun downCastArray_missTypedArray() {
        val intArray = arrayOf(1, 2, 3)
        anyObject = intArray
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * 異常系: 配列に内包している型が複数存在
     */
    @Test fun downCastArray_mixTypedArray() {
        val mixArray = arrayOf("Hello", "World", 1, "!")
        anyObject = mixArray
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    /**
     * 異常系: オブジェクトがNULL
     */
    @Test fun downCastArray_null() {
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }
}