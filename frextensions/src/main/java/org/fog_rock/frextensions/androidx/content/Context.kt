package org.fog_rock.frextensions.androidx.content

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

inline fun <reified T: Activity> Context.newIntent(): Intent =
    Intent(this, T::class.java)

inline fun <reified T: Activity> Context.startActivity(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
    })
}

inline fun <reified T: Activity> Context.startActivityAndFinishAll(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
}