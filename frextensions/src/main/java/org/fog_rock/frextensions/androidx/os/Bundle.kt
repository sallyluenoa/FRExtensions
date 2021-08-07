package org.fog_rock.frextensions.androidx.os

import android.os.Bundle
import org.fog_rock.frextensions.ktx.downcast.downCastArray
import java.io.Serializable

/**
 * Get a object that the type extends a serialization from a bundle.
 * @param key A key
 * @return A object that extends a serialization if it can be get from a bundle, or null otherwise.
 * @see androidx.core.os.bundleOf
 */
inline fun <reified T: Serializable> Bundle.getSerialize(key: String): T? =
    getSerializable(key) as? T

/**
 * Get a typed array that the type extends a serialization from a bundle.
 * @param key A key
 * @return A typed array that the type extends a serialization if it can be get from a bundle, or null otherwise.
 * @see androidx.core.os.bundleOf
 */
inline fun <reified T: Serializable> Bundle.getSerializeArray(key: String): Array<T>? =
    getSerializable(key).downCastArray()
