/*
 * Copyright (c) 2021 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fog_rock.frextensions.ktx.downcast

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @see downCastSet
 */
class DownCastSetTest : DownCastTest() {

    /**
     * 正常系
     */
    @Test fun downCastSet_ok() {
        val strSet = setOf("Hello", "World", "!")
        anyObject = strSet
        Truth.assertThat(anyObject.downCastSet<String>()).isEqualTo(strSet)
    }

    /**
     * 準正常系: 空セット
     */
    @Test fun downCastSet_emptySet() {
        val emptySet = emptySet<String>()
        anyObject = emptySet
        Truth.assertThat(anyObject.downCastSet<String>()).isEqualTo(emptySet)
    }

    /**
     * 異常系: セットではなくシンプルな型
     */
    @Test fun downCastSet_singleType() {
        val str = "Hello World!"
        anyObject = str
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    /**
     * 異常系: セットではなくリスト
     */
    @Test fun downCastSet_list() {
        val strList = listOf("Hello", "World", "!")
        anyObject = strList
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    /**
     * 異常系: セットに内包している型が不一致
     */
    @Test fun downCastSet_missTypedSet() {
        val intSet = setOf(1, 2, 3)
        anyObject = intSet
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    /**
     * 異常系: セットに内包している型が複数存在
     */
    @Test fun downCastSet_mixTypedSet() {
        val mixSet = setOf("Hello", "World", 1, "!")
        anyObject = mixSet
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }

    /**
     * 異常系: オブジェクトがNULL
     */
    @Test fun downCastSet_null() {
        Truth.assertThat(anyObject.downCastSet<String>()).isNull()
    }
}