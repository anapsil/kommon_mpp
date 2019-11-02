package dev.anapsil.kommon

import dev.anapsil.kommon.Type.CNPJ
import dev.anapsil.kommon.Type.CPF
import dev.anapsil.kommon.Type.DIGITS
import dev.anapsil.kommon.Type.EQUAL_DIGITS
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidationsTest {

    @Test
    fun given_valid_cpf_when_validate_return_true() {
        assertTrue("54647142949" validate CPF)
    }

    @Test
    fun given_valid_cnpj_when_validate_return_true() {
        assertTrue("14572457000185" validate CNPJ)
    }

    @Test
    fun given_valid_digits_when_validate_returns_true() {
        assertTrue("1234124534625463" validate DIGITS)
    }

    @Test
    fun given_equal_digits_when_validate_returns_true() {
        assertTrue("1111111111111" validate EQUAL_DIGITS)
    }

    @Test
    fun with_digits_isDigits_return_true() {
        assertTrue("124612735618".isDigit())
    }

    @Test
    fun with_digits_and_characters_isDigits_return_false() {
        assertFalse("12461fad2735618".isDigit())
        assertFalse("fhakldbacshjd48927".isDigit())
        assertFalse("fhakldbacshjd".isDigit())
        assertFalse("&&%#@ˆˆ)_".isDigit())
        assertFalse("124612735618_".isDigit())
    }

    @Test
    fun with_equal_digits_isEqualDigits_return_true() {
        assertTrue("00000000000".isEqualDigits())
        assertTrue("11111111111".isEqualDigits())
        assertTrue("222222222".isEqualDigits())
        assertTrue("33333333".isEqualDigits())
        assertTrue("444444".isEqualDigits())
        assertTrue("555555555555".isEqualDigits())
        assertTrue("66".isEqualDigits())
        assertTrue("77777777".isEqualDigits())
        assertTrue("8888888888".isEqualDigits())
        assertTrue("999".isEqualDigits())
    }

    @Test
    fun with_not_equal_digits_isEqualDigits_return_false() {
        assertFalse("1242341".isEqualDigits())
        assertFalse("1".isEqualDigits())
    }

    @Test
    fun given_valid_cpf_returns_true() {
        assertTrue("52998224725".validateCpf())
    }

    @Test
    fun given_invalid_cpf_returns_false() {
        assertFalse("52998224721".validateCpf())
        assertFalse("11111111111".validateCpf())
        assertFalse("5299822472".validateCpf())
        assertFalse("12345678900".validateCpf())
    }

    @Test
    fun given_valid_cnpj_returns_true() {
        assertTrue("61550141002701".validateCnpj())
    }

    @Test
    fun given_invalid_cnpj_returns_false() {
        assertFalse("61550141002703".validateCnpj())
        assertFalse("11111111111111".validateCnpj())
        assertFalse("615501410027".validateCnpj())
        assertFalse("12345678901234".validateCnpj())
    }

    @Test
    fun given_valid_email_returns_true() {
        assertTrue("me@anapsil.dev".isValidEmail())
    }

    @Test
    fun given_invalid_email_returns_false() {
        assertFalse("meanapsil.dev".isValidEmail())
        assertFalse("me@anapsildev".isValidEmail())
        assertFalse("#$%ˆ@anapsil.dev".isValidEmail())
//        assertFalse("me@an@psil.dev".isValidEmail())
//        assertFalse("me@anapsil.#ev".isValidEmail())
    }
}