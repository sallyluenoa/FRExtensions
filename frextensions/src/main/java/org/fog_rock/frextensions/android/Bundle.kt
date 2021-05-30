package org.fog_rock.frextensions.android

import android.os.Bundle
import org.fog_rock.frextensions.kotlin.downCastOrNull
import java.io.Serializable

fun <T: Serializable> Bundle.putArrayExtra(name: String, value: Array<T>): Bundle =
    this.apply { putSerializable(name, value) }

inline fun <reified T: Serializable> Bundle.getArrayExtra(name: String): Array<T>? =
    this.getSerializable(name).downCastOrNull()

inline fun <reified T: Serializable> Bundle.putListExtra(name: String, value: List<T>): Bundle =
    putArrayExtra(name, value.toTypedArray())

inline fun <reified T: Serializable> Bundle.getListExtra(name: String): List<T>? =
    getArrayExtra<T>(name)?.toList()
