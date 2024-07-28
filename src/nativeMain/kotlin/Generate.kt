import kotlin.random.Random
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

private const val VERSION: Long = 7
private const val VARIANT: Long = 0b10
private const val RANDOM_A_TOP_LIMIT: Long = 0x1000 // 12 random bits
private const val RANDOM_B_TOP_LIMIT: Long = 0x4000000000000000 // 62 random bits

object Generate {

    fun now(): String = Clock.System.now().let(::generateWith)

    fun at(instant: Instant): String = generateWith(instant)

    private fun generateWith(instant: Instant): String {
        val timestamp = instant.toEpochMilliseconds()
        val randomA = Random.nextLong(RANDOM_A_TOP_LIMIT)
        val randomB = Random.nextLong(RANDOM_B_TOP_LIMIT)
        return setOf(
            timestamp shr 16 to 8,
            timestamp and 0xffff to 4,
            (VERSION shl 12) + randomA to 4,
            (VARIANT shl 14) + (randomB shr 48) to 4,
            randomB and 0xffffffffffff to 12
        ).joinToString("-") { (value, length) ->
            value.asHexWithLength(length)
        }
    }

    private fun Long.asHexWithLength(length: Int) = toString(16).padStart(length, '0')
}