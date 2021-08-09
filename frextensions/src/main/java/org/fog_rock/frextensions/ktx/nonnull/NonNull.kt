package org.fog_rock.frextensions.ktx.nonnull

inline fun <reified T> T?.nonNull(default: T): T = this ?: default

fun Boolean?.nonNull(): Boolean = nonNull(false)

fun Int?.nonNull(): Int = nonNull(0)

fun Long?.nonNull(): Long = nonNull(0L)

fun Float?.nonNull(): Float = nonNull(0.0f)

fun Double?.nonNull(): Double = nonNull(0.0)

fun String?.nonNull(): String = nonNull("")

inline fun <reified T> Array<T>?.nonNull(): Array<T> = nonNull(emptyArray())

inline fun <reified E> List<E>?.nonNull(): List<E> = nonNull(emptyList())

inline fun <reified E> Set<E>?.nonNull(): Set<E> = nonNull(emptySet())

inline fun <reified K, reified V> Map<K, V>?.nonNull(): Map<K, V> = nonNull(emptyMap())
