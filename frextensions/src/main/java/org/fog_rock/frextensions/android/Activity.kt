package org.fog_rock.frextensions.android

import android.app.Activity

inline fun <reified T: Activity> Activity.startActivityForResult(requestCode: Int) {
    startActivityForResult(newIntent<T>(), requestCode)
}