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