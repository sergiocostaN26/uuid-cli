import kotlin.system.exitProcess
import kotlinx.datetime.Instant

fun main(args: Array<String>) {

    when {
        args.size == 1 && args[0] in listOf("-h", "--help") -> {
            // Print help
            println("""
                Usage: uuid [options] [arguments]

                Options:
                  -h, --help          Show this help message and exit
                
                Arguments:
                  (no arguments)      Generate a random UUID
                  <timestamp>         Generate a UUID based on the provided timestamp (in Long or OffsetDateTime format)
                  -d <UUID>           Decode the provided UUID and return the corresponding Instant
                
                Examples:
                  uuid                                          # Generates a random UUID
                  uuid 1627846261                               # Generates a UUID based on the provided timestamp
                  uuid 2024-11-07T21:00:49.963Z                 # Generates a UUID based on the provided timestamp
                  uuid -d 019123b6-1be1-725f-82fd-7442c1f2ef78  # Decodes the provided UUID and returns the corresponding OffsetDateTime
            """.trimIndent())
        }
        args.isEmpty() -> {
            // No parameters, generate a random UUID
            println(Generate.now())
        }
        args.size == 1 && !args[0].startsWith("-") -> {
            // One parameter, generate a UUID based on an Instant
            val instant = args[0].asInstant()
            println(Generate.at(instant))
        }
        args.size == 2 && args[0] == "-d" -> {
            // Two parameters, decode the UUID
            val uuid = args[1]
            println(Decode.from(uuid))
        }
        else -> {
            println("Invalid arguments")
            exitProcess(1)
        }
    }
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
