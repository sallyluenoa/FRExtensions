package org.fog_rock.frextensions.androidx.fragment

import androidx.fragment.app.Fragment

/**
 * フラグメントが親アクティビティにイベントを通知するためのコールバックインターフェース.
 * @see activityCallback
 */
interface FRFragmentCallback {
    /**
     * フラグメントのビューが生成されたことを通知する.
     * @param tag タグ
     * @see Fragment.onCreateView
     */
    fun onCreateFragmentView(tag: String)
}