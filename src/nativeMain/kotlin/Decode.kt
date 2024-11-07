import kotlinx.datetime.Instant

object Decode {
    fun from(uuid: String): String =
        uuid.replace("-", "")
            .take(12)
            .let(::fromHexadecimal)
            .let(Instant.Companion::fromEpochMilliseconds)
            .toString()

    private fun fromHexadecimal(hexadecimal: String): Long = hexadecimal.toLong(16)
}