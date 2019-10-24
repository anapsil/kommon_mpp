package dev.anapsil.kommon

import dev.anapsil.kommon.Type.CNPJ
import dev.anapsil.kommon.Type.CPF
import dev.anapsil.kommon.Type.DIGITS
import dev.anapsil.kommon.Type.EQUAL_DIGITS

val SEQUENCE_1 = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2)
val SEQUENCE_2 = listOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)

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

internal fun String.isEqualDigits(): Boolean {
    val firstDigit = first()
    if (length == 1) return false
    if (this.isDigit().not()) return false

    forEach {
        if (it != firstDigit) return false
    }

    return true
}

internal fun String.validateCpf(): Boolean {
    if (isEqualDigits() || length != 11) return false
    var sum1 = 0
    var sum2 = 0
    var index = 0
    val numbers = this as CharSequence

    numbers.take(9).forEach {
        sum1 += (it.toString().toInt() * SEQUENCE_1[index])
        index++
    }

    val expectedFirstDigit = (sum1 * 10) % 11
    index = 0

    numbers.take(10).forEach {
        sum2 += (it.toString().toInt() * SEQUENCE_2[index])
        index++
    }

    val expectedSecondDigit = (sum2 * 10) % 11
    return expectedFirstDigit == numbers[9].toString().toInt() && expectedSecondDigit == numbers[10].toString().toInt()
}

internal fun String.validateCnpj(): Boolean {
    return false
}