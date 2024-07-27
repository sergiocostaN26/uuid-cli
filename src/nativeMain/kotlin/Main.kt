import kotlin.random.Random
import kotlinx.datetime.Clock

private val NOW = Clock.System.now()
private val epochSeconds: Long = NOW.epochSeconds
private val nanos: Int = NOW.nanosecondsOfSecond
private const val VERSION: Long = 7
private const val VARIANT: Long = 2
private fun getSequence(): Int =
    TODO("No bits reserved to avoid clashes between UUIDs generated on the same nanosecond with the same random bits")

//private fun getRandom(): Long = Random.nextLong(0x10000000000) // 40 bits if sequence bits were generated
private val random: Long = Random.nextLong(0x1000000000000) // 48 bits

private fun Int.getFirstChunk() = (((this shr 14) shr 12) and 0xfff).toLong()
private fun Int.getSecondChunk() = ((this shr 14) and 0xfff).toLong()
private fun Int.getThirdChunk() = (this and 0x3fff).toLong()

fun main(args: Array<String>) {


    val uuid = setOf(
        (epochSeconds shr 4).toString(16).padStart(8, '0'),
        ((epochSeconds and 0b1111 shl 12) + nanos.getFirstChunk()).toString(16).padStart(4, '0'),
        ((VERSION shl 12) + nanos.getSecondChunk()).toString(16).padStart(4, '0'),
        ((VARIANT shl 14) + nanos.getThirdChunk()).toString(16).padStart(4, '0'),
        random.toString(16).padStart(12, '0')
    )

    println(uuid.joinToString("-"))
}