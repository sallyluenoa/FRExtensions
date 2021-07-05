package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see downCastList
 */
class DownCastListTest : DownCastTest() {

    /**
     * 正常系
     */
    @Test fun downCastList_ok() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastList<String>()).isEqualTo(strList)
    }

    /**
     * 準正常系: 空リスト
     */
    @Test fun downCastList_emptyList() {
        val emptyList = emptyList<String>()
        anyObject = emptyList
        Truth.assertThat(anyObject.downCastList<String>()).isEqualTo(emptyList)
    }

    /**
     * 異常系: リストではなくシンプルな型
     */
    @Test fun downCastList_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * 異常系: リストではなく配列
     */
    @Test fun downCastList_array() {
        val strArray = arrayOf("Hello", "World", "!")
        anyObject = strArray
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * 異常系: リストに内包している型が不一致
     */
    @Test fun downCastList_missTypedList() {
        val intList = listOf(1, 2, 3)
        anyObject = intList
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * 異常系: リストに内包している型が複数存在
     */
    @Test fun downCastList_mixTypedList() {
        val mixList = listOf("Hello", "World", 1, "!")
        anyObject = mixList
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    /**
     * 異常系: オブジェクトがNULL
     */
    @Test fun downCastList_null() {
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }
}