package org.fog_rock.frextensions.androidx.content

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * クラスインテントを生成する.
 * @return Intent クラスインテント
 */
inline fun <reified T> Context.newIntent(): Intent =
    Intent(this, T::class.java)

/**
 * アクティビティを起動する.
 * @param bundle インテントへの付加情報、未指定の場合 NULL
 * @see Context.startActivity
 */
inline fun <reified T: Activity> Context.startActivity(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
    })
}

/**
 * アクティビティを起動する.
 * スタックされたアクティビティはすべて破棄される.
 * @param bundle インテントへの付加情報、未指定の場合 NULL
 * @see Context.startActivity
 */
inline fun <reified T: Activity> Context.startActivityAndFinishAll(bundle: Bundle? = null) {
    startActivity(newIntent<T>().apply {
        if (bundle != null) putExtras(bundle)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
}