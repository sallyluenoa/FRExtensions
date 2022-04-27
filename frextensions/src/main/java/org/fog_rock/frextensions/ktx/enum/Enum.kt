/**
 * Copyright (c) 2022 SallyLueNoa
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

package org.fog_rock.frextensions.ktx.enum

/**
 * Convert from a value of any type to an Enum class.
 * @param value A value of any type
 * @return An Enum class if the value can be converted, or null otherwise.
 * @see FRBaseEnum
 */
inline fun <reified EnumT, TypeT> valueOfOrNull(value: TypeT): EnumT?
        where EnumT : Enum<EnumT>,
              EnumT : FRBaseEnum<TypeT> =
    enumValues<EnumT>().find { value == it.value }

/**
 * Convert from a value of any type to an Enum class.
 * @param value A value of any type
 * @return An Enum class if the value can be converted, or a default value otherwise.
 * @see FRBaseEnum
 */
inline fun <reified EnumT, TypeT> valueOf(value: TypeT, defaultValue: EnumT): EnumT
        where EnumT : Enum<EnumT>,
              EnumT : FRBaseEnum<TypeT> =
    valueOfOrNull(value) ?: defaultValue
