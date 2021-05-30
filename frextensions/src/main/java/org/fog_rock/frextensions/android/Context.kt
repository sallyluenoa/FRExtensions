package org.fog_rock.frextensions.android

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T: Activity> Context.newIntent(): Intent =
    Intent(this, T::class.java)

inline fun <reified T: Activity> Context.startActivity() {
    startActivity(newIntent<T>())
}

inline fun <reified T: Activity> Context.startActivityAndFinishAll() {
    startActivity(newIntent<T>().apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
}