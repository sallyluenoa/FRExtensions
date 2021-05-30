package org.fog_rock.frextensions.kotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DownCastTest {

    /**
     * downCastOrNull(): 正常系
     */
    @Test fun downCastOrNull_castOk() {
        val any: Any = "Hello World!"
        val str = any.downCastOrNull<String>()
        assertEquals("Hello World!", str)
    }
    /**
     * downCastOrNull(): キャスト失敗
     */
    @Test fun downCastOrNull_castNull() {
        val any: Any = "Hello World!"
        val int = any.downCastOrNull<Int>()
        assertNull(int)
    }
    /**
     * downCastOrNull(): キャスト前からNULL
     */
    @Test fun downCastOrNull_nullValue() {
        val any: Any? = null
        val str = any.downCastOrNull<String>()
        assertNull(str)
    }

    /**
     * downCastOr(defaultValue): 正常系
     */
    @Test fun downCastOr_castOk() {
        val any: Any = "Hello World!"
        val str = any.downCastOr("Hello World2!")
        assertEquals("Hello World!", str)
    }
    /**
     * downCastOr(defaultValue): キャスト失敗
     */
    @Test fun downCastOr_defaultValue() {
        val any: Any = "Hello World!"
        val int = any.downCastOr(0)
        assertEquals(0, int)
    }
    /**
     * downCastOr(defaultValue): キャスト前からNULL
     */
    @Test fun downCastOr_nullValue() {
        val any: Any? = null
        val str = any.downCastOr("Hello World2!")
        assertEquals("Hello World2!", str)
    }
}