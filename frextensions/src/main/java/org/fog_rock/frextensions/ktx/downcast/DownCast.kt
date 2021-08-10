package org.fog_rock.frextensions.ktx.downcast

/**
 * Downcast any objects to a specified typed array safely.
 * @return A typed array if the object inherits the specified array type, or null otherwise.
 */
inline fun <reified T> Any?.downCastArray(): Array<T>? {
    val tmp = this as? Array<*> ?: return null
    var array = emptyArray<T>()
    for (value in tmp) {
        if (value is T) array += value
        else return null
    }
    return array
}

/**
 * Downcast any objects to a specified typed list safely.
 * @return A typed list if the object inherits the specified list type, or null otherwise.
 */
inline fun <reified E> Any?.downCastList(): List<E>? {
    val tmp = this as? List<*> ?: return null
    val list = mutableListOf<E>()
    for (value in tmp) {
        if (value is E) list += value
        else return null
    }
    return list.toList()
}

/**
 * Downcast any objects to a specified typed set safely.
 * @return A typed set if the object inherits the specified set type, or null otherwise.
 */
inline fun <reified E> Any?.downCastSet(): Set<E>? {
    val tmp = this as? Set<*> ?: return null
    val set = mutableSetOf<E>()
    for (value in tmp) {
        if (value is E) set += value
        else return null
    }
    return set.toSet()
}

/**
 * Downcast any objects to a specified typed map safely.
 * @return A typed map if the object inherits the specified map type, or null otherwise.
 */
inline fun <reified K, reified V> Any?.downCastMap(): Map<K, V>? {
    val tmp = this as? Map<*, *> ?: return null
    val map = mutableMapOf<K, V>()
    for ((key, value) in tmp) {
        if (key is K && value is V) map[key] = value
        else return null
    }
    return map.toMap()
}