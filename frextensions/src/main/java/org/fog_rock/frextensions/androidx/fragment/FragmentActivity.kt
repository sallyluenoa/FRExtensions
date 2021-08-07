package org.fog_rock.frextensions.androidx.fragment

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Add a fragment to a view.
 * @param fragment A fragment
 * @param resId A resource ID of the view
 */
fun FragmentActivity.addFragment(fragment: Fragment, @IdRes resId: Int) {
    replaceFragment(fragment, resId, true)
}

/**
 * Replace a fragment in a view.
 * @param fragment A fragment
 * @param resId A resource ID of the view
 */
fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes resId: Int) {
    replaceFragment(fragment, resId, false)
}

/**
 * Replace a fragment in a view.
 * @param fragment A fragment
 * @param resId A resource ID of the view
 * @param addStack True to add the fragment to the back stack, or false otherwise.
 */
private fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes resId: Int, addStack: Boolean) {
    supportFragmentManager.beginTransaction().apply {
        replace(resId, fragment)
        if (addStack) addToBackStack(null)
    }.commit()
}