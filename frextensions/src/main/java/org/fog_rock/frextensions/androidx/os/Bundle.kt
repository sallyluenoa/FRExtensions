/*
 * Copyright (c) 2021 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
