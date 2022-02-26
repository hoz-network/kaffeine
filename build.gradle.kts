import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20-M1"
    id("org.screamingsandals.plugin-builder") version "1.0.76"
}

group = "network.hoz"
version = "1.0.0-SNAPSHOT"

apply {
    plugin("java-library")
    plugin("idea")
    plugin("org.screamingsandals.plugin-builder")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.github.ben-manes.caffeine", "caffeine", "3.0.5")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}