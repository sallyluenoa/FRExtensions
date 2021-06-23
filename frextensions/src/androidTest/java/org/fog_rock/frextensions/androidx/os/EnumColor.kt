package org.fog_rock.frextensions.androidx.os

enum class EnumColor(val code: String) {

    RED("#ff0000"),

    GREEN("#008000"),

    BLUE("#0000ff"),
    ;

    companion object {
        fun codes(): Array<String> = values().map { it.code }.toTypedArray()
    }
}