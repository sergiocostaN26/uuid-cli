import kotlin.system.exitProcess
import kotlinx.datetime.Instant

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        Generate.now()
    } else {
        args[0].asInstant().let(Generate::at)
    }.let(::println)
}

private fun String.asInstant(): Instant {
    val fromLong = runCatching { Instant.fromEpochMilliseconds(this.toLong()) }.getOrNull()
    val fromOffsetTimestamp = runCatching { Instant.parse(this) }.getOrNull()
    return when {
        fromLong != null -> fromLong
        fromOffsetTimestamp != null -> fromOffsetTimestamp
        else -> {
            println("The timestamp provided cannot be parsed")
            exitProcess(1)
        }
    }
}
