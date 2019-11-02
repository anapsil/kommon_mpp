package dev.anapsil.kommon

import dev.anapsil.kommon.Type.CNPJ
import dev.anapsil.kommon.Type.CPF
import dev.anapsil.kommon.Type.DIGITS
import dev.anapsil.kommon.Type.EMAIL
import dev.anapsil.kommon.Type.EQUAL_DIGITS

const val CPF_LENGTH = 11
const val CNPJ_LENGTH = 14
const val DIVIDER = 11

val CPF_SEQUENCE_1 = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2)
val CPF_SEQUENCE_2 = listOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
val CNPJ_SEQUENCE_1 = listOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
val CNPJ_SEQUENCE_2 = listOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
val EMAIL_ADDRESS_PATTERN = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"


object Type {
    const val CPF: Int = 0
    const val CNPJ: Int = 1
    const val DIGITS: Int = 2
    const val EQUAL_DIGITS = 3
    const val EMAIL = 4
}

infix fun String.validate(type: Int) = when (type) {
    CPF -> validateCpf()
    CNPJ -> validateCnpj()
    DIGITS -> isDigit()
    EQUAL_DIGITS -> isEqualDigits()
    EMAIL -> isValidEmail()
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
    if (isEqualDigits() || length != CPF_LENGTH) return false
    var sum1 = 0
    var sum2 = 0
    var index = 0
    val numbers = this as CharSequence

    numbers.take(9).map { it.toNumber() }.forEach {
        sum1 += (it * CPF_SEQUENCE_1[index])
        index++
    }

    val expectedFirstDigit = (sum1 * 10) % DIVIDER
    index = 0

    numbers.take(10).map { it.toNumber() }.forEach {
        sum2 += (it * CPF_SEQUENCE_2[index])
        index++
    }

    val expectedSecondDigit = (sum2 * 10) % DIVIDER
    return expectedFirstDigit == numbers[9].toNumber() && expectedSecondDigit == numbers[10].toNumber()
}

internal fun String.validateCnpj(): Boolean {
    if (isEqualDigits() || length != CNPJ_LENGTH) return false

    var sum1 = 0
    var sum2 = 0
    var index = 0
    val numbers = this as CharSequence

    numbers.take(12).map { it.toNumber() }.forEach {
        sum1 += it * CNPJ_SEQUENCE_1[index]
        index++
    }

    val expectedFirstDigit = defineDigit(sum1 % DIVIDER)
    index = 0

    numbers.take(13).map { it.toNumber() }.forEach {
        sum2 += it * CNPJ_SEQUENCE_2[index]
        index++
    }

    val expectedSecondDigit = defineDigit(sum2 % DIVIDER)
    return expectedFirstDigit == numbers[12].toNumber() && expectedSecondDigit == numbers[13].toNumber()
}

internal fun String.isValidEmail() = Regex(EMAIL_ADDRESS_PATTERN).matches(this)

private fun defineDigit(modulo:Int):Int = when (modulo) {
    0, 1 -> 0
    else -> DIVIDER - modulo
}