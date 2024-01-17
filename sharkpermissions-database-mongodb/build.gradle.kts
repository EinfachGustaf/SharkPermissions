plugins {
    kotlin("jvm")
}

group = "live.einfachgustaf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sharkpermissions-api"))
    implementation(project(":sharkpermissions-database"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}