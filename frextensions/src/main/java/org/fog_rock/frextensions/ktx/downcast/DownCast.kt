package org.fog_rock.frextensions.ktx.downcast

/**
 * 配列を安全にダウンキャストする.
 * @return オブジェクトが該当タイプの配列を継承しているならばダウンキャスト後の配列、不可ならば NULL
 */
inline fun <reified T> Any?.downCastArray(): Array<T>? {
    val tmp = this as? Array<*> ?:  return null
    var array = emptyArray<T>()
    for (value in tmp) {
        array += if (value is T) value else return null
    }
    return array
}

/**
 * リストを安全にダウンキャストする.
 * @return オブジェクトが該当タイプのリストを継承しているならばダウンキャスト後のリスト、不可ならば NULL
 */
inline fun <reified T> Any?.downCastList(): List<T>? {
    val tmp = this as? List<*> ?:  return null
    val list = mutableListOf<T>()
    for (value in tmp) {
        list += if (value is T) value else return null
    }
    return list
}