package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class DownCastSetTest {

    private var anyObject: Any? = null

    @Before fun before() {
        anyObject = null
    }

    @Test fun downCastSet_ok() {
        val strSet = setOf("Hello", "World", "!")
        anyObject = strSet
        Truth.assertThat(anyObject.downCastSet<String>()).isEqualTo(strSet)
    }

    @Test fun downCastSet_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    @Test fun downCastSet_list() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    @Test fun downCastSet_missTypedSet() {
        val intSet = setOf(1, 2, 3)
        anyObject = intSet
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    @Test fun downCastSet_mixTypedSet() {
        val mixSet = setOf("Hello", "World", 1, "!")
        anyObject = mixSet
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    @Test fun downCastSet_emptySet() {
        val emptySet = emptySet<String>()
        anyObject = emptySet
        Truth.assertThat(anyObject.downCastSet<String>()).isEqualTo(emptySet)
    }

    @Test fun downCastSet_null() {
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }
}