plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "catalog-admin"
include("domain")
include("application")
include("infrastructure")
