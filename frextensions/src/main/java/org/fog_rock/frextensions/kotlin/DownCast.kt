package org.fog_rock.frextensions.kotlin

inline fun <reified T> Any?.downCastOrNull(): T? = if (this is T) this else null

inline fun <reified T> Any?.downCastOr(defaultValue: T): T = if (this is T) this else defaultValue
