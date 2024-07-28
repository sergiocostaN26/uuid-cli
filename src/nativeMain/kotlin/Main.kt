import kotlin.random.Random
import kotlinx.datetime.Clock

private val UNIX_TS_MS: Long = Clock.System.now().toEpochMilliseconds()
private const val VERSION: Long = 7
private const val VARIANT: Long = 0b10
private val RAND_A: Long = Random.nextLong(0xfff) // 12 bits
private val RAND_B: Long = Random.nextLong(0x3fffffffffffffff) // 62 bits

private fun Long.asHexWithLength(length: Int) = toString(16).padStart(length, '0')

fun main(args: Array<String>) {
    val uuid = setOf(
        (UNIX_TS_MS shr 16).asHexWithLength(8),
        (UNIX_TS_MS and 0xffff).asHexWithLength(4),
        ((VERSION shl 12) + RAND_A).asHexWithLength(4),
        ((VARIANT shl 14) + (RAND_B shr 48)).asHexWithLength(4),
        (RAND_B and 0xffffffffffff).asHexWithLength(12)
    )
    println(uuid.joinToString("-"))
}