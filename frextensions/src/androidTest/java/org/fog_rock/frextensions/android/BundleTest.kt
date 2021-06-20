package org.fog_rock.frextensions.android

import android.os.Bundle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BundleTest {

    private val stringArray = arrayOf("Hello", "World", "!")
    private val stringList = listOf("Hello", "World", "!")

    /**
     * Bundle.putArrayExtra(), getArrayExtra(): 正常系
     */
    @Test fun arrayExtra_normal() {
        val bundle = Bundle().apply { putArrayExtra("array", stringArray) }
        val array = bundle.getArrayExtra<String>("array")
        Truth.assertThat(array).isEqualTo(stringArray)
    }
    /**
     * Bundle.putArrayExtra(), getArrayExtra(): 異常系、テンプレートタイプミス
     */
    @Test fun arrayExtra_tempInvalid() {
        val bundle = Bundle().apply { putArrayExtra("array", stringArray) }
        val array = bundle.getArrayExtra<Int>("array")
        Truth.assertThat(array).isNull()
    }
    /**
     * Bundle.putArrayExtra(), getArrayExtra(): 異常系、putタイプミス
     */
    @Test fun arrayExtra_putInvalid() {
        val bundle = Bundle().apply { putInt("number", 1) }
        val array = bundle.getArrayExtra<String>("number")
        Truth.assertThat(array).isNull()
    }
    /**
     * Bundle.putArrayExtra(), getArrayExtra(): 異常系、getタイプミス
     */
    @Test fun arrayExtra_getInvalid() {
        val bundle = Bundle().apply { putArrayExtra("array", stringArray) }
        val number = bundle.getInt("array", 1)
        Truth.assertThat(number).isEqualTo(1)
    }
    /**
     * Bundle.putArrayExtra(), getArrayExtra(): 異常系、put未指定
     */
    @Test fun arrayExtra_empty() {
        val bundle = Bundle()
        val array = bundle.getArrayExtra<String>("array")
        Truth.assertThat(array).isNull()
    }

    /**
     * Bundle.putListExtra(), getListExtra(): 正常系
     */
    @Test fun listExtra_normal() {
        val bundle = Bundle().apply { putListExtra("list", stringList) }
        val list = bundle.getListExtra<String>("list")
        Truth.assertThat(list).isEqualTo(stringList)
    }
    /**
     * Bundle.putListExtra(), getListExtra(): 異常系、テンプレートタイプミス
     */
    @Test fun listExtra_tempInvalid() {
        val bundle = Bundle().apply { putListExtra("array", stringList) }
        val array = bundle.getListExtra<Int>("array")
        Truth.assertThat(array).isNull()
    }
    /**
     * Bundle.putListExtra(), getListExtra(): 異常系、putタイプミス
     */
    @Test fun listExtra_putInvalid() {
        val bundle = Bundle().apply { putInt("number", 1) }
        val array = bundle.getListExtra<String>("number")
        Truth.assertThat(array).isNull()
    }
    /**
     * Bundle.putListExtra(), getListExtra(): 異常系、getタイプミス
     */
    @Test fun listExtra_getInvalid() {
        val bundle = Bundle().apply { putListExtra("list", stringList) }
        val number = bundle.getInt("list", 1)
        Truth.assertThat(number).isEqualTo(1)
    }
    /**
     * Bundle.putListExtra(), getListExtra(): 異常系、put未指定
     */
    @Test fun listExtra_empty() {
        val bundle = Bundle()
        val list = bundle.getListExtra<String>("list")
        Truth.assertThat(list).isNull()
    }
}