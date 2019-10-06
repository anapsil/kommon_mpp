package dev.anapsil.kommon

import kotlin.test.Test
import kotlin.test.assertTrue

class ValidationsTest {

    @Test
    fun `validate is digits`() {
        assertTrue(isDigit("124612735618"))
    }
}