package org.fog_rock.frextensions.androidx.os

import android.os.Bundle
import org.fog_rock.frextensions.ktx.downcast.downCastOrNull
import java.io.Serializable

/**
 * Bundleからシリアライズを継承したクラスを取得する.
 * @see androidx.core.os.bundleOf
 */
inline fun <reified T: Serializable> Bundle.getSerialize(key: String): T? =
    getSerializable(key).downCastOrNull<T>()

/**
 * Bundleからシリアライズを継承したクラス配列を取得する.
 * @see getSerialize
 */
inline fun <reified T: Serializable> Bundle.getSerializeArrayList(key: String): Array<T>? =
    getSerializable(key).downCastOrNull<Array<T>>()
