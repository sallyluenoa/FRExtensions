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
