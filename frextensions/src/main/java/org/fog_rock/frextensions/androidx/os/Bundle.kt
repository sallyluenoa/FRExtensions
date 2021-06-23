package org.fog_rock.frextensions.androidx.os

import android.os.Bundle
import org.fog_rock.frextensions.ktx.downcast.downCastOrNull
import java.io.Serializable

/**
 * Bundleからシリアライズを継承したクラスオブジェクトを取得する.
 * @param key Key
 * @return シリアライズを継承したクラスオブジェクト、取得に失敗した場合は NULL
 * @see androidx.core.os.bundleOf
 */
inline fun <reified T: Serializable> Bundle.getSerialize(key: String): T? =
    getSerializable(key).downCastOrNull<T>()

/**
 * Bundleからシリアライズを継承したクラスオブジェクトの配列を取得する.
 * @param key Key
 * @return シリアライズを継承したクラスオブジェクトの配列、取得に失敗した場合は NULL
 * @see getSerialize
 */
inline fun <reified T: Serializable> Bundle.getSerializeArrayList(key: String): Array<T>? =
    getSerializable(key).downCastOrNull<Array<T>>()
