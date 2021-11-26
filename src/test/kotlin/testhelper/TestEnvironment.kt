package testhelper

import no.nav.syfo.application.*

fun testEnvironment(
    azureOpenIdTokenEndpoint: String = "azureTokenEndpoint",
) = Environment(
    azureAppClientId = "ishendelse-client-id",
    azureAppClientSecret = "ishendelse-secret",
    azureAppWellKnownUrl = "wellknown",
    azureOpenidConfigTokenEndpoint = azureOpenIdTokenEndpoint,
    ishendelseDbHost = "localhost",
    ishendelseDbPort = "5432",
    ishendelseDbName = "ishendelse_dev",
    ishendelseDbUsername = "username",
    ishendelseDbPassword = "password",
)

fun testAppState() = ApplicationState(
    alive = true,
    ready = true,
)
