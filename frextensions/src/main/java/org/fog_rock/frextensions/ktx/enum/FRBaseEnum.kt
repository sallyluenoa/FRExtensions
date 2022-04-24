package org.fog_rock.frextensions.ktx.enum

/**
 * A interface for converting from a value of any type to an Enum class.
 */
interface FRBaseEnum<T> {
    /**
     * A value of any type
     */
    val value: T
}