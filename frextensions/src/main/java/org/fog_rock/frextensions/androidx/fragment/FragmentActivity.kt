package org.fog_rock.frextensions.androidx.fragment

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * 指定されたリソースIDのビューにフラグメントを追加する.
 * @param fragment 追加するフラグメント
 * @param resId ビューのリソースID
 */
fun FragmentActivity.addFragment(fragment: Fragment, @IdRes resId: Int) {
    replaceFragment(fragment, resId, true)
}

/**
 * 指定されたリソース ID のビューにフラグメントを置換する.
 * @param fragment 追加するフラグメント
 * @param resId ビューのリソース ID
 */
fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes resId: Int) {
    replaceFragment(fragment, resId, false)
}

/**
 * 指定されたリソース ID のビューにフラグメントを置換する.
 * @param fragment 追加するフラグメント
 * @param resId ビューのリソース ID
 * @param addStack バックスタックに追加する場合は true
 */
private fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes resId: Int, addStack: Boolean) {
    supportFragmentManager.beginTransaction().apply {
        replace(resId, fragment)
        if (addStack) addToBackStack(null)
    }.commit()
}