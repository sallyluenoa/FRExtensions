package org.fog_rock.frextensions.android

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.addFragment(fragment: Fragment, @IdRes resId: Int) {
    replaceFragment(fragment, resId, true)
}

fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes resId: Int) {
    replaceFragment(fragment, resId, false)
}

private fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes resId: Int, addStack: Boolean) {
    supportFragmentManager.beginTransaction().apply {
        replace(resId, fragment)
        if (addStack) addToBackStack(null)
    }.commit()
}