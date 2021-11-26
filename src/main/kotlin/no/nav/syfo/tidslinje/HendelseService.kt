package no.nav.syfo.tidslinje

import no.nav.syfo.domain.PersonIdentNumber
import no.nav.syfo.tidslinje.domain.Hendelse
import java.time.LocalDateTime

class HendelseService {
    fun hendelseList(
        personIdentNumber: PersonIdentNumber,
    ): List<Hendelse> =
        listOf(
            Hendelse(
                name = "MOTEBEHOV_SVAR_MOTTATT",
                time = LocalDateTime.now(),
                type = "MOTEBEHOV",
            )
        )
}
