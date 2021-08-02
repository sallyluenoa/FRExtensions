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
 * Start an Activity of a specified class.
 * @param bundle An bundle info to the intent, which the default is null.
 * @see Context.startActivity
 */
inline fun <reified T: Activity> Context.startActivity(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
    })
}

/**
 * Start an Activity of a specified class.
 * All stacked Activities will be destroyed.
 * @param bundle An bundle info to the intent, which the default is null.
 * @see Context.startActivity
 */
inline fun <reified T: Activity> Context.startActivityAndFinishAll(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
}