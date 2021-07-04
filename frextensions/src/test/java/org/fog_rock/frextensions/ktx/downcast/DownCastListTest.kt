package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class DownCastListTest {

    private var anyObject: Any? = null

    @Before fun before() {
        anyObject = null
    }

    @Test fun downCastList_ok() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastList<String>()).isEqualTo(strList)
    }

    @Test fun downCastList_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    @Test fun downCastList_array() {
        val strArray = arrayOf("Hello", "World", "!")
        anyObject = strArray
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    @Test fun downCastList_missTypedList() {
        val intList = listOf(1, 2, 3)
        anyObject = intList
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    @Test fun downCastList_mixTypedList() {
        val mixList = listOf("Hello", "World", 1, "!")
        anyObject = mixList
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }

    @Test fun downCastList_emptyList() {
        val emptyList = emptyList<String>()
        anyObject = emptyList
        Truth.assertThat(anyObject.downCastList<String>()).isEqualTo(emptyList)
    }

    @Test
    fun downCastList_null() {
        Truth.assertThat(anyObject.downCastList<String>()).isNull()
    }
}