package org.fog_rock.frextensions.android

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntentTest {

    private val stringArray = arrayOf("Hello", "World", "!")
    private val stringList = listOf("Hello", "World", "!")

    /**
     * Intent.putArrayExtra(), getArrayExtra(): 正常系
     */
    @Test fun arrayExtra_normal() {
        val intent = Intent().apply { putArrayExtra("array", stringArray) }
        val array = intent.getArrayExtra<String>("array")
        assertArrayEquals(stringArray, array)
    }
    /**
     * Intent.putArrayExtra(), getArrayExtra(): 異常系、テンプレートタイプミス
     */
    @Test fun arrayExtra_tempInvalid() {
        val intent = Intent().apply { putArrayExtra("array", stringArray) }
        val array = intent.getArrayExtra<Int>("array")
        assertNull(array)
    }
    /**
     * Intent.putArrayExtra(), getArrayExtra(): 異常系、putタイプミス
     */
    @Test fun arrayExtra_putInvalid() {
        val intent = Intent().apply { putExtra("number", 1) }
        val array = intent.getArrayExtra<String>("number")
        assertNull(array)
    }
    /**
     * Intent.putArrayExtra(), getArrayExtra(): 異常系、getタイプミス
     */
    @Test fun arrayExtra_getInvalid() {
        val intent = Intent().apply { putArrayExtra("array", stringArray) }
        val number = intent.getIntExtra("array", 1)
        assertEquals(1, number)
    }
    /**
     * Intent.putArrayExtra(), getArrayExtra(): 異常系、put未指定
     */
    @Test fun arrayExtra_empty() {
        val intent = Intent()
        val array = intent.getArrayExtra<String>("array")
        assertNull(array)
    }

    /**
     * Intent.putListExtra(), getListExtra(): 正常系
     */
    @Test fun listExtra_normal() {
        val intent = Intent().apply { putListExtra("list", stringList) }
        val list = intent.getListExtra<String>("list")
        assertEquals(stringList, list)
    }
    /**
     * Intent.putListExtra(), getListExtra(): 異常系、テンプレートタイプミス
     */
    @Test fun listExtra_tempInvalid() {
        val intent = Intent().apply { putListExtra("array", stringList) }
        val array = intent.getListExtra<Int>("array")
        assertNull(array)
    }
    /**
     * Intent.putListExtra(), getListExtra(): 異常系、putタイプミス
     */
    @Test fun listExtra_putInvalid() {
        val intent = Intent().apply { putExtra("number", 1) }
        val array = intent.getListExtra<String>("number")
        assertNull(array)
    }
    /**
     * Intent.putListExtra(), getListExtra(): 異常系、getタイプミス
     */
    @Test fun listExtra_getInvalid() {
        val intent = Intent().apply { putListExtra("list", stringList) }
        val number = intent.getIntExtra("list", 1)
        assertEquals(1, number)
    }
    /**
     * Intent.putListExtra(), getListExtra(): 異常系、put未指定
     */
    @Test fun listExtra_empty() {
        val intent = Intent()
        val list = intent.getListExtra<String>("list")
        assertNull(list)
    }
}