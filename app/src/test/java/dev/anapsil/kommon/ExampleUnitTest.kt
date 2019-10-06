package dev.anapsil.kommon

import com.google.common.truth.Truth.assertThat
import dev.anapsil.kommon.Type.DIGITS
import dev.anapsil.kommon.Type.EQUAL_DIGITS
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertThat("111111111" validate EQUAL_DIGITS).isTrue()
        assertThat("1114381111" validate EQUAL_DIGITS).isFalse()
        assertThat("579248627" validate DIGITS).isTrue()
        assertThat("579eqw8627" validate DIGITS).isFalse()
    }
}
