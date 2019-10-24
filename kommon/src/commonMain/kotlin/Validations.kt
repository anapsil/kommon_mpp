package dev.anapsil.kommon

import dev.anapsil.kommon.Type.CNPJ
import dev.anapsil.kommon.Type.CPF
import dev.anapsil.kommon.Type.DIGITS
import dev.anapsil.kommon.Type.EQUAL_DIGITS

object Type {
    const val CPF: Int = 0
    const val CNPJ: Int = 1
    const val DIGITS: Int = 2
    const val EQUAL_DIGITS = 3
}

infix fun String.validate(type: Int) = when (type) {
    CPF -> validateCpf()
    CNPJ -> validateCnpj()
    DIGITS -> isDigit()
    EQUAL_DIGITS -> isEqualDigits()
    else -> false
}

internal fun String.isDigit() = this.toLongOrNull() != null

internal fun String.isEqualDigits() : Boolean {
    val firstDigit = first()
    if (length == 1) return false
    if (this.isDigit().not()) return false

    forEach {
        if (it.equals(firstDigit).not()) return false
    }

    return true
}

internal fun String.validateCpf(): Boolean {
    if (isEqualDigits().not() || length != 11) return false
    return false
}

internal fun String.validateCnpj(): Boolean {
    return false
}