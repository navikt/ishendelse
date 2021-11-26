package no.nav.syfo.tidslinje.domain

import java.time.LocalDateTime

data class Hendelse(
    val name: String,
    val time: LocalDateTime,
    val type: String,
)
