import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.datetime.Instant

class GenerateTest {
    @Test
    fun `should generate a random uuid`() {
        val uuid = Generate.now()
        assertTrue(uuid.matches(UUID_REGEX), "Generated UUID should match the expected format")
    }

    @Test
    fun `should generate a uuid from a OffsetDateTime`() {
        val instant = Instant.parse("2024-08-05T18:03:42.945Z")
        val uuid = Generate.at(instant)
        assertTrue(uuid.startsWith("019123b6-1be1-7"), "Generated UUID should wrap the provided timestamp")
        assertTrue(uuid.matches(UUID_REGEX), "Generated UUID should match the expected format")
    }

    @Test
    fun `should generate a uuid from an Instant`() {
        val instant = Instant.fromEpochMilliseconds(1722881022945)
        val uuid = Generate.at(instant)
        assertTrue(uuid.startsWith("019123b6-1be1-7"), "Generated UUID should wrap the provided timestamp")
        assertTrue(uuid.matches(UUID_REGEX), "Generated UUID should match the expected format")
    }

    companion object {
        private val UUID_REGEX = Regex("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}\$")
    }
}