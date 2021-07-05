package org.fog_rock.frextensions.ktx.downcast

/**
 * 配列を安全にダウンキャストする.
 * @return オブジェクトが該当タイプの配列を継承しているならばダウンキャスト後の配列、不可ならば NULL
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
 * リストを安全にダウンキャストする.
 * @return オブジェクトが該当タイプのリストを継承しているならばダウンキャスト後のリスト、不可ならば NULL
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
 * セットを安全にダウンキャストする.
 * @return オブジェクトが該当タイプのセットを継承しているならばダウンキャスト後のセット、不可ならば NULL
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
 * マップを安全にダウンキャストする.
 * @return オブジェクトが該当タイプのマップを継承しているならばダウンキャスト後のマップ、不可ならば NULL
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