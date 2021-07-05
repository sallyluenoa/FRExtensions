package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

/**
 * @see downCastMap
 */
class DownCastMapTest {

    private var anyObject: Any? = null

    @Before fun before() {
        anyObject = null
    }

    /**
     * 正常系
     */
    @Test
    fun downCastMap_ok() {
        val strMap = mapOf(
            "Hello" to "Hello",
            "World" to "World",
            "!" to "!",
        )
        anyObject = strMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isEqualTo(strMap)
    }

    /**
     * 準正常系: 空セット
     */
    @Test fun downCastMap_emptyMap() {
        val emptyMap = emptyMap<String, String>()
        anyObject = emptyMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isEqualTo(emptyMap)
    }

    /**
     * 異常系: マップではなくシンプルな型
     */
    @Test fun downCastMap_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * 異常系: マップではなくセット
     */
    @Test fun downCastMap_set() {
        val strSet = setOf("Hello", "World", "!")
        anyObject = strSet
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * 異常系: マップに内包しているキーの型が不一致
     */
    @Test fun downCastMap_missTypedKey() {
        val intKeyMap = mapOf(
            1 to "Hello",
            2 to "World",
            3 to "!",
        )
        anyObject = intKeyMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * 異常系: マップに内包しているバリューの型が不一致
     */
    @Test fun downCastMap_missTypedValue() {
        val intValueMap = mapOf(
            "Hello" to 1,
            "World" to 2,
            "!" to 3,
        )
        anyObject = intValueMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * 異常系: マップに内包しているキーとバリューの型が不一致
     */
    @Test fun downCastMap_missTypedKeyValue() {
        val intMap = mapOf(
            1 to 1,
            2 to 2,
            3 to 3,
        )
        anyObject = intMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * 異常系: マップに内包している型が複数存在
     */
    @Test fun downCastMap_mixTypedMap() {
        val mixMap = mapOf(
            "Hello" to "Hello",
            2 to "World",
            "!" to 3,
            4 to 4,
        )
        anyObject = mixMap
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }

    /**
     * 異常系: オブジェクトがNULL
     */
    @Test fun downCastMap_null() {
        Truth.assertThat(anyObject.downCastMap<String, String>()).isNull()
    }
}