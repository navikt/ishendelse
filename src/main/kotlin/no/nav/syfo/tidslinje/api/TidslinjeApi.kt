package no.nav.syfo.tidslinje.api

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import no.nav.syfo.domain.PersonIdentNumber
import no.nav.syfo.tidslinje.HendelseService
import no.nav.syfo.tidslinje.api.domain.TidslinjePersonDTO
import no.nav.syfo.tidslinje.domain.toOppfolgingstilfellePersonDTO
import no.nav.syfo.util.NAV_PERSONIDENT_HEADER
import no.nav.syfo.util.personIdentHeader

const val hendelseApiV1Path = "/api/internad/v1/tidslinje"
const val hendelseApiPersonIdentPath = "/personident"

fun Route.registerTidslinjeApi(
    hendelseService: HendelseService,
) {
    route(hendelseApiV1Path) {
        get(hendelseApiPersonIdentPath) {
            val personIdentNumber = personIdentHeader()?.let { personIdent ->
                PersonIdentNumber(personIdent)
            }
                ?: throw IllegalArgumentException("Could not retrieve OppfolgingstilfelleDTO: No $NAV_PERSONIDENT_HEADER supplied in request header")

            val tidslinjePersonDTO: TidslinjePersonDTO =
                hendelseService.hendelseList(
                    personIdentNumber = personIdentNumber,
                ).toOppfolgingstilfellePersonDTO(
                    personIdentNumber = personIdentNumber,
                )

            call.respond(tidslinjePersonDTO)
        }
    }
}
