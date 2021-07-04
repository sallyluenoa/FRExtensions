package org.fog_rock.frextensions.ktx.downcast

/**
 * 安全にダウンキャストする.
 * @return オブジェクトがクラスを継承しているならばダウンキャスト後のオブジェクト、不可ならば NULL
 */
inline fun <reified T> Any?.downCastOrNull(): T? = if (this is T) this else null

/**
 * 安全にダウンキャストする.
 * @param defaultValue ダウンキャストに失敗した場合に返すデフォルト値
 * @return オブジェクトがクラスを継承しているならばダウンキャスト後のオブジェクト、不可ならばデフォルト値
 */
inline fun <reified T> Any?.downCastOr(defaultValue: T): T = if (this is T) this else defaultValue

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