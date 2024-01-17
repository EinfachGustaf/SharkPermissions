plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
}

group = "live.einfachgustaf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sharkpermissions-api"))
    implementation(project(":sharkpermissions-database"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("org.litote.kmongo:kmongo:4.11.0-serialization")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}