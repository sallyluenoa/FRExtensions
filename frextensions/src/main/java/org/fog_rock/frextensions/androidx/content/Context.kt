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

package org.fog_rock.frextensions.androidx.content

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Generate a new class intent.
 * @return A class intent
 */
inline fun <reified T> Context.newIntent(): Intent =
    Intent(this, T::class.java)

/**
 * Start an activity of a specified class.
 * @param bundle An bundle info to the intent, which the default is null.
 * @see android.content.Context.startActivity
 */
inline fun <reified T: Activity> Context.startActivity(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
    })
}

/**
 * Start an activity of a specified class.
 * All stacked activities will be destroyed.
 * @param bundle An bundle info to the intent, which the default is null.
 * @see android.content.Context.startActivity
 */
inline fun <reified T: Activity> Context.startActivityAndFinishAll(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
}