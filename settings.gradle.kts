pluginManagement {
    repositories {
        gradlePluginPortal()
        // PaperMC Repo
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "SharkPermissions"
include("sharkpermissions-api")
include("sharkpermissions-database")
include("sharkpermissions-database-mongodb")
include("sharkpermissions-platform-paper")
