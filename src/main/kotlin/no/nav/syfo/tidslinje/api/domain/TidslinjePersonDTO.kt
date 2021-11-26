package no.nav.syfo.tidslinje.api.domain

import java.time.LocalDateTime

data class TidslinjePersonDTO(
    val hendelseList: List<HendelseDTO>,
    val personIdent: String,
)

data class HendelseDTO(
    val time: LocalDateTime,
    val name: String,
    val type: String,
)
