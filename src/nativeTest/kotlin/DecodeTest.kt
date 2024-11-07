import kotlin.test.Test
import kotlin.test.assertEquals

class DecodeTest {
    @Test
    fun `should decode from uuid with dashes`() {
        val result = Decode.from("019123b6-1be1-725f-82fd-7442c1f2ef78")

        assertEquals("2024-08-05T18:03:42.945Z", result)
    }

    @Test
    fun `should decode from uuid without dashes`() {
        val result = Decode.from("019123b61be1725f82fd7442c1f2ef78")

        assertEquals("2024-08-05T18:03:42.945Z", result)
    }
}