package org.fog_rock.frextensions.ktx.nonnull

/**
 * Get a non-null value itself for the nullable value.
 * If the value itself is null, it returns the specified default value.
 * a default value if the nullable value is null
 * @param default A default value
 * @return A non-null value itself, or [default] if the value itself is null.
 */
inline fun <reified T> T?.nonNull(default: T): T = this ?: default

/**
 * Get a non-null boolean value itself for the nullable boolean value.
 * @return A non-null boolean value itself, or false if the value itself is null.
 */
fun Boolean?.nonNull(): Boolean = nonNull(false)

/**
 * Get a non-null integer value itself for the nullable integer value.
 * @return A non-null integer value itself, or zero if the value itself is null.
 */
fun Int?.nonNull(): Int = nonNull(0)

/**
 * Get a non-null long value itself for the nullable long value.
 * @return A non-null long value itself, or zero if the value itself is null.
 */
fun Long?.nonNull(): Long = nonNull(0L)

/**
 * Get a non-null float value itself for the nullable float value.
 * @return A non-null float value itself, or zero if the value itself is null.
 */
fun Float?.nonNull(): Float = nonNull(0.0f)

/**
 * Get a non-null double value itself for the nullable double value.
 * @return A non-null double value itself, or zero if the value itself is null.
 */
fun Double?.nonNull(): Double = nonNull(0.0)

/**
 * Get a non-null string value itself for the nullable string value.
 * @return A non-null string value itself, or an empty string if the value itself is null.
 */
fun String?.nonNull(): String = nonNull("")

/**
 * Get a non-null array itself for the nullable array.
 * @return A non-null array itself, or an empty array if the array itself is null.
 */
inline fun <reified T> Array<T>?.nonNull(): Array<T> = nonNull(emptyArray())

/**
 * Get a non-null list itself for the nullable list.
 * @return A non-null list itself, or an empty list if the list itself is null.
 */
inline fun <reified E> List<E>?.nonNull(): List<E> = nonNull(emptyList())

/**
 * Get a non-null set itself for the nullable set.
 * @return A non-null set itself, or an empty set if the set itself is null.
 */
inline fun <reified E> Set<E>?.nonNull(): Set<E> = nonNull(emptySet())

/**
 * Get a non-null map itself for the nullable map.
 * @return A non-null map itself, or an empty map if the map itself is null.
 */
inline fun <reified K, reified V> Map<K, V>?.nonNull(): Map<K, V> = nonNull(emptyMap())
