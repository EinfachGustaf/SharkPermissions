plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "SharkPermissions"
include("sharkpermissions-api")
include("sharkpermissions-database")
include("sharkpermissions-database-mongodb")
