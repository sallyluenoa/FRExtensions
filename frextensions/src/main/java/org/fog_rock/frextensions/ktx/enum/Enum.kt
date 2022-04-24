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
