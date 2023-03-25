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

package org.fog_rock.frextensions.androidx.log

import android.util.Log

/**
 * Get a class name as a tag.
 * @see Class.getSimpleName
 */
val Any.TAG: String get() = this::class.java.simpleName

/**
 * Output a log, the log level is VERBOSE.
 * @param message A message
 * @see android.util.Log.v
 */
fun Any.logV(message: String) = Log.v(TAG, message)

/**
 * Output a log, the log level is DEBUG.
 * @param message A message
 * @see android.util.Log.d
 */
fun Any.logD(message: String) = Log.d(TAG, message)

/**
 * Output a log, the log level is INFO.
 * @param message A message
 * @see android.util.Log.i
 */
fun Any.logI(message: String) = Log.i(TAG, message)

/**
 * Output a log, the log level is WARNING.
 * @param message A message
 * @see android.util.Log.w
 */
fun Any.logW(message: String) = Log.w(TAG, message)

/**
 * Output a log, the log level is ERROR.
 * @param message A message
 * @see android.util.Log.e
 */
fun Any.logE(message: String) = Log.e(TAG, message)
