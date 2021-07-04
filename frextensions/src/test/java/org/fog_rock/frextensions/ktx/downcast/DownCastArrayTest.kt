package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class DownCastArrayTest {

    private var anyObject: Any? = null

    @Before fun before() {
        anyObject = null
    }

    @Test fun downCastArray_ok() {
        val strArray = arrayOf("Hello", "World", "!")
        anyObject = strArray
        Truth.assertThat(anyObject.downCastArray<String>()).isEqualTo(strArray)
    }

    @Test fun downCastArray_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    @Test fun downCastArray_list() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    @Test fun downCastArray_missTypedArray() {
        val intArray = arrayOf(1, 2, 3)
        anyObject = intArray
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    @Test fun downCastArray_mixTypedArray() {
        val mixArray = arrayOf("Hello", "World", 1, "!")
        anyObject = mixArray
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }

    @Test fun downCastArray_emptyArray() {
        val emptyArray = emptyArray<String>()
        anyObject = emptyArray
        Truth.assertThat(anyObject.downCastArray<String>()).isEqualTo(emptyArray)
    }

    @Test fun downCastArray_null() {
        Truth.assertThat(anyObject.downCastArray<String>()).isNull()
    }
}