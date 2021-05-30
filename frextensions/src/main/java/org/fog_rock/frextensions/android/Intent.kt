package org.fog_rock.frextensions.android

import android.content.Intent
import org.fog_rock.frextensions.kotlin.downCastOrNull
import java.io.Serializable

fun <T: Serializable> Intent.putArrayExtra(name: String, value: Array<T>): Intent =
    this.apply { putExtra(name, value) }

inline fun <reified T: Serializable> Intent.getArrayExtra(name: String): Array<T>? =
    this.getSerializableExtra(name).downCastOrNull()

inline fun <reified T: Serializable> Intent.putListExtra(name: String, value: List<T>): Intent =
    putArrayExtra(name, value.toTypedArray())

inline fun <reified T: Serializable> Intent.getListExtra(name: String): List<T>? =
    getArrayExtra<T>(name)?.toList()
