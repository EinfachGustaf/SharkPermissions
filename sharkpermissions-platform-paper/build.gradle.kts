val javaVersion = 17

plugins {
    kotlin("jvm")
    id("io.papermc.paperweight.userdev") version "1.5.11"
    id("xyz.jpenilla.run-paper") version "2.2.2"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "live.einfachgustaf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sharkpermissions-api"))
    implementation(project(":sharkpermissions-database"))
    implementation(project(":sharkpermissions-database-mongodb"))
    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.20.2")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(javaVersion)
    }
    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
    shadowJar {
        fun reloc(pkg: String) = relocate(pkg, "live.einfachgustaf.sharkpermissions.dependency.$pkg")
        reloc("net.axay")
    }
}

kotlin {
    jvmToolchain(17)
}