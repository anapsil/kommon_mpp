package dev.anapsil.kommon

import dev.anapsil.kommon.Type.DIGITS
import dev.anapsil.kommon.Type.EQUAL_DIGITS
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidationsTest {

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
    fun given_valid_digits_when_validate_returns_true() {
        assertTrue("1234124534625463" validate DIGITS)
    }

    @Test
    fun given_equal_digits_when_validate_returns_true() {
        assertTrue("1111111111111" validate EQUAL_DIGITS)
    }
}