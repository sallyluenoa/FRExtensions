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
 * @see Log.v
 */
fun Any.logV(message: String) = Log.v(TAG, message)

/**
 * Output a log, the log level is DEBUG.
 * @param message A message
 * @see Log.d
 */
fun Any.logD(message: String) = Log.d(TAG, message)

/**
 * Output a log, the log level is INFO.
 * @param message A message
 * @see Log.i
 */
fun Any.logI(message: String) = Log.i(TAG, message)

/**
 * Output a log, the log level is WARNING.
 * @param message A message
 * @see Log.w
 */
fun Any.logW(message: String) = Log.w(TAG, message)

/**
 * Output a log, the log level is ERROR.
 * @param message A message
 * @see Log.e
 */
fun Any.logE(message: String) = Log.e(TAG, message)
