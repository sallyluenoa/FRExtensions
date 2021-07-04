package org.fog_rock.frextensions.androidx.fragment

import androidx.fragment.app.Fragment

/**
 * 親アクティビティにイベントを通知するためのコールバックインターフェースを取得する.
 * @return 親アクティビティにコールバックが実装されていればそれ自体、そうでなければ NULL を返す.
 * @see FRFragmentCallback
 */
inline fun <reified T: FRFragmentCallback> Fragment.activityCallback(): T? =
    requireActivity() as? T
