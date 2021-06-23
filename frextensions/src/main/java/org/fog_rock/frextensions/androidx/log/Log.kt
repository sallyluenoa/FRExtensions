package org.fog_rock.frextensions.androidx.log

import android.util.Log

/**
 * タグ（クラス名）を取得する.
 * @see Class.getSimpleName
 */
val Any.TAG: String get() = this::class.java.simpleName

/**
 * ログ出力する. (LogLevel: VERBOSE)
 * @param message ログ出力するメッセージ
 * @see Log.v
 */
fun Any.logV(message: String) = Log.v(TAG, message)

/**
 * ログ出力する. (LogLevel: DEBUG)
 * @param message ログ出力するメッセージ
 * @see Log.d
 */
fun Any.logD(message: String) = Log.d(TAG, message)

/**
 * ログ出力する. (LogLevel: INFO)
 * @param message ログ出力するメッセージ
 * @see Log.i
 */
fun Any.logI(message: String) = Log.i(TAG, message)

/**
 * ログ出力する. (LogLevel: WARNING)
 * @param message ログ出力するメッセージ
 * @see Log.w
 */
fun Any.logW(message: String) = Log.w(TAG, message)

/**
 * ログ出力する. (LogLevel: ERROR)
 * @param message ログ出力するメッセージ
 * @see Log.e
 */
fun Any.logE(message: String) = Log.e(TAG, message)
